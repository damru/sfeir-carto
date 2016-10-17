package com.sfeir.sfeircarto.servlet;

import com.sfeir.sfeircarto.neo4j.service.Neo4jService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by rubio.d on 13/10/2016.
 */
public class InitServlet extends HttpServlet {

//    private ApplicationContext context;

    @Inject
    private Neo4jService neo4jService;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);

//        this.context = WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String resultat;
        try {
            initDb();
            resultat = "OK";
        } catch (IOException e) {
            resultat = "KO<br>"+e.getStackTrace();
        }
        // Set response content type
        resp.setContentType("text/html");
        resp.getWriter().println("<h1>" + resultat + "</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }

    private void initDb() throws IOException {
    }
}
