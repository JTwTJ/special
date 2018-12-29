package com.jwt.special.autoconfig;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.apache.catalina.util.ParameterMap;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author jiangwentao
 * @date 2018/12/27 0027 下午 3:13
 */

@Order(0)
@WebFilter(filterName = "ParameterFilter", urlPatterns = "/*")
@Slf4j
public class ParameterFilter implements Filter {

    @Override
    public void destroy() {
        log.info("ParameterFilter destroy");
    }
    @Override
    public void doFilter(ServletRequest req, ServletResponse rsp, FilterChain arg2)
            throws IOException, ServletException {
        if(req instanceof HttpServletRequest) {
            String uri = ((HttpServletRequest)req).getRequestURI();
            List<String> paramList=new ArrayList<>();
            Map<String, String[]> paramMap = req.getParameterMap();
            log.info("request uri:{},parameter:{}",uri,JSON.toJSONString(paramMap));

            //空字符串转NULL 统一解决方案
            for(Map.Entry<String, String[]> en:paramMap.entrySet()) {
                if(en.getValue().length==1 && StringUtils.isEmpty(en.getValue()[0])) {
                    paramList.add(en.getKey());
                }
            }
            if(!paramList.isEmpty() && req instanceof org.apache.catalina.connector.RequestFacade ) {
                org.apache.catalina.connector.RequestFacade tomcateReqFacade= (org.apache.catalina.connector.RequestFacade) req;

                try {
                    Field requestField=org.apache.catalina.connector.RequestFacade.class.getDeclaredField("request");
                    requestField.setAccessible(true);
                    org.apache.catalina.connector.Request tomcateReq= (Request) requestField.get(tomcateReqFacade);

                    ParameterMap<String, String[]> parameterMap=(ParameterMap<String, String[]>)paramMap;
                    parameterMap.setLocked(false);
                    for(String str:paramList) {
                        parameterMap.remove(str);
                        //					 tomcateReq.getCoyoteRequest().getParameters().addParameter(str, null);

                        Field  field=org.apache.tomcat.util.http.Parameters.class.getDeclaredField("paramHashValues");
                        field.setAccessible(true);
                        @SuppressWarnings("unchecked")
                        Map<String,ArrayList<String>> pp=(Map<String, ArrayList<String>>) field.get(tomcateReq.getCoyoteRequest().getParameters());
                        pp.put(str, new ArrayList<String>());
                    }
                    parameterMap.setLocked(true);
                } catch ( Exception e) {
                    log.error(e.getMessage(),e);
                }
            }

        }
        arg2.doFilter(req, rsp);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        log.info("ParameterFilter init");
    }
}
