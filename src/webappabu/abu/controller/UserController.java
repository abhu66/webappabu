/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webappabu.abu.controller;


import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import webappabu.abu.daoImpl.UserDaoImpl;
import webappabu.abu.model.User;

/**
 *
 * @author khoerulAbu
 */
public class UserController extends HttpServlet{
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String TAMBAH_USER = "/user.jsp";
    private static final String LIST_USER   = "/listUser.jsp";
    private final UserDaoImpl userDaoImpl;
    
     public UserController() throws IOException, SQLException {
        super();
        userDaoImpl = new UserDaoImpl();
    }
     
     
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String forward = "";
        String action = request.getParameter("action");

        if (action.equalsIgnoreCase("listUser")) {
            forward = LIST_USER;
            request.setAttribute("users", userDaoImpl.getAllUsers());
        } else {
            forward = TAMBAH_USER;
        }

        RequestDispatcher view = request.getRequestDispatcher(forward);
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       
        User user = new User();
        user.setNama(request.getParameter("nama"));
        user.setEmail(request.getParameter("email"));
        user.setJob(request.getParameter("job"));
        userDaoImpl.addUser(user);
        RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
        request.setAttribute("users", userDaoImpl.getAllUsers());
        view.forward(request, response);
    }
}
