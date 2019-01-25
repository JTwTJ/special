package com.jwt.special.controller;

import com.jwt.special.model.Dictionary;
import com.jwt.special.service.DictionaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.nio.cs.ext.MacArabic;

import java.util.List;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2019/1/24 0024 上午 10:23
 */
@Controller
@Slf4j
@RequestMapping("/dictionary")
public class DictionaryController {

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value = "/queryList", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,List<Dictionary>> queryList() {
        Map<String, List<Dictionary>> map = dictionaryService.queryList();
        return map;
    }

}
