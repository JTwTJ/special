package com.jwt.special.controller;

import com.github.pagehelper.PageInfo;
import com.jwt.special.model.Transact;
import com.jwt.special.model.dto.TransactDto;
import com.jwt.special.model.request.TransactQueryParam;
import com.jwt.special.service.TransactService;
import com.jwt.special.web.NeedLoggedUser;
import com.jwt.special.web.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

   /* @NeedLoggedUser
    @ResponseBody
    @RequestMapping(value = "/pager", method = RequestMethod.POST)
    public Result<PageInfo<Transact>> pager(TransactQueryParam transactQueryParam, HttpSession session) throws Exception {
        try {
            PageInfo<Transact> pageInfo = transactService.pager(transactQueryParam);
            session.setAttribute("page", pageInfo);
            return Result.ok(pageInfo);
        } catch (Exception e) {
            log.warn("pager fail :{}",e);
            return Result.fail("分页查询失败");
        }
    }*/
    @RequestMapping(value = "/pager", method = RequestMethod.GET)
    public String supervise(@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize, Model model) {
        TransactQueryParam transactQueryParam = new TransactQueryParam();
        transactQueryParam.setPageNo(pageNum);
        transactQueryParam.setPageSize(pageSize);
        PageInfo<Transact> pageInfo = transactService.pager(transactQueryParam);
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
        return "view/supervise/supervise-list";
    }
}