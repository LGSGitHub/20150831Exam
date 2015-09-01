package com.hand;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	private static CustomerManage customerManage;
	/*public static CustomerManage getCustomerManage() {
		return customerManage;
	}

	public static void setCustomerManage(CustomerManage customerManage) {
		Main.customerManage = customerManage;
	}*/

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
