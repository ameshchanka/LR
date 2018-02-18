package by.itacademy;

import by.itacademy.dto.LeaseDTO;
import by.itacademy.infrastructure.PagingInfo;
import by.itacademy.interfaces.ILeaseService;
import by.itacademy.services.LeaseService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/lease")
public class LeaseServlet extends HttpServlet {

    private ILeaseService leaseService;

    @Override
    public void init() throws ServletException {
        super.init();
        ApplicationContextHolder.init();
    }

    @Override
    public void destroy() {
        ApplicationContextHolder.destroy();
        super.destroy();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            //LeaseService lease = new LeaseService();
            LeaseDTO leaseDTO = new LeaseDTO();
            Float temp;
            Long tempLong;
            Integer tempInt;

            temp = UtilRequest.getFloat(req, "priceMin");
            if (temp != null) {
                leaseDTO.getFilter().setPriceMin(temp);
            }
            temp = UtilRequest.getFloat(req, "priceMax");
            if (temp != null) {
                leaseDTO.getFilter().setPriceMax(temp);
            }
            temp = UtilRequest.getFloat(req, "squareMin");
            if (temp != null) {
                leaseDTO.getFilter().setSquareMin(temp);
            }
            temp = UtilRequest.getFloat(req, "squareMax");
            if (temp != null) {
                leaseDTO.getFilter().setSquareMax(temp);
            }
            temp = UtilRequest.getFloat(req, "pm2Min");
            if (temp != null) {
                leaseDTO.getFilter().setPm2Min(temp);
            }
            temp = UtilRequest.getFloat(req, "pm2Max");
            if (temp != null) {
                leaseDTO.getFilter().setPm2Max(temp);
            }
            tempLong = UtilRequest.getLong(req, "countItems");
            if (tempLong != null) {
                leaseDTO.getFilter().setCountItems(tempLong);
            }
            tempLong = UtilRequest.getLong(req, "currentPage");
            if (tempLong != null) {
                leaseDTO.getFilter().setFirstItems(tempLong);
            }

            leaseService = ApplicationContextHolder.getBean(ILeaseService.class);
            leaseDTO = leaseService.findLeaseByFilter(leaseDTO);

            tempInt = UtilRequest.getInt(req, "currentPage");
            leaseDTO.setPagingInfo(new PagingInfo(
                    leaseDTO.getCount(),
                    leaseDTO.getFilter().getCountItems(),
                    tempInt != null ? tempInt : 1
            ));

            req.setAttribute("leaseDTO", leaseDTO);
            req.getRequestDispatcher("WEB-INF/view/lease.jsp").forward(req, resp);
        } catch (Exception e) {
            // log
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }
    }
}
