package edu.time.manager.servlets;

import edu.time.manager.dao.TaskDao;
import edu.time.manager.models.Task;
import edu.time.manager.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet("/profile")
public class UserServlet extends HttpServlet {
    private TaskDao taskDao;

    @Override
    public void init() throws ServletException {
        taskDao = new TaskDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (user == null) {
            resp.sendRedirect("login.jsp");
        } else {
            // Set user attributes
            req.setAttribute("username", user.getUsername());
            req.setAttribute("email", user.getEmail());
            req.setAttribute("role", user.getRole());

            // Retrieve tasks for the user
            List<Task> tasks = taskDao.getTasksByUserId(user.getId());
            req.setAttribute("tasks", tasks);

            // Forward to the profile JSP
            req.getRequestDispatcher("tasks.jsp").forward(req, resp);
        }
    }
}
