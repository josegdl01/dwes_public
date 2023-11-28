package com.example.jgd_crud_serv;

import DAO.CustomerDAO;
import DAO.CustomerDAOImpl;
import Modelo.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;



public class DeleteServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(DeleteServlet.class);
    public void init(){}

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        req.getRequestDispatcher("/WEB-INF/Views/delete.jsp").forward(req, resp);
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        HttpSession session = req.getSession();
        CustomerDAO customerDAO = new CustomerDAOImpl();
        if(customerDAO.getCustomer(Integer.parseInt(req.getParameter("customerId"))) != null){
            customerDAO.deleteCustomer(Integer.parseInt(req.getParameter("customerId")));
            session.setAttribute("clienteBorrado", req.getParameter("customerId"));
            req.getRequestDispatcher("/WEB-INF/Views/customerDeleted.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/Views/customerDeleted.jsp").forward(req, resp);
        }
    }

    public void destroy(){
        super.destroy();
    }
}
