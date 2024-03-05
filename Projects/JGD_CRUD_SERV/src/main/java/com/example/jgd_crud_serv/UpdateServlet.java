package com.example.jgd_crud_serv;

import DAO.CustomerDAO;
import DAO.CustomerDAOImpl;
import Modelo.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class UpdateServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(UpdateServlet.class);
    CustomerDAO customerDAO = new CustomerDAOImpl();

    public void init() {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/update.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        HttpSession session = req.getSession();
        CustomerBean customerBean = new CustomerBean(Integer.parseInt(req.getParameter("CusId")), req.getParameter("CusTax"), req.getParameter("CusBus"), req.getParameter("CusAd"), req.getParameter("CusPhone"));
        session.setAttribute("customerUpdated", customerBean);
        req.getRequestDispatcher("/WEB-INF/Views/customerUpdated.jsp").forward(req, resp);
        customerDAO.editCustomer(customerBean);

    }

    public void destroy() {
        super.destroy();
    }

}
