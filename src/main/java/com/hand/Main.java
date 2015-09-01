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
