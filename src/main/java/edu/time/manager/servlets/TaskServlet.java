package main.java.edu.time.manager.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

// Map the servlet to a URL

@WebServlet("/task")
public class TaskServlet extends HttpServlet {
    private TaskDAO taskDAO;

    @Override
    public void init() throws ServletException {
        taskDAO = new TaskDAO();
    }

    // Display the task creation form
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.getWriter().println("""
                <h1>Create Task</h1>
                <form action="/TimeManagement/task" method="post">
                    <label for="title">Title:</label>
                    <input type="text" id="title" name="title" required><br>
                    <label for="description">Description:</label>
                    <input type="text" id="description" name="description" required><br>
                    <label for="dueDate">Due Date:</label>
                    <input type="date" id="dueDate" name="dueDate" required><br>
                    <label for="priority">Priority:</label>
                    <select id="priority" name="priority">
                        <option value="HIGH">High</option>
                        <option value="MEDIUM">Medium</option>
                        <option value="LOW">Low</option>
                    </select><br>
                    <button type="submit">Create Task</button>
                </form>
            """);
    }

    // Handle task creation
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = (User) req.getSession().getAttribute("user");

        if (user == null) {
            resp.getWriter().println("<h2>Please login to create a task.</h2>");
            resp.sendRedirect("/TimeManagement/user");
            return;
        }

        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String dueDate = req.getParameter("dueDate");
        String priority = req.getParameter("priority");

        Task task = new Task(title, description, LocalDateTime.parse(dueDate + "T00:00:00"), "General", Priority.valueOf(priority));
        task.setUserId(user.getId());
        taskDAO.addTask(task);

        resp.getWriter().println("<h2>Task created successfully!</h2>");
        resp.getWriter().println("<a href='/TimeManagement/dashboard'>Go to Dashboard</a>");
    }
}

