package com.znaji.springwebtasks.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.util.StopWatch;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MeasurementInterceptor implements HandlerInterceptor {

    public static final String STOP_WATCH = "stopWatch";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        var sw = new StopWatch();
        sw.start();
        request.setAttribute(STOP_WATCH, sw);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        var sw = (StopWatch) request.getAttribute(STOP_WATCH);
        sw.stop();
        modelAndView.addObject("time", sw.getTotalTimeMillis());
    }
}
