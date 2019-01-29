package com.eintrusty.sendemail;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String email = "eintrusty@yahoo.com";
		String separatedEmail = email.substring(email.indexOf("@") + 1, email.indexOf("."));
		
		System.out.println("OK" + separatedEmail);

	}

}
