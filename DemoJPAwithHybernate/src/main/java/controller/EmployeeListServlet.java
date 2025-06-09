/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.EmployeeDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Employee;

@WebServlet("/employee/list")
public class EmployeeListServlet extends HttpServlet {
    private EmployeeDBContext employeeDBContext;

    @Override
    public void init() throws ServletException {
        employeeDBContext = new EmployeeDBContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Employee> employees = employeeDBContext.list();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("../view/employee/list.jsp").forward(request, response);
    }
}