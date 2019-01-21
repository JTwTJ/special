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

    @NeedLoggedUser
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
    }
}