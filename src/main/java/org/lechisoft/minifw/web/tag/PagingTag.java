package org.lechisoft.minifw.web.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class PagingTag extends TagSupport {
    private static final long serialVersionUID = 1L;

    private String id = "";
    private Integer gotoPage = 1;
    private Integer totalPage = 1;
    private String handler = "";

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getGotoPage() {
        return gotoPage;
    }

    public void setGotoPage(Integer gotoPage) {
        this.gotoPage = gotoPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public int doStartTag() throws JspException {

        try {

            JspWriter out = this.pageContext.getOut();

            out.println("<div id='" + id + "'></div>");

            out.println("<script>");
            out.println("if(__lcsjs == undefined){");
            out.println("    __lcsjs = new new LechisoftJs();");
            out.println("}");
            out.println("var __paging = __lcsjs.paging;");
            out.println("__paging.init('" + id + "','" + gotoPage + "','" + totalPage + "', '" + handler + "');");
            out.println("</script>");

        } catch (Exception e) {

            throw new JspException(e.getMessage());

        }

        return SKIP_BODY;
    }

    @Override

    public int doEndTag() throws JspException {

        return EVAL_PAGE;

    }

}
