package edu.eci.cvds.security;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

public class OnlyNotAutenticate extends AccessControlFilter{
	
	private String welcomeurl;

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue)
			throws Exception {
		Subject user = getSubject(request, response);
		return !user.isAuthenticated();
	}

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		welcomeurl = "/faces/login.xhtml";
		WebUtils.issueRedirect(request, response, welcomeurl);
		return false;
	}

	public String getWelcomeurl() {
		return welcomeurl;
	}

	public void setWelcomeurl(String welcomeurl) {
		this.welcomeurl = welcomeurl;
	}

}