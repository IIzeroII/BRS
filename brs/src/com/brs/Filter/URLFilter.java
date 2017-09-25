package com.brs.Filter;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.brs.pagemodel.PageAdmins;
import com.brs.utils.GActionUtils;
import com.brs.utils.GAnalyRequest;
/**
* 原理是，将所有的地址中包含敏感字符的访问拦截，将访问重定位到网站的跟目录
* @author zero
*/
public class URLFilter implements Filter{
 
     @Override
     public void destroy() {
         // TODO Auto-generated method stub
         
     }
 
     @Override
     public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterch) throws IOException, ServletException {
         // 获取请求的URL
         HttpServletRequest httpreq = (HttpServletRequest) request;
         StringBuffer url = httpreq.getRequestURL();
        //获取session对象中的参数(静态方法调用需要加类名,继承除外)
        PageAdmins adm = (PageAdmins) httpreq.getSession().getAttribute("adm");
 		/**
 		 * 用户不在线时拦截所有包含敏感字符的请求
 		 */
 		if(null == adm && (url.indexOf("index") > 0 || url.indexOf("rental") > 0 || url.indexOf("users") > 0 || url.indexOf("bicycle") > 0)){  //判断管理员是否在线和地址中是否包含敏感字符(如果要检索的字符串值没有出现，则该方法返回 -1)
 			HttpServletResponse httpres = (HttpServletResponse) response;
            httpres.sendRedirect(httpreq.getContextPath());  //跳转到网站根目录，也可以根据自己的需要重定位到自己的Action
            return;
 		}else{ //不包含敏感字符，则继续执行
            filterch.doFilter(request, response);   
        }
                  
     }
 
     @Override
     public void init(FilterConfig arg0) throws ServletException {
         // TODO Auto-generated method stub
         
     }
 
 }