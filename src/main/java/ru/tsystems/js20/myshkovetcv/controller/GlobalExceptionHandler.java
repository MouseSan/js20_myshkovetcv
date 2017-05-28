package ru.tsystems.js20.myshkovetcv.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * This method return page with information about exception/error
     * @param e exception
     * @return generalException.jsp
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView handleGlobalException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("pageGeneralErrorHandler");

        return modelAndView;
    }

    @ExceptionHandler(NullPointerException.class)
    public ModelAndView handleNpeException(Exception e) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("exception", e);
        modelAndView.setViewName("pageGeneralErrorHandler");

        return modelAndView;
    }
}
