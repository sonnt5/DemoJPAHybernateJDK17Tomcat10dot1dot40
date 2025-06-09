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

@WebServlet(urlPatterns ="/employee/create")
public class EmployeeCreateServlet extends HttpServlet {

    private EmployeeDBContext employeeDBContext;
    private DepartmentDBContext departmentDBContext;

    @Override
    public void init() throws ServletException {
        employeeDBContext = new EmployeeDBContext();
        departmentDBContext = new DepartmentDBContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Department> departments = departmentDBContext.list();
        request.setAttribute("departments", departments);
        request.getRequestDispatcher("../view/employee/create.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ename = request.getParameter("ename");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String address = request.getParameter("address");
        int did = Integer.parseInt(request.getParameter("did"));

        Employee employee = new Employee();
        employee.setEname(ename);
        employee.setGender(gender);
        employee.setAddress(address);
        Department department = new Department();
        department.setDid(did);
        employee.setDepartment(department);

        employeeDBContext.insert(employee);
        response.getWriter().println("Inserted " + employee.getEid());
        //response.sendRedirect(request.getContextPath() + "/employee/list");
    }
}
