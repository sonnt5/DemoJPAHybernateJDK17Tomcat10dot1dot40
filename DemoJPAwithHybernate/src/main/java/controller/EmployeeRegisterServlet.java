/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dal.DepartmentDBContext;
import dal.EmployeeDBContext;
import dal.SkillDBContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Department;
import model.Employee;
import model.EmployeeSkill;
import model.EmployeeSkillId;
import model.Skill;

@WebServlet("/employee/register")
public class EmployeeRegisterServlet extends HttpServlet {
    private EmployeeDBContext employeeDBContext;
    private DepartmentDBContext departmentDBContext;
    private SkillDBContext skillDBContext;

    @Override
    public void init() throws ServletException {
        employeeDBContext = new EmployeeDBContext();
        departmentDBContext = new DepartmentDBContext();
        skillDBContext = new SkillDBContext();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Department> departments = departmentDBContext.list();
        List<Skill> skills = skillDBContext.getAllSkills();
        request.setAttribute("departments", departments);
        request.setAttribute("skills", skills);
        request.getRequestDispatcher("../view/employee/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        // Lấy dữ liệu từ form
        String ename = request.getParameter("ename");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        String address = request.getParameter("address");
        int did = Integer.parseInt(request.getParameter("did"));
        String[] selectedSkills = request.getParameterValues("skills");

        // Tạo đối tượng Employee
        Employee employee = new Employee();
        employee.setEname(ename);
        employee.setGender(gender);
        employee.setAddress(address);
        Department department = new Department();
        department.setDid(did);
        employee.setDepartment(department);

        // Tạo danh sách EmployeeSkill từ các kỹ năng được chọn
        List<EmployeeSkill> employeeSkills = new ArrayList<>();
        if (selectedSkills != null) {
            for (String skillId : selectedSkills) {
                int skid = Integer.parseInt(skillId);
                Skill skill = new Skill();
                skill.setSkid(skid);

                EmployeeSkill employeeSkill = new EmployeeSkill();
                EmployeeSkillId id = new EmployeeSkillId();
                id.setSkid(skid);
                employeeSkill.setId(id);
                employeeSkill.setEmployee(employee);
                employeeSkill.setSkill(skill);
                employeeSkill.setStartDate(new Date());
                employeeSkill.setEndDate(null);
                employeeSkills.add(employeeSkill);
            }
        }
        employee.setEmployeeSkills(employeeSkills);

        // Lưu employee và các kỹ năng liên quan
        employeeDBContext.insert(employee);

        response.sendRedirect("list");
    }
}