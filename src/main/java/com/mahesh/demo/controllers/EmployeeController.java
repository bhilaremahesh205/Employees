package com.mahesh.demo.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mahesh.demo.models.Employee;
import com.mahesh.demo.repository.EmpRepository;

@Controller
public class EmployeeController {

	@Autowired
	EmpRepository empRepository;
	
	@GetMapping("/employee")
	public String employee(Model model) {
		model.addAttribute("employees", empRepository.findAll());
		return "employee";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		return "create";
	}
	
	@PostMapping("/save")
	public String create(Employee employee, Model model) {
		if (null == empRepository.findByEmpId(employee.getEmpId())) {
			empRepository.save(employee);
		}
		
		model.addAttribute("employees", empRepository.findAll());
		model.addAttribute("message", "Employee record created");
		return "employee";
	}
	
	@RequestMapping("/add")
	public String save(@RequestParam String id, @RequestParam String empName, @RequestParam String empEmail, @RequestParam Double empContact, @RequestParam String empAddress, @RequestParam String empDesignation) {
		Employee employee = new Employee();
		employee.setId(id);
		employee.setEmpName(empName);
		employee.setEmpEmail(empEmail);
		employee.setEmpContact(empContact);
		employee.setEmpAddress(empAddress);
		employee.setEmpDesignation(empDesignation);
		
		empRepository.save(employee);
		
		return "redirect:/show/" + employee.getId();
			
	}
	
	
	@RequestMapping("/shiw/{id}")
	public String show(@PathVariable String id, Model model) {
		model.addAttribute("employee", empRepository.findById(id).get());
		
		return "show";
	}
	
	
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam String id) {
		Optional<Employee> employee = empRepository.findById(id);
		empRepository.delete(employee.get());
		
		return "redirect:/employee";
	}
	
	
	
	@RequestMapping("/delete/{id}")
	public String delete(@PathVariable String id, Model model) {
		Employee employee = empRepository.findByEmpId(id);
		if (null != employee) {
			empRepository.delete(employee);
		}
		
		model.addAttribute("employees", empRepository.findAll());
		return "employee";
	}
	
	@RequestMapping("/edit/{id}")
	public String edit(@PathVariable String id, Model model) {
		Employee employee = empRepository.findByEmpId(id);
		
		model.addAttribute("employee", employee);
		return "edit";
	}
	
	@RequestMapping("/update")
	public String update(Employee employee, Model model) {
		Employee emp = empRepository.findByEmpId(employee.getEmpId()); 
		if (null != emp) {
			
			emp.setEmpAddress(employee.getEmpAddress());
			emp.setEmpContact(employee.getEmpContact());
			emp.setEmpDesignation(employee.getEmpDesignation());
			emp.setEmpEmail(employee.getEmpEmail());
			emp.setEmpName(employee.getEmpName());
			
			empRepository.save(emp);
		}
		
		model.addAttribute("employees", empRepository.findAll());
		model.addAttribute("message", "Employee record updated");
		return "employee";
		
	}
	
	/*
	@RequestMapping("/update")
	public String update(@RequestParam String id, @RequestParam String empName, @RequestParam String empEmail, @RequestParam Double empContact, @RequestParam String empAddress, @RequestParam String empDesignation) {
		
		Optional<Employee> employee = empRepository.findById(id);
		employee.get().setId(id);
		employee.get().setEmpName(empName);
		employee.get().setEmpEmail(empEmail);
		employee.get().setEmpContact(empContact);
		employee.get().setEmpAddress(empAddress);
		employee.get().setEmpDesignation(empDesignation);
		
		empRepository.save(employee.get());
		
		return "redirect:/show/" + employee.get().getId();
		
		
	}
	*/
}
