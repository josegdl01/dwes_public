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


public class InsertServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(InsertServlet.class);
    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    public void init() {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/insert.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        HttpSession session = req.getSession();
        CustomerDAO cusDAO = new CustomerDAOImpl();
        CustomerBean customerInsert = cusDAO.getCustomer(Integer.parseInt(req.getParameter("CustomerId")));
        if(customerInsert == null){
            customerInsert = new CustomerBean(Integer.parseInt(req.getParameter("CustomerId")),
                    req.getParameter("CustomerTaxCode"),
                    req.getParameter("CustomerBusName"),
                    req.getParameter("CustomerAddress"),
                    req.getParameter("CustomerPhone"));
            session.setAttribute("customerInsert", customerInsert);
            log.info(session.getAttribute("customerInsert").toString());
            req.getRequestDispatcher("/WEB-INF/Views/customerInserted.jsp").forward(req, resp);
            customerDAO.addCustomer(customerInsert);
        } else {
            log.error("Este cliente ya se halla en la base de datos");
            req.getRequestDispatcher("/WEB-INF/Views/customerInserted.jsp").forward(req, resp);
        }
    }

    public void destroy() {

    }
}
