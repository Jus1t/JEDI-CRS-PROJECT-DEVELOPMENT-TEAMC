package com.flipkart.validator;

public class LoginValidator {
	
	public static boolean isloginvalid(int id,String password)
	{
		if(id==0 || password==null)
		{
			return false;
		}
		
		return true;
	}
}
