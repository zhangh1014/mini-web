package org.lechisoft.minifw.web;

import javax.servlet.ServletContext;

public class MiniContextUtil {
    private static ServletContext servletContext = null;

    /**
     * 获取Servlet上下文
     * 
     * @return Servlet上下文
     */
    public static ServletContext getServletContext() {
        return servletContext;
    }

    /**
     * 设置Servlet上下文
     * 
     * @param servletContext
     *            Servlet上下文
     */
    public static void setServletContext(ServletContext servletContext) {
        MiniContextUtil.servletContext = servletContext;
    }

    /**
     * 获取物理路径
     * 
     * @param path
     *            虚拟路径
     * @return 物理路径
     */
    public static String getRealPath(String path) {
        path = path == null ? "/" : path;
        path = path.startsWith("/") ? path : "/" + path;

        if (MiniContextUtil.getServletContext() == null) {
            return System.getProperty("user.dir") + path.replace("/", "\\");
        }

        return MiniContextUtil.getServletContext().getRealPath(path);
    }
}
