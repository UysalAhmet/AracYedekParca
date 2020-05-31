/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import entity.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author ahmet
 */
@WebFilter("/*")
public class LoginFilter implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    
        HttpServletRequest req =(HttpServletRequest) request;
        HttpServletResponse res =(HttpServletResponse) response;
    
        String url = req.getRequestURI();
        
        User user =(User)req.getSession().getAttribute("valid_user");
       
        if(user==null){
            
            if(url.contains("Form")|| url.contains("Logout")){
                res.sendRedirect("http://localhost:8080/AracYedekParcaDemo/module/Login/Login.xhtml");
            }else{
                chain.doFilter(request, response);
            }
        } else{
            if(url.contains("Login")/*||url.contains("normalKullanici")*/){
                res.sendRedirect("http://localhost:8080/AracYedekParcaDemo/module/index.xhtml");
                
            }else if(url.contains("Logout")){
                req.getSession().invalidate();
                res.sendRedirect("http://localhost:8080/AracYedekParcaDemo/module/Login/Login.xhtml");
           }else{
                chain.doFilter(request, response);
            }
            
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     }

    @Override
    public void destroy() {
    }

}
