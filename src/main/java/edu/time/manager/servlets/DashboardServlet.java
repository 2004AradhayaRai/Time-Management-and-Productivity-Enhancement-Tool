package main.java.edu.time.manager.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/dashboard")
public class DashboardServlet extends HttpServlet {
    private TaskDAO taskDAO;

    @Override
    public void init() throws ServletException {
        taskDAO = new TaskDAO();
    }

    // Displays the dashboard with tasks
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            resp.getWriter().println("<h2>Please login to view your dashboard.</h2>");
            resp.sendRedirect("/TimeManagement/user");
            return;
        }

        List<Task> tasks = taskDAO.getTasksByUserId(user.getId());
        resp.getWriter().println("<h1>Dashboard</h1>");
        resp.getWriter().println("<h2>Welcome, " + user.getUsername() + "</h2>");
        resp.getWriter().println("<h3>Your Tasks:</h3>");
        resp.getWriter().println("<ul>");
        for (Task task : tasks) {
            resp.getWriter().println("<li>" + task.getTitle() + " - " + task.getDescription() + "</li>");
        }
        resp.getWriter().println("</ul>");
        resp.getWriter().println("<a href='/TimeManagement/task'>Add New Task</a>");
    }

    // POST can be used for advanced dashboard interactions if required
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().println("<h1>Post request is not supported for Dashboard.</h1>");
    }
}

}
