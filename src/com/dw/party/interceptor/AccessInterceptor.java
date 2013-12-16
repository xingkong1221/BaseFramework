package com.dw.party.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.dw.party.base.data.support.dto.UserPreferences;
import com.dw.party.base.data.support.global.GlobalDefine;
import com.dw.party.base.data.support.service.ISystemBaseService;

/**
 * 应用全局拦截器
 * @author xingkong1221
 *
 */
public class AccessInterceptor extends HandlerInterceptorAdapter {
	
	private BeanFactory beanFactory;
	
	/**
	 * 静态资源服务器地址
	 */
	private static String SM_IDX = "";
	
	/**
	 * 静态资源服务器地址
	 */
	private static String RM_IDX = "";
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		String userId = request.getParameter("userId");
		String token = request.getParameter("token");
		UserPreferences user = (UserPreferences) request.getSession().getAttribute(GlobalDefine.PAGE_SERVER_DEFINE.SESSION_USER);
		
		if (user != null) {
			if (StringUtils.isEmpty(userId)) {
				userId = user.getUserId();
			}
			
			if (StringUtils.isEmpty(token)) {
				token = user.getToken();
			}
		}
		
		String platformId = request.getParameter("platformId");
		if (!StringUtils.isEmpty(platformId)) {
			request.getSession().setAttribute("platformId", platformId);
			request.setAttribute("platformId", platformId);
		}
		
		if (StringUtils.isEmpty(SM_IDX)) {
			SM_IDX = getSystemBaseService().findSysManageIndex();
		}
		if (StringUtils.isEmpty(RM_IDX)) {
			RM_IDX = getSystemBaseService().findPageServerAddress();
		}
		
		String smIdx = SM_IDX;
		if (user != null) {
			if (smIdx.indexOf("\\?") < 0)
				smIdx = smIdx + "?userId=" + userId + "&token=" + token
						+ "&platformId=" + platformId;
			else {
				smIdx = smIdx + "&userId=" + userId + "&token=" + token
						+ "&platformId=" + platformId;
			}
		}
		request.setAttribute("SYSTEM_MANAGE_URL", smIdx);
		request.setAttribute("_CTX_PATH_", request.getContextPath());
		request.setAttribute("_RM_", RM_IDX);
		request.setAttribute("_SKIN_", user.getSkin());
		return true;
	}
	
	/**
	 * 获取系统基础服务
	 * @return
	 */
	public ISystemBaseService getSystemBaseService() {
		return (ISystemBaseService) beanFactory.getBean(GlobalDefine.BASE_SERVER_DEFINE.BASE_DATA_SERVER_NAME); 
	}

	public static String getSM_IDX() {
		return SM_IDX;
	}

	public static void setSM_IDX(String sM_IDX) {
		SM_IDX = sM_IDX;
	}

	public BeanFactory getBeanFactory() {
		return beanFactory;
	}

	@Autowired
	public void setBeanFactory(BeanFactory beanFactory) {
		this.beanFactory = beanFactory;
	}

	public static String getRM_IDX() {
		return RM_IDX;
	}

	public static void setRM_IDX(String rM_IDX) {
		RM_IDX = rM_IDX;
	}
	
}
