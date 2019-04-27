package com.yi23.springboot.response;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

/**
 * @Author : 王斌
 * @Date : 2019/3/4 下午5:18
 * @Description 描述
 */
@ControllerAdvice
@Slf4j
public class SystemExceptionHandler {

    /**
     *
     * @param request
     * @param response
     * @param handler
     * @param systemException
     * @return
     */
    @ResponseBody
    @ExceptionHandler({SystemException.class})
    public Response payExceptionHandle(HttpServletRequest request, HttpServletResponse response, Object handler, SystemException systemException) {
        Response baseResponse = new Response();
        baseResponse.setCode(systemException.getSystemExceptionEnum().getValue());
        baseResponse.setMessage((String)Optional.ofNullable(systemException.getMessage()).orElse("服务器繁忙"));
        if (DataUtils.isNotEmpty(systemException.getData())) {
            baseResponse.setData(systemException.getData());
        }

        log.debug("business err {} ", systemException.getMessage());
        return baseResponse;
    }
}
