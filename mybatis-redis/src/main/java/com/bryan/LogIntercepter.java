package com.bryan;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class LogIntercepter implements HandlerInterceptor {

    private Logger logger= LoggerFactory.getLogger(LogIntercepter.class);

    private long time;

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler) throws Exception {
        time=System.currentTimeMillis();
        logger.info("===========================begin============================");
        logger.info(httpServletRequest.getRequestURI());
        Map<String,String[]> requestMap=httpServletRequest.getParameterMap();
        if(requestMap!=null && requestMap.size()>0){
            StringBuilder sb=new StringBuilder();
            for(Map.Entry<String,String[]> entry:requestMap.entrySet()){
                String key=entry.getKey();
                String[] values=entry.getValue();
                StringBuilder sb2=new StringBuilder();
                for(String v:values){
                    sb2.append(v).append(",");
                }
                sb.append(key+":"+sb2.subSequence(0,sb2.length()-1).toString()).append(",");

            }
            logger.info(sb.subSequence(0,sb.length()-1).toString());
        }


        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object handler, Exception e) throws Exception {
        double consume=(System.currentTimeMillis()-time)/1000.0;
        logger.info("===========================end:"+consume+"s ============================");

    }
}
