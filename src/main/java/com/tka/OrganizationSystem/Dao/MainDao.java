package com.tka.OrganizationSystem.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.tka.OrganizationSystem.entity.Country;
import com.tka.OrganizationSystem.entity.Employee;

@Repository
public class MainDao {

	@Autowired
	SessionFactory factory;

	public String addCountry(Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();

			tx = session.beginTransaction();

			session.persist(c);

			tx.commit();

			msg = "Country added Successfully...";
		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}

			e.printStackTrace();
		} finally {

			if (session != null) {
				session.close();
			}

		}

		return msg;
	}

	public String updateCountry(int cid, Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();

			tx = session.beginTransaction();

			Country country = session.get(Country.class, cid);

			country.setName(c.getName());
			session.remove(c);
			tx.commit();

			msg = "Country Updated Successfully...";

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteCountry(int id, Country c) {

		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();

			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);

			session.remove(country);

			tx.commit();

			msg = "Country deleted Successfully...";

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (session != null) {
				session.close();
			}
			return msg;
		}

	}

	public String getCountry(int id, Country c) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();

			tx = session.beginTransaction();

			Country country = session.get(Country.class, id);
			tx.commit();

			msg = "Country get Successfully...";

		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {

			if (session != null) {
				session.close();
			}
			return msg;
		}

	}

	public String addEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(emp);
			tx.commit();
			msg = "Employee Addedd Successully..";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String updateEmployee(Employee emp) {
		Session session = null;
		Transaction tx = null;
		String msg = null;
		try {

			session = factory.openSession();
			tx = session.beginTransaction();

			Employee e = session.get(Employee.class, emp.getId());
			e.setName(emp.getName());
			e.setDepartment(emp.getDepartment());
			e.setStatus(emp.getStatus());
			e.setPhoneno(emp.getPhoneno());
			e.setSalary(emp.getSalary());
			e.setCreateddtm(emp.getCreateddtm());
			e.setCreatedby(emp.getCreatedby());
			e.setUpdateddtm(emp.getUpdateddtm());
			e.setUpdatedby(emp.getUpdatedby());
			e.setEmailid(emp.getEmailid());

			tx.commit();

			msg = "Employee updated Successfully";
		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteMapping(int id) {
		Session session = null;
		Transaction tx = null;
		String msg = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Employee e = session.get(Employee.class, id);
			session.remove(e);

			tx.commit();
			msg = "Employee is deleted successfully";

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return msg;
	}

	public List<Employee> getAllRecord() {
		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);
			list = query.list();
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;
	}

	public Employee getEmp(int id) {
		Session session = null;
		Transaction tx = null;
		Employee emp = null;

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			emp = session.get(Employee.class, id);

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return emp;
	}

	public List<Employee> getEmpByStatus(String status) {

		Session session = null;
		Transaction tx = null;
		List<Employee> list = null;
		String hqlQuery = "from Employee where status=:mystatus";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();

			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			query.setParameter("mystatus", status);
			list = query.list();
			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return list;

	}

	public Employee addlogin(Employee emp) {

		Session session = null;
		Transaction tx = null;
		Employee employee = null;
		String hqlQuery = "from Employee where emailid=:myemailid and phoneno=:myphoneno";

		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Query<Employee> query = session.createQuery(hqlQuery, Employee.class);

			query.setParameter("myemailid", emp.getEmailid());
			query.setParameter("myphoneno", emp.getPhoneno());

			employee = query.uniqueResult();

			tx.commit();

		} catch (Exception e) {

			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}

		return employee;
	}

}// end