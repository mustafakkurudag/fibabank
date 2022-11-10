package com.info.spring.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.info.spring.entity.Employee;
import com.info.spring.repository.EmployeeRepository;

@Controller
@RequestMapping("/corporate")
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@GetMapping("/employee/bydepartment")
	@ResponseBody
	public String getEmployeeByDepartment() {
		long departmentId = 2;
		List<Employee> employeeListByDepartment = employeeRepository.findEmployeesByDepartmentId(departmentId);
		double totalSalary = 0;
		
		System.out.println("Department ID'si " + departmentId + " olan employee'ler: ");
		for(Employee employee : employeeListByDepartment) {
			System.out.println(employee.getEmployeeId() + ", " + employee.getEmployeeName() + ", " + employee.getMonthlySalary());
			totalSalary += employee.getMonthlySalary();
		}
		
		double averageSalary = 0;
		
		if(employeeListByDepartment.size() > 0) {
			averageSalary = totalSalary / employeeListByDepartment.size();
		}
		
		return "Maaş ortalaması: " + averageSalary;
	}
}
