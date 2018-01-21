package by.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by a.meshchanka on 21.01.2018.
 */

@WebServlet("/welcome")
public class MyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        UserExampleWelcome uEW = new UserExampleWelcome();
        req.setAttribute("userExampleWelcome", uEW.say());
        //PrintWriter printWriter = resp.getWriter();
        //printWriter.println("For example");

        req.getRequestDispatcher("WEB-INF/view/user.jsp").forward(req, resp);
    }
}