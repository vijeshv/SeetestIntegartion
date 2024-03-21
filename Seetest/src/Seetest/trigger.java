package Seetest;

import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;

public class trigger {

	public static void main(String[] args) throws ClassNotFoundException { 
		// TODO Auto-generated method stub
		 String[] classAndMethod = args[0].split("#");
	        Request request = Request.method(Class.forName(classAndMethod[0]),
	                classAndMethod[1]);

	        Result result = new JUnitCore().run(request);
	        System.exit(result.wasSuccessful() ? 0 : 1);
	    }

	}


