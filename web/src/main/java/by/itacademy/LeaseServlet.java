package by.itacademy;

import by.itacademy.dto.LeaseDTO;
import by.itacademy.entity.forFilters.LeaseAdFilter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/lease")
public class LeaseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // HttpSession session = req.getSession();
        try {
            LeaseService lease = new LeaseService();
            LeaseDTO leaseDTO = new LeaseDTO();
            Float temp;
            Integer tempInt;
            if ((temp = UtilRequest.getFloat(req, "priceMin")) != null)
                leaseDTO.getFilter().setPriceMin(temp);
            if ((temp = UtilRequest.getFloat(req, "priceMax")) != null)
                leaseDTO.getFilter().setPriceMax(temp);
            if ((temp = UtilRequest.getFloat(req, "squareMin")) != null)
                leaseDTO.getFilter().setSquareMin(temp);
            if ((temp = UtilRequest.getFloat(req, "squareMax")) != null)
                leaseDTO.getFilter().setSquareMax(temp);
            if ((temp = UtilRequest.getFloat(req, "pm2Min")) != null)
                leaseDTO.getFilter().setPm2Min(temp);
            if ((temp = UtilRequest.getFloat(req, "pm2Max")) != null)
                leaseDTO.getFilter().setPm2Max(temp);
            if ((tempInt = UtilRequest.getInt(req, "maxResult")) != null)
                leaseDTO.getFilter().setMaxResult(tempInt);
            if ((tempInt = UtilRequest.getInt(req, "firstResult")) != null)
                leaseDTO.getFilter().setFirstResult(tempInt);
            //String da = "12345";
            req.setAttribute("leaseDTO", lease.findLeaseByFilter(leaseDTO));
            req.getRequestDispatcher("WEB-INF/view/lease.jsp").forward(req, resp);
        } catch (Exception e) {
            // log
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////        UserExampleWelcome uEW = new UserExampleWelcome();
////        req.setAttribute("userExampleWelcome", uEW.say());
////
////        req.getRequestDispatcher("WEB-INF/view/user.jsp").forward(req, resp);
//    }

}
