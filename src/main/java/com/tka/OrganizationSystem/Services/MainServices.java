package com.tka.OrganizationSystem.Services;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tka.OrganizationSystem.Dao.MainDao;
import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Service
public class MainServices {

	@Autowired
	MainDao dao;
	
	public String addCountry(Country c) {
		
		String msg = dao.addCountry(c);
		
		if(Objects.isNull(msg)) {
		msg = "Country is not added...";
		}
		
		return msg;
	}

	public String updateCountry(int cid, Country c) {
		
		String msg =dao.updateCountry(cid,c);
		if(Objects.isNull(msg)) {
			msg = "Country is not Updated...";
			}
		return msg;
		
	}

	public String deleteCountry(int id, Country c) {
		
		String msg = dao.deleteCountry(id,c);
		if(Objects.isNull(msg)) {
			msg = "Country is not deleted...";
			}
		return msg;
	}

	public String getCountry(int id, Country c) {
		
		String msg = dao.getCountry(id,c);
		if(Objects.isNull(msg)) {
			msg = "Country is not get it...";
			}
		return msg;
		
	}


	public String addEmployee(Employee emp) {
		
		String msg=dao.addEmployee(emp);
		
		if(Objects.isNull(msg)) {
			msg="Record is not be addedd...";
		}
		return msg;		
		
	}

	public String updateEmployee(Employee emp) {
		String msg = dao.updateEmployee(emp);
		if(Objects.isNull(msg)) {
			msg="Record is not be updated...";
		}
		return msg;
	}

	public String deleteMapping(int id) {
		String msg = dao.deleteMapping(id);
		if(Objects.isNull(msg)) {
			msg="Record is not be deleted...";
		}
		return msg;
	}

	public List<Employee> getAllRecord() {
		List<Employee> list = dao.getAllRecord();
		
		return list;
	}

	public Employee getEmp(int id) {
		
		Employee emp = dao.getEmp(id);
		
		return emp;
	}

	public List<Employee> getEmpByStatus(String status) {
		
		List<Employee>list = dao.getEmpByStatus(status);
		
		return list;
	}

	public HashMap addlogin(Employee emp) {
		
		Employee e = dao.addlogin(emp);
		HashMap map = new HashMap();
		if(Objects.isNull(e)) {
			map.put("msg", "Invalid user");
			map.put("user", e);
		}else {
			map.put("msg", "Valid user");
			map.put("user", e);
		}
 		return map;
	}

}
