package com.hand;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CustomerManage {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Short addCustomer(String firsr_name, String last_name, String email, Address address,Store store) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		Short customer_id = null;
		Timestamp create_date = new Timestamp(new Date().getTime());
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 设置日期格式
		System.out.println("创建时间为：" + df.format(create_date));// new
																// Date()为获取当前系统时间
		try {
			tx = session.beginTransaction();
			Customer customer = new Customer();
			// customer.setStore(1);
			customer.setFirstName(firsr_name);
			customer.setLastName(last_name);
			customer.setEmail(email);
			customer.setAddress(address);
			customer.setCreateDate(create_date);
			customer.setLastUpdate(create_date);
			customer.setStore(store);
			customer.setActive(true);
			customer_id = (Short) session.save(customer);
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

	// 根据first_name、last_name、email、address_id查询数据
	public void getCustomer(String firsr_name, String last_name, String email, Address address) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;

		try {
			tx = session.beginTransaction();
			// 以下使用标准查询
			Criteria cr = session.createCriteria(Customer.class);
			// Add restriction.
			cr.add(Restrictions.eq("firstName", firsr_name));
			cr.add(Restrictions.eq("lastName", last_name));
			List customers = cr.list();
			for (Iterator iterator = customers.iterator(); iterator.hasNext();) {
				Customer customer = (Customer) iterator.next();
				System.out.println("First Name: " + customer.getFirstName());
				System.out.println("  Last Name: " + customer.getLastName());
				System.out.println("  Email: " + customer.getEmail());
				System.out.println("  Address: " + address.getAddress());
				System.out.println(" Create_date:" + customer.getCreateDate());
			}

			// 一下是用原声的SQL查询
			/*
			 * String sql =
			 * "SELECT first_name, last_name, email,create_date, address FROM customer,address where customer.first_name="
			 * + firsr_name + " and customer.last_name=" + last_name +
			 * " and customer.email=" + email + " and customer.address_id="
			 * +address_id+ " and customer.customer_id=address.address_id";
			 * //String sql =
			 * "select first_name,last_name from customer where first_name="
			 * +firsr_name; SQLQuery query = session.createSQLQuery(sql);
			 * query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); List
			 * data = query.list(); for (Object object : data) { Map row = (Map)
			 * object; System.out.print("First Name: " + row.get("first_name"));
			 * System.out.print("Last Name: " + row.get("last_name"));
			 * System.out.print("Email: " + row.get("email")); System.out.print(
			 * "Address: " + row.get("address")); System.out.print(
			 * "Create_date: " + row.get("create_date")); }
			 */

			tx.commit();
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
	}

	public void deleteCustomer(Integer customer_id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Customer customer = new Customer();
			customer = (Customer) session.get(Customer.class, Short.parseShort(customer_id + ""));
//			// 一下是用原声的SQL查询
//			String sql = "delete from customer where customer_id=" + Short.parseShort(customer_id + "");
			session.delete(customer);

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

	// check Customer Id
	public boolean checkCustomerId(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		String sql = "select * from customer where customer_id =" + id;
		SQLQuery query = session.createSQLQuery(sql);
		query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
		List data = query.list();
		if (!data.isEmpty()) {
			return true;
		}
		return false;
	}

	// check address_id
	public Address checkAddressId(Integer id) {
		Session session = sessionFactory.openSession();
//		Transaction tx = null;
		Address address = (Address) session.get(Address.class, Short.parseShort(id + ""));
		/*
		 * String sql = "select * from address where address_id ="+id; SQLQuery
		 * query = session.createSQLQuery(sql);
		 * query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP); List data =
		 * query.list(); if(!data.isEmpty()) { return true; }
		 */
		return address;
	}
	
	public Store checkStoreId(Integer id) {
		Session session = sessionFactory.openSession();
//		Transaction tx = null;
		Store store = (Store) session.get(Store.class, Short.parseShort(id + ""));
		return store;
	}

}
