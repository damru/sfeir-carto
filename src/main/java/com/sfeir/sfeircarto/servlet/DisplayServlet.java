package com.sfeir.sfeircarto.servlet;

import com.sfeir.sfeircarto.neo4j.domain.Person;
import com.sfeir.sfeircarto.neo4j.service.Neo4jService;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import javax.inject.Inject;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by rubio.d on 13/10/2016.
 */
public class DisplayServlet extends HttpServlet {

    @Inject
    private Neo4jService neo4jService;

    @Override
    public void init(final ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String resultat;
        try {
            resultat = displayDb();
        } catch (UnsupportedOperationException e) {
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

    private String displayDb()  {
        String persons = "";
        List<Person> personList = neo4jService.getAllPersons();
        for (Person p : personList ) {
            persons = persons.concat(p.toString());
        }
        return persons;
    }
}
