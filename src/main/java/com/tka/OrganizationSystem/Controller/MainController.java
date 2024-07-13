package com.tka.OrganizationSystem.Controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tka.OrganizationSystem.Services.MainServices;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;
@CrossOrigin//this is very important annnotation used to connect backend and frontend platform cross connectivity
@RestController
@RequestMapping("controller")
public class MainController {

	@Autowired
	MainServices service;

	
	@PostMapping("addcountry")
	public String addCountry(@RequestBody Country c) {

		// System.out.println(c);
		String msg = service.addCountry(c);

		return msg;

	}
	//Update country=> update country set name = india where id =1
	@PutMapping("updatecountry/{cid}")
	public String updateCountry(@PathVariable int cid, @RequestBody Country c) {
		
		String msg = service.updateCountry(cid,c);
		return msg;
	}
	//delete from country where id=1;
	
	@DeleteMapping("deletecountry/{id}")
	public String deleteCountry(@PathVariable int id, @RequestBody Country c) {
		
		String msg = service.deleteCountry(id,c);
		return msg;
	}
	//Select from  country where id =1
	@GetMapping("getcountry/{id}")
	public String getCountry(@PathVariable int id, @RequestBody Country c) {
		
		System.out.println(c);
		String msg =service.getCountry(id,c);
		
		return msg;
	}
	
	//add employee
	@PostMapping("addemp")
	public String 
	addEmployee(@RequestBody Employee emp) {
		
		String msg= service.addEmployee(emp);
		return msg;
		
	}
	
	//update employee=> update employee ko humne id through url dene ke jarurt nhi he ager hum json object ke andar he
	//id pass karenge tho.
	@PutMapping("updateemp")
	public String updateEmployee(@RequestBody Employee emp) {
		
		String msg = service.updateEmployee(emp);
		return msg;
	}
	//delete from emp where id=1 => according to this statment we need id so we have to use path variable concept here
	@DeleteMapping("deleteemp/{id}")
	public String deleteMapping(@PathVariable int id) {
		
		String msg = service.deleteMapping(id);
		return msg;
	}
	
	//GetAllRecord
	@GetMapping("getallemp")
	public List<Employee> getAllRecord(){
		
		List<Employee> list = service.getAllRecord();
		return list;
	}
	
	//get particular record
	
	@GetMapping("getemp/{id}")
	public Employee getEmp(@PathVariable int id) {
		
		Employee emp = service.getEmp(id);
		return emp;
	}
	
	// get record by status
	@GetMapping("getempbystatus/{status}")
	public List <Employee> getEmpByStatus(@PathVariable String status) {
		
		 List <Employee> list = service.getEmpByStatus(status);
		return list;
	}
	
	//Create log in api
	
	@PostMapping("addlogin")
	public HashMap addlogin(@RequestBody Employee emp) {
		HashMap map = service.addlogin(emp);
		return map;
		
	}
	
	
	
	
	
	
	
	
	
}//end
