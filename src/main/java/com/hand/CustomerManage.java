package com.hand;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CustomerManage {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Integer addCustomer(String firsr_name,String last_name,String email,int address_id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Integer customer_id = null;
		Date create_date = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println("创建时间为："+df.format(create_date));// new Date()为获取当前系统时间
		try {
			tx = session.beginTransaction();
			Customer customer = new Customer();
			
			customer.setStore_id(1);
			customer.setFirst_name(firsr_name);
			customer.setLast_name(last_name);
			customer.setEmail(email);
			customer.setAddress_id(address_id);
			customer.setCreate_date(create_date);
			customer_id = (Integer) session.save(customer);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return customer_id;
	}
	
	//根据first_name、last_name、email、address_id查询数据
	public void getCustomer(String firsr_name,String last_name,String email,int address_id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		
		try {
			tx = session.beginTransaction();
			/*// 以下使用标准查询
			Criteria cr = session.createCriteria(Employee.class);
			// Add restriction.
			cr.add(Restrictions.gt("salary", 2000));
			List employees = cr.list();

			for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
				Employee employee = (Employee) iterator.next();
				System.out.print("First Name: " + employee.getFirstName());
				System.out.print("  Last Name: " + employee.getLastName());
				System.out.println("  Salary: " + employee.getSalary());
			}*/

			// 一下是用原声的SQL查询
			String sql = "SELECT first_name, last_name, email,create_date, address FROM customer,address where customer.first_name="
			+ firsr_name + "and customer.last_name=" + last_name +"and customer.email=" + email + "and address.address_id=" +address_id;
			SQLQuery query = session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List data = query.list();
			for (Object object : data) {
				Map row = (Map) object;
				System.out.print("First Name: " + row.get("first_name"));
				System.out.print("Last Name: " + row.get("last_name"));
				System.out.print("Email: " + row.get("email"));
				System.out.print("Address: " + row.get("address"));
				System.out.print("Create_date: " + row.get("create_date"));
			}

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
	
	public void deleteCustomer(Integer customer_id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			// 一下是用原声的SQL查询
			String sql = "delete from customer where customer_id="+ customer_id;
			session.delete(sql);

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		System.out.println("你输入的ID为" + customer_id + "的Customer已经删除");
	}
	
	//check Customer Id
	public boolean checkCustomerId(Integer id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		String sql = "select * from customer where customer_id ="+id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		if(!data.isEmpty())
		{
			return true;
		}
		return false;
	}
	
	//check address_id
	public boolean checkAddressId(Integer id)
	{
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		String sql = "select * from address where address_id ="+id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		if(!data.isEmpty())
		{
			return true;
		}
		return false;
	}

}
