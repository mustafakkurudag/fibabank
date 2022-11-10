package com.info.spring.mvc;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.spring.entity.Department;
import com.info.spring.entity.Employee;
import com.info.spring.repository.DepartmentRepository;

@Controller
@RequestMapping("/corporate")
public class DepartmentController {
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@GetMapping("/department/create")
	@ResponseBody
	public String createDepartment() {
		Department departmentA = new Department(0, "Bilişim Teknolojileri");
		departmentA.setEmployeeList(new ArrayList<>());
		
		Employee employee1 = new Employee(0, "Steve Jobs", 15050);
		employee1.setDepartment(departmentA);
		
		Employee employee2 = new Employee(0, "Bill Gates", 15400);
		employee2.setDepartment(departmentA);
		
		Employee employee3 = new Employee(0, "Elon Musk", 13650);
		employee3.setDepartment(departmentA);
		
		departmentA.getEmployeeList().add(employee1);
		departmentA.getEmployeeList().add(employee2);
		departmentA.getEmployeeList().add(employee3);
		
		departmentRepository.save(departmentA);
		
		return "Yeni birim eklendi: " + departmentA.getDepartmentId() + " - " + departmentA.getDepartmentName();
	}
}
