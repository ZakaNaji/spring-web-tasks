package com.znaji.springwebtasks.court.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ExtensionInterceptor implements HandlerInterceptor {
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        var param = request.getParameter("mediaType");
        var date = request.getParameter("date").replace("-", "_");
        if (param != null) {
            var filename = "reservationSummary" + date + "." + param;
            response.setHeader("Content-Disposition", "attachment; filename=" + filename);
        }
    }
}
