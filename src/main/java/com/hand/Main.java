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
		System.out.println("������FirstName��");
		String firstName = sc.nextLine();

		System.out.println("������LastName��");
		String lastName = sc.nextLine();

		System.out.println("������Email��");
		String email = sc.nextLine();

		//Customer customer = new Customer();
		Address address = null;
		Store store = customerManage.checkStoreId(1);
		boolean bool = true;
		// customer.setAddress(null);
		while (bool) {
			System.out.println("������addressId:");
			int addressId = sc.nextInt();
			address = customerManage.checkAddressId(addressId);
			bool = address == null ? true : false;
			if (bool) {
				System.out.println("addressId��Ч�����������룡");
			}
		}
		// ��������
		short customer_id = customerManage.addCustomer(firstName, lastName, email, address,store);
		if (customer_id != 0) {
			System.out.println("�Ѿ�������������£�customer_id Ϊ��" + customer_id);
			customerManage.getCustomer(firstName, lastName, email, address);
		} else {
			System.out.println("���治�ɹ�");
		}

		System.out.println("������Ҫɾ����Customer  Id:");
		int deleteId = sc.nextInt();
		while (!customerManage.checkCustomerId(deleteId)) {
			System.out.println("�������Customer ID������,����������:");
			deleteId = sc.nextInt();
		}
		sc.close();
		// ɾ������
		customerManage.deleteCustomer(deleteId);

	}

}
