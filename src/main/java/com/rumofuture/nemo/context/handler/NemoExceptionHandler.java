package com.rumofuture.nemo.context.handler;

import com.rumofuture.nemo.context.exception.NemoException;
import com.rumofuture.nemo.model.entity.Response;
import com.rumofuture.nemo.util.constant.RespStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author WangZhenqi
 */
@RestControllerAdvice
public class NemoExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(NemoExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public Response<Object> handleException(Exception e) {
        return new Response<>(RespStatus.SYSTEM_ERROR);
    }

    @ExceptionHandler(value = NemoException.class)
    public Response<Object> handleNemoException(NemoException e) {
        return new Response<>(e.getStatusCode());
    }
}
