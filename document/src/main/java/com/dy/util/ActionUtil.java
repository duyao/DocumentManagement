package com.dy.util;

import com.opensymphony.xwork2.ActionContext;

public class ActionUtil {
	public final static String REDIRECT = "redirect";

	public static void setURL(String url) {
		ActionContext.getContext().put("url", url);
	}

	public static boolean isEmpty(String string) {
		if (string == null || string.length() == 0) {
			return true;
		}
		return false;

	}

}
