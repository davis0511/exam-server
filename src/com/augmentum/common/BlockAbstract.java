package com.augmentum.common;

import java.io.StringWriter;
import java.io.Writer;

import javax.servlet.jsp.PageContext;

import org.apache.log4j.Logger;
import com.augmentum.exam.Constants;

public abstract class BlockAbstract {

    private static Logger log = Logger.getLogger(BlockAbstract.class);

    public String template;

    public String getTemplate() {
        return template;
    }
    public void setTemplate(String template) {
        this.template = template;
    }

    public String displayBlock(PageContext pageContext) {
        execute(pageContext);
        Writer body = new StringWriter();
        try {
            if (template != null && !template.trim().equals("")) {
                pageContext.pushBody(body);
                pageContext.include(template);
                pageContext.popBody();
                return body.toString();
            }
        } catch (Exception ex) {
            log.error(Constants.BLOCK_EXCEPTION, ex);
            ex.printStackTrace();
        } finally {
            try {
                body.close();
            } catch (Exception e) {
                log.error(Constants.BODY_APPEAR, e);
                e.printStackTrace();
            }
        }
        return null;
    }

    public abstract void execute(PageContext pageContext);
}
