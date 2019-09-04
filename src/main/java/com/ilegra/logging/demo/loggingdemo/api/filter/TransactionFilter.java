package com.ilegra.logging.demo.loggingdemo.api.filter;

import com.ilegra.logging.demo.loggingdemo.instrumentation.RequestInstrumentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Order(1)
public class TransactionFilter implements Filter {

    private final RequestInstrumentation instrumentation;

    @Autowired
    public TransactionFilter(RequestInstrumentation instrumentation) {
        this.instrumentation = instrumentation;
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;

        instrumentation.logIncommingRequest(req.getRequestURI());
        filterChain.doFilter(servletRequest, servletResponse);
        instrumentation.logEndOfRequest(req.getRequestURI());
    }
}
