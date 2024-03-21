package Indigo;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public  class Trigger {
public static String dewiseid;
public static String appname;
public static String NLCIP;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//should retrive Dewiseid,appname,Nl controller IP
		
		if (args.length>=3){
			
			if (args[0]==null){
				System.out.println("make sure Dewiseid not null");
				
			}
			else{
				dewiseid=args[0];
			}
			if (args[1]==null){
				System.out.println("make sure appname  not null");
				
			}
			else{
				appname=args[1];
			}
			if (args[2]==null){
				System.out.println("make sure controllerip not null");
				
			}
			else{
				NLCIP=args[2];
			}
		}
		else{
			 System.out.println("make sure all the 3 arguments Dewiseid,appname,Nl controller IP are in custom action");
			
		}
		//***************************************
		 Result result = JUnitCore.runClasses(Indigo_Test_New.class);
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.toString());
	      }
	      System.out.println(result.wasSuccessful());

	}

}
