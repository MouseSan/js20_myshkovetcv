package ru.tsystems.js20.myshkovetcv.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * This method return page with information about exception/error
     * @param e exception
     * @return generalException.jsp
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("pageGeneralErrorHandler");
        logger.warn("Error occurred: {}", e.getMessage());
        return modelAndView;
    }
}
