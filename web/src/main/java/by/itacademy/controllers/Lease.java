package by.itacademy.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Lease extends AbstractAction  {

    private String _jsp = "/lease.jsp"; //Pages.home;
    private String _cmd = "do?command=lease"; //Pages.cmdlease;

    @Override
    public String jsp(){
        return _jsp;
    }
    @Override
    public String cmd(){
        return _cmd;
    }

    @Override
    public ICommand execute(HttpServletRequest req, HttpServletResponse resp) {

//        if (MyRequest.isPost(req)){
//            return Actions.LEASE.command;
//        }
//
//        if (MyRequest.isGet(req)){
//            User user = Utils.getUserFromSession(req);
//            if(user != null) {
//                HttpSession session = req.getSession();
//                session.setAttribute("user", user);
//                try {
//                    DAO dao = DAO.getInstance();
//                    List<LeaseView> lv = ConstructorLeaseView.creator(dao);
//                    if (lv != null) req.setAttribute("leaseview", lv);
//                    else req.setAttribute(Messages.MESSAGE, "Not data in database ");
//                } catch (Exception e) {
//                    req.getServletContext().log(e.getMessage());
//                    System.out.println(e.getMessage());
//                    req.setAttribute(Messages.ERROR, e.getMessage());
//                }
//            }
//            else {
//                req.setAttribute(Messages.ERROR, "Not active session ");
//            }
//        }
        return null;
    }
}
