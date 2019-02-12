package com.jwt.special.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.github.pagehelper.PageInfo;
import com.jwt.special.model.Dictionary;
import com.jwt.special.model.Transact;
import com.jwt.special.model.User;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.model.request.TransactAddParam;
import com.jwt.special.model.request.TransactQueryParam;
import com.jwt.special.service.DictionaryService;
import com.jwt.special.service.TransactService;
import com.jwt.special.util.ExcelUtil;
import com.jwt.special.util.UserUtil;
import com.jwt.special.web.NeedLoggedUser;
import com.jwt.special.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2019/1/2 0002 下午 2:57
 */
@Controller
@RequestMapping(value = "/transact")
@Slf4j
public class TransactController {

    @Autowired
    private TransactService transactService;

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    public String pager(TransactQueryParam transactQueryParam, @RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, Model model) {
        transactQueryParam.setPageNo(pageNum);
        transactQueryParam.setPageSize(pageSize);
        try {
            PageInfo<TransactDto> pageInfo = transactService.pager(transactQueryParam);
            Map<String, List<Dictionary>> map = dictionaryService.queryList();
            model.addAttribute("form", transactQueryParam);
            model.addAttribute("map", map);
            model.addAttribute("pageList", pageInfo.getList());
            //获得当前页
            model.addAttribute("pageNum", pageInfo.getPageNum());
            //获得一页显示的条数
            model.addAttribute("pageSize", pageInfo.getPageSize());
            //是否是第一页
            model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
            //获得总页数
            model.addAttribute("totalPages", pageInfo.getPages());
            //总条数
            model.addAttribute("total", pageInfo.getTotal());
            //是否是最后一页
            model.addAttribute("isLastPage", pageInfo.isIsLastPage());
            //所有导航页号
            model.addAttribute("navigatePageNum", pageInfo.getNavigatepageNums());
        } catch (Exception e) {
            log.warn("pager fail:{}", e);
        }

        return "view/supervise/supervise-list";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(TransactAddParam transactAddParam, HttpSession session) {
        try {
            String operator = (String) session.getAttribute("username");
        } catch (Exception e) {
            log.warn("add transact fail:{}", e);
        }
        return "redirect:/transact/pager";
    }
    @RequestMapping(value = "/queryById", method = RequestMethod.GET)
    @ResponseBody
    public TransactDto queryById(@RequestParam Long transactId, Model model) {
        try {
            TransactDto transactDto = transactService.queryById(transactId);
            System.out.println(transactDto);
            model.addAttribute("transactDto",transactDto);
            return transactDto;
        } catch (Exception e) {
            log.warn("queryById fail:{}",e);
            return null;
        }
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(TransactAddParam transactAddParam, HttpSession session) {
        try {
            String operator = (String) session.getAttribute("username");
            transactAddParam.setOperator(operator);
            System.out.println(transactAddParam);
            transactService.update(transactAddParam);
        } catch (Exception e) {
            log.warn("update transact fail:{}", e);
        }
        return "redirect:/transact/pager";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public void delete(@RequestParam Long transactId) {
        try {
           transactService.delete(transactId);
        } catch (Exception e) {
            log.warn("delete transact fail:{}", e);
        }
    }

    @RequestMapping(value = "/export", method = RequestMethod.GET)
    public void export(HttpServletResponse response) throws IOException {
        List<TransactDto> transactList = transactService.queryAll();
        //到处excel
        LinkedHashMap<String, String> fieldMap = new LinkedHashMap<>();
        fieldMap.put("fileName", "文件名称");
        fieldMap.put("fileTime", "收文日期");
        fieldMap.put("phone", "电话");
        fieldMap.put("plateValue", "板块");
        fieldMap.put("companyNameValue", "公司名称");
        fieldMap.put("functionsValue", "职能中心");
        fieldMap.put("leaderValue", "领导流转部门");
        fieldMap.put("remark", "备注");
        fieldMap.put("handleTime", "批示日期");
        fieldMap.put("handleIdea", "批示意见");
        fieldMap.put("operator", "操作人");
        fieldMap.put("createTime", "创建时间");
        fieldMap.put("updateTime", "修改时间");
        String sheetName = "督办表";
        response.setContentType("application/octet-stream");
        response.setHeader("Content-disposition", "attachment;filename=Transact.xls");//默认Excel名称
        response.flushBuffer();
        OutputStream fos = response.getOutputStream();
        try {
            ExcelUtil.listToExcel(transactList, fieldMap, sheetName, fos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}