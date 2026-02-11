package com.incri.core.web.filter;

import org.slf4j.MDC;

import javax.servlet.*;
import java.io.IOException;
import java.util.UUID;

public class RequestIdFilter implements Filter {

  public static final String MDC_KEY = "requestId";

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {

    try {
      String rid = UUID.randomUUID().toString().replace("-", "");
      MDC.put(MDC_KEY, rid);
      chain.doFilter(request, response);
    } finally {
      MDC.remove(MDC_KEY);
    }
  }
}
