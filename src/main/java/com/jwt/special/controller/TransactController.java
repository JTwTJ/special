package com.jwt.special.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.github.pagehelper.PageInfo;
import com.jwt.special.model.Dictionary;
import com.jwt.special.model.Transact;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.model.request.TransactAddParam;
import com.jwt.special.model.request.TransactQueryParam;
import com.jwt.special.service.DictionaryService;
import com.jwt.special.service.TransactService;
import com.jwt.special.web.NeedLoggedUser;
import com.jwt.special.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
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
    public String add(TransactAddParam transactAddParam) {
        try {
            transactService.add(transactAddParam);
        } catch (Exception e) {
            log.warn("add transact fail:{}", e);
        }
        return "redirect:/transact/pager";
    }
}