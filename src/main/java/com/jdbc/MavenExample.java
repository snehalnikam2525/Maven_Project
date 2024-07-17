package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MavenExample {

	public static void main(String[] args) {
		String name;
		int id;
		int age;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter student id :");
		id = sc.nextInt();
		System.out.println("Enter student name :");
		name = sc.next();
		System.out.println("Enter student age :");
		age = sc.nextInt();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "root");

			String query = "insert into Student values(?,?,?)";

			PreparedStatement pt = con.prepareStatement(query);
			pt.setInt(1, id);
			pt.setString(2, name);
			pt.setInt(3, age);
			pt.executeUpdate();
			System.out.println("Record added successfully..");

			con.close();

		} catch (Exception e) {
			e.getStackTrace();
		}

	}

}
