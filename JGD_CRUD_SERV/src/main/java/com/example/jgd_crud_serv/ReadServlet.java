
package com.example.jgd_crud_serv;

import java.io.*;

import DAO.CustomerDAOImpl;
import Modelo.CustomerBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet(value = "/ReadServlet", name = "ReadServlet")
public class ReadServlet extends HttpServlet {

    final static Logger log = LoggerFactory.getLogger(ReadServlet.class);
    private CustomerDAOImpl customerDAO = new CustomerDAOImpl();

    public void init() {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando GET");
        req.getRequestDispatcher("WEB-INF/Views/read.jsp").forward(req, resp);

    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        log.info("Realizando POST");
        HttpSession session = req.getSession();

        int id = Integer.parseInt(req.getParameter("CustomerId"));
        CustomerBean customerRead = customerDAO.getCustomer(id);

        session.setAttribute("customerRead", customerRead);

        req.getRequestDispatcher("/WEB-INF/Views/customerSelected.jsp").forward(req, resp);

    }
}