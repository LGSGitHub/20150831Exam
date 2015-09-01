package com.hand;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Main {

	private static CustomerManage customerManage;
	/*
	 * public static CustomerManage getCustomerManage() { return customerManage;
	 * }
	 * 
	 * public static void setCustomerManage(CustomerManage customerManage) {
	 * Main.customerManage = customerManage; }
	 */

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		customerManage = (CustomerManage) context.getBean("customerManage");

		Scanner sc = new Scanner(System.in);
		System.out.println("请输入FirstName：");
		String firstName = sc.nextLine();

		System.out.println("请输入LastName：");
		String lastName = sc.nextLine();

		System.out.println("请输入Email：");
		String email = sc.nextLine();

		//Customer customer = new Customer();
		Address address = null;
		Store store = customerManage.checkStoreId(1);
		boolean bool = true;
		// customer.setAddress(null);
		while (bool) {
			System.out.println("请输入addressId:");
			int addressId = sc.nextInt();
			address = customerManage.checkAddressId(addressId);
			bool = address == null ? true : false;
			if (bool) {
				System.out.println("addressId无效！请重新输入！");
			}
		}
		// 保存数据
		short customer_id = customerManage.addCustomer(firstName, lastName, email, address,store);
		if (customer_id != 0) {
			System.out.println("已经保存的数据如下：customer_id 为：" + customer_id);
			customerManage.getCustomer(firstName, lastName, email, address);
		} else {
			System.out.println("保存不成功");
		}

		System.out.println("请输入要删除的Customer  Id:");
		int deleteId = sc.nextInt();
		while (!customerManage.checkCustomerId(deleteId)) {
			System.out.println("你输入的Customer ID不存在,请重新输入:");
			deleteId = sc.nextInt();
		}
		sc.close();
		// 删除数据
		customerManage.deleteCustomer(deleteId);

	}

}
