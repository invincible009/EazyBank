package com.sdl.eazybank.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.servlet.*;
import java.io.IOException;

public class AuthoritiesLoggingAfterFilter implements Filter {
    private Logger logger = LoggerFactory.getLogger(AuthoritiesLoggingAfterFilter.class);
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            if (null != authentication) {
                logger.info("User " + authentication.getName() + " is successfully authenticated and "
                        + "has the authorities " + authentication.getAuthorities().toString());
            }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
