package com.dy.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import com.dy.model.SystemContext;

public class SystemContextFilter implements Filter {
	private int pageSize;

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		try {
			int tmp = pageSize;
			try {
				tmp = Integer.parseInt(req.getParameter("pageSize"));
			} catch (Exception e) {
				
			}
			int pageOffset = 0;
			try {
				pageOffset = Integer.parseInt(req.getParameter("pageOffset"));
			} catch (Exception e) {
				
			}
			SystemContext.setPageOffset(pageOffset);
			SystemContext.setPageSize(tmp);
			chain.doFilter(req, resp);

		} catch (Exception e) {
		}finally{
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
		}
				
			
	}

	public void init(FilterConfig cfg) throws ServletException {
		pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
	}

}
