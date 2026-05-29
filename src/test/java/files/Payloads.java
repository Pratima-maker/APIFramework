package files;

import pojo.Login;

public class Payloads {
	

	
	public pojo.Login  Login()
	{
		
		Login loginrequest = new Login();
		loginrequest.setEmail("pratima2@gmail.com");
		loginrequest.setPassword("secret123");
		
		return loginrequest;
	}
	
		}
