package contrtollers;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.TaskList;
import utils.DBUtil;
@WebServlet(name = "index", urlPatterns = { "/index" })
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public IndexServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<TaskList> messages = em.createNamedQuery("getAllTaskList", TaskList.class)
                                   .getResultList();
        response.getWriter().append(Integer.valueOf(messages.size()).toString());

        em.close();
    }

}
