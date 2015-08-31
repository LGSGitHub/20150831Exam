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
			// 下面的方法过期
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
		System.out.println("请输入FirstName：");
		String firstName = sc.nextLine();
		
		System.out.println("请输入LastName：");
		String lastName = sc.nextLine();
		
		System.out.println("请输入Email：");
		String email = sc.nextLine();
		
		System.out.println("请输入AddressId：");
		int addressId = sc.nextInt();
		
		while(!customerManage.checkAddressId(addressId))
		{
			System.out.println("你输入的Address	ID不存在,请重新输入:");
			addressId = sc.nextInt();
		}
		
		System.out.println("已经保存的数据如下：");
		customerManage.getCustomer(firstName, lastName, email, addressId);
		
		System.out.println("请输入要删除的Customer  Id:");
		int deleteId = sc.nextInt();
		while(!customerManage.checkCustomerId(deleteId))
		{
			System.out.println("你输入的Customer ID不存在,请重新输入:");
			deleteId = sc.nextInt();
		}
		
		//删除数据
		customerManage.deleteCustomer(deleteId);

	}

}
