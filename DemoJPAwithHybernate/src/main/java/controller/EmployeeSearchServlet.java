/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.DepartmentDBContext;
import dal.EmployeeDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import model.Department;
import model.Employee;

@WebServlet("/employee/search")
public class EmployeeSearchServlet extends HttpServlet {
    private EmployeeDBContext employeeDBContext;
    private DepartmentDBContext departmentDBContext;

    @Override
    public void init() throws ServletException {
        employeeDBContext = new EmployeeDBContext();
        departmentDBContext = new DepartmentDBContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Department> departments = departmentDBContext.list();
        request.setAttribute("departments", departments);
        List<Employee> employees = employeeDBContext.list();
        request.setAttribute("employees", employees);
        request.getRequestDispatcher("../view/employee/search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String ename = request.getParameter("ename");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        String didStr = request.getParameter("did");

        List<Employee> employees = employeeDBContext.search(ename, gender, address, didStr);
        List<Department> departments = departmentDBContext.list();

        request.setAttribute("employees", employees);
        request.setAttribute("departments", departments);
        request.setAttribute("ename", ename);
        request.setAttribute("gender", gender);
        request.setAttribute("address", address);
        request.setAttribute("did", didStr);

        request.getRequestDispatcher("../view/employee/search.jsp").forward(request, response);
    }
}