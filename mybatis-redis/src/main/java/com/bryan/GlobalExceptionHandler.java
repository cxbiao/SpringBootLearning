package com.bryan;


import com.bryan.domain.APIResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

//统一错误处理,不能拦截404错误
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler  {

    private Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public APIResponse<String> handlerException(HttpServletRequest req, Throwable ex) throws Throwable {

        APIResponse<String> errorInfo=new APIResponse<>();
        errorInfo.setMessage(ex.getMessage());
        errorInfo.setCode(-1);
        errorInfo.setPath(req.getRequestURI());
        logger.error(ex.getMessage(),ex);
        return errorInfo;
    }

}
