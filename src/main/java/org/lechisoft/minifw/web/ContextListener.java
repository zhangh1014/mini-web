package org.lechisoft.minifw.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.lechisoft.minifw.log.MiniLog;

@WebListener
/**
 * 监听Servlet上下文的启动和销毁
 * 
 * @author Hao
 */
public class ContextListener implements ServletContextListener {

    public static final String ROOT_PATH_KEY = "rootPath";

    /**
     * 监听Servlet上下文的启动
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        MiniLog.debug(ContextListener.class.getName() + " -> "
                + Thread.currentThread().getStackTrace()[1].getMethodName() + " begin.");

        ServletContext servletContext = servletContextEvent.getServletContext();
        MiniContextUtil.setServletContext(servletContext);

        String rootPath = MiniContextUtil.getRealPath("/");
        // 设置系统变量
        System.setProperty(ROOT_PATH_KEY, rootPath);
        // 重新加载日志配置
        MiniLog.configure();
        MiniLog.debug("Set " + ROOT_PATH_KEY + "=" + rootPath);

        MiniLog.debug(ContextListener.class.getName() + " -> "
                + Thread.currentThread().getStackTrace()[1].getMethodName() + " end.");
    }

    /**
     * 监听Servlet上下文的销毁
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        MiniContextUtil.setServletContext(null);
    }
}
