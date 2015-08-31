package com.hand;

import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	

	@Autowired
	//private static JDBCService jdbcService;
	private static CustomerManage customerManage;
	public static CustomerManage getCustomerManage() {
		return customerManage;
	}

	public static void setCustomerManage(CustomerManage customerManage) {
		Main.customerManage = customerManage;
	}
/*	public static void setJdbcService(CustomerManage customerManage)
	{
		Main.customerManage = customerManage;
	}*/
	
	/*private static SessionFactory factory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		factory = sessionFactory;
	}*/

	public static void main(String[] args) {
		/*try
		{
			Configuration cfg = new Configuration().configure();
			// ����ķ�������
			// factory = new Configuration().configure().buildSessionFactory();
			StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
					.applySettings(cfg.getProperties());
			ServiceRegistry servise = ssrb.build();
			factory = cfg.buildSessionFactory(servise);
		} catch (Throwable ex) {
			System.err.println("Failed to create sessionFactory object." + ex);
			throw new ExceptionInInitializerError(ex);
		}*/
		
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		Scanner sc = new Scanner(System.in);
		System.out.println("������FirstName��");
		String firstName = sc.nextLine();
		
		System.out.println("������LastName��");
		String lastName = sc.nextLine();
		
		System.out.println("������Email��");
		String email = sc.nextLine();
		
		System.out.println("������AddressId��");
		int addressId = sc.nextInt();
		
		while(!customerManage.checkAddressId(addressId))
		{
			System.out.println("�������Address	ID������,����������:");
			addressId = sc.nextInt();
		}
		
		System.out.println("�Ѿ�������������£�");
		customerManage.getCustomer(firstName, lastName, email, addressId);
		
		System.out.println("������Ҫɾ����Customer  Id:");
		int deleteId = sc.nextInt();
		while(!customerManage.checkCustomerId(deleteId))
		{
			System.out.println("�������Customer ID������,����������:");
			deleteId = sc.nextInt();
		}
		
		//ɾ������
		customerManage.deleteCustomer(deleteId);

	}

}
