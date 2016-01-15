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
//			System.out.println("filter"+pageSize);
			try {
				tmp = Integer.parseInt(req.getParameter("pageSize"));
			} catch (Exception e) {
				//e.printStackTrace();
			}
			int pageOffset = 0;
			try {
				pageOffset = Integer.parseInt(req.getParameter("pageOffset"));
			} catch (Exception e) {
				//e.printStackTrace();
			}
//			System.out.println(pageOffset);
//			System.out.println(tmp);
			SystemContext.setPageOffset(pageOffset);
			SystemContext.setPageSize(tmp);
			chain.doFilter(req, resp);

		} catch (Exception e) {
			//e.printStackTrace();
		}finally{
			SystemContext.removePageOffset();
			SystemContext.removePageSize();
		}
				
			
	}

	public void init(FilterConfig cfg) throws ServletException {
		pageSize = Integer.parseInt(cfg.getInitParameter("pageSize"));
		System.out.println("init+"+pageSize);
	}

}
