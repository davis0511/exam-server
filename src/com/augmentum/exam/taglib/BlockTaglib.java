package com.augmentum.exam.taglib;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.context.ApplicationContext;

import com.augmentum.common.BlockAbstract;
import com.augmentum.exam.util.SpringUtil;

public class BlockTaglib extends TagSupport {

    private static final long serialVersionUID = 1L;

    private String name;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public int doStartTag() throws JspException {
        return SKIP_BODY;
    }

    @Override
    public int doEndTag() throws JspException {
        ApplicationContext ctx = SpringUtil.getApplicationContext();
        BlockAbstract block = (BlockAbstract)ctx.getBean(name);
        String content = block.displayBlock(pageContext);
        JspWriter out = pageContext.getOut();
        try {
            out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.doEndTag();
    }

    @Override
    public void release() {
        super.release();
    }
}
