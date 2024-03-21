package Indigo;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import com.experitest.client.Client;
import com.neotys.rest.dataexchange.client.DataExchangeAPIClient;
import com.neotys.rest.dataexchange.model.EntryBuilder;
import com.neotys.rest.error.NeotysAPIException;




import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class  Vitals {
	public static void monitorDewise(Client client, DataExchangeAPIClient dataExchangeAPIClient){
		String apppackage ="in.indigo.android";
		
		client.startMonitor("cpu");
	      client.startMonitor("memory");
	      client.startMonitor("battery");
	      
	      final EntryBuilder eb1= new EntryBuilder(Arrays.asList("Indigo","Vitals","CPU"),System.currentTimeMillis());
	      eb1.unit("%");
	      final EntryBuilder eb2= new EntryBuilder(Arrays.asList("Indigo","Vitals","Memory"),System.currentTimeMillis());
	      eb1.unit("Bytes");
	      final EntryBuilder eb3= new EntryBuilder(Arrays.asList("Indigo","Vitals","Battery"),System.currentTimeMillis());
	      eb1.unit("%");
	      String cpu = client.getCounter("cpu"); 
	      String mem = client.getCounter("Memory");
	      String batr = client.getCounter("Battery"); 
	      eb1.value(Double.parseDouble(cpu));
	      
	      String mem1=mem.replaceAll(",", "");
	      eb2.value(Double.parseDouble(mem1));
	      eb3.value(Double.parseDouble(batr));
	      System.out.println("double value "+Double.parseDouble(cpu));
	      
	      
	
		//  dataExchangeAPIClient.addEntry(eb1.build());
	     try {
			dataExchangeAPIClient.addEntries(Arrays.asList(eb1.build(),eb2.build(),eb3.build()));
		} catch (GeneralSecurityException | IOException | URISyntaxException | NeotysAPIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static String[] getDeviseInfo(Client client){
		
		String line="<?xml version=\"1.0\" encoding=\"UTF-8\"?><devices><device added=\"true\" agent=\"8889\" category=\"UNKNOWN\" host=\"127.0.0.1\" manufacture=\"samsung\" model=\"sm-t800\" name=\"SM-T800\" os=\"android\" remote=\"false\" serialnumber=\"3204922264709157\" used=\"true\" version=\"5.0.2\" versionnumber=\"5.0\"/></devices>";
		// Create a Pattern object  to search for devise model & OS
	    
		String pattern = "manufacture=\"(.*)\" model=\"(.*)\" name(.*)os=\"(.*)\" remote=";

		Pattern r = Pattern.compile(pattern);

	      // Now create matcher object.
	      Matcher m = r.matcher(line);
	    //  deviseinfo += m.group(1) ;
	    //  deviseinfo += m.group(1) ;
	     
	      System.out.println("matches"+ m.groupCount());
	      String deviseinfo="";
	      String[] dinfo = new String[m.groupCount()-1];
	      
	      if (m.find( )) {
	    	  dinfo[0]=m.group(1);
	    	  dinfo[1]=m.group(2);
	    	  dinfo[2]=m.group(4);
	    	  
	    	          deviseinfo += m.group(1)+ ",";
	    			  deviseinfo += m.group(2)+ ",";
	    			  deviseinfo += m.group(4);
	    			  System.out.println("string : " + deviseinfo );
	    			  
	    			   System.out.println("Found value: " + m.group(0) );
	    		         System.out.println("Found value: " + m.group(1) );
	    		         System.out.println("Found value: " + m.group(2) );
	    		         System.out.println("Found value: " + m.group(4) );
	    		         
	       
	                  // System.out.println("string : " + dinfo[2] );
	    		         return dinfo;
	      }else {
	         System.out.println("NO MATCH");
	         dinfo[0]="NO MATCH";
	         return dinfo ;
	      }
	   
	}
	}


