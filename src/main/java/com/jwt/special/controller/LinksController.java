package com.jwt.special.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jwt.special.model.Links;
import com.jwt.special.model.User;
import com.jwt.special.model.UserLinks;
import com.jwt.special.model.vo.LinksVo;
import com.jwt.special.service.LinksService;
import com.jwt.special.service.UserLinksService;
import com.jwt.special.util.UserUtil;
import com.jwt.special.web.NeedLoggedUser;
import com.jwt.special.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.*;

/**
 * @author jiangwentao
 * @date 2019/1/2 0002 下午 6:15
 */
@Controller
@RequestMapping("/links")
@Slf4j
public class LinksController {

    @Autowired
    private UserLinksService userLinksService;
    @Autowired
    private LinksService linksService;

    /**
     * 根据用户信息查询权限菜单
     * @return
     */
    @RequestMapping(value = "/queryCurrentUserSetUrl", method = RequestMethod.POST)
    @NeedLoggedUser
    @ResponseBody
    public Result<List<LinksVo>> queryCurrentUserSetUrl() {
        User userOper = UserUtil.getCurrentUser();
        log.info("current user user:{}", JSON.toJSONString(userOper));
        if (userOper == null) {
            return Result.fail("当前用户不存在!");
        }
        Long userId =  userOper.getUserId();
        List<UserLinks> linksList = userLinksService.queryByUserId(userId);
        /*GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();
        Gson gson = builder.create();

        List<LinksVo> lvList = new ArrayList<>();
        List<Links> links = linksService.findAll();
        for (UserLinks userLinks : linksList) {
            LinksVo linksVo = new LinksVo();
            linksVo.setLinkId(userLinks.getLinkId());
            *//*linksVo.setUserId(userLinks.getUserId());*//*
            linksVo.setPrivilege(userLinks.getPrivilege());
            List<Links> childList = new ArrayList<>();
            for (Links links1 : links) {
                if (userLinks.getLinkId().equals(links1.getLinkId())){
                    if (null!=links1.getParentId()&&!"".equals(links1.getParentId())){
                        childList.add(links1);
                    }
                }
            }
            linksVo.setChildren(childList);
            lvList.add(linksVo);
        }
        System.out.println(lvList);*/
        List<Links> links = linksService.findAll();
        HashSet<Links> linkSet = new HashSet<Links>();
        for(UserLinks ulTemp:linksList){
            String linkIdTemp = ulTemp.getLinkId();
            linksFor:for(Links link:links){
                if(link.getLinkId().equals(linkIdTemp)){
                    linkSet.add(link);
                    if(null!=link.getParentId()&&!"".equals(link.getParentId())){
                        linkSet.addAll(getParentLinks(link,links));
                    }
                    break linksFor;
                }
            }
        }
        List<LinksVo> linkResult=formatLinkset(linkSet);
        return Result.ok(linkResult);
    }

    //组装树形结构
    private List<LinksVo> formatLinkset(HashSet<Links> links){
        Map<String,LinksVo> linkMap=new HashMap<>();
        List<LinksVo> firstList=new ArrayList<>();
        for(Links lk:links){
            LinksVo plk=linkMap.get(lk.getParentId());
            if(plk==null){
                Links pk=linksService.getById(lk.getParentId());
                if(pk==null){
                    firstList.add(LinksVo.convert(lk));
                    continue;
                }
                plk=LinksVo.convert(pk,new ArrayList<LinksVo>());
                linkMap.put(lk.getParentId(), plk);
            }
            plk.getChildren().add(LinksVo.convert(lk));
        }
        for(LinksVo lvo:firstList){
            LinksVo vos = linkMap.get(lvo.getLinkId());

            if(null!=vos&&null!=vos.getChildren()){
                List<LinksVo> childrenList = vos.getChildren();
                Collections.sort(childrenList);
                lvo.setChildren(childrenList);
            }
        }

        Collections.sort(firstList);
        return firstList;
    }
    //组装树形结构
    /*private List<LinksVo> formatLinks(List<Links> links){
        Map<String,LinksVo> linkMap=new HashMap<>();
        List<LinksVo> firstList=new ArrayList<>();
        for(Links lk:links){
            LinksVo plk=linkMap.get(lk.getParentId());
            if(plk==null){
                Links pk=linksService.getById(lk.getParentId());
                if(pk==null){
                    firstList.add(LinksVo.convert(lk));
                    continue;
                }
                plk=LinksVo.convert(pk,new ArrayList<LinksVo>());
                linkMap.put(lk.getParentId(), plk);
            }
            plk.getChildren().add(LinksVo.convert(lk));
        }
        for(LinksVo lvo:firstList){
            LinksVo vos = linkMap.get(lvo.getLinkId());
            if(null!=vos&&null!=vos.getChildren()){
                lvo.setChildren(vos.getChildren());
            }
        }

        return firstList;
    }*/

    private List<Links> getParentLinks(Links link,List<Links> links){
        List<Links> linkList = new ArrayList<Links>();
        for(Links linkTemp:links){
            if(linkTemp.getLinkId().equals(link.getParentId())){
                linkList.add(linkTemp);
                if(null!=linkTemp.getParentId()&&!"".equals(linkTemp.getParentId())){
                    linkList.addAll(getParentLinks(linkTemp,links));
                }
            }
        }
        return linkList;
    }
}
