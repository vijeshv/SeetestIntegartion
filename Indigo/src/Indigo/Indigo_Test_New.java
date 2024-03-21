package Indigo;
//indigo  is demo app
//package <set your test package>;
import com.experitest.client.*;
import com.neotys.rest.dataexchange.client.DataExchangeAPIClient;
import com.neotys.rest.dataexchange.client.DataExchangeAPIClientFactory;
import com.neotys.rest.dataexchange.model.ContextBuilder;
import com.neotys.rest.dataexchange.model.EntryBuilder;
import com.neotys.rest.error.NeotysAPIException;

import java.io.IOException;
import java.lang.reflect.Array;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

import org.apache.olingo.odata2.api.exception.ODataException;
import org.junit.*;
/**
*
*/

public class Indigo_Test_New {
	
	public static void main(String args[])
	  {
		  
		  
		  
	  }

  private String host = "localhost";
  private int port = 8889;
  private String projectBaseDirectory = "C:\\Users\\757605\\workspace\\project2";
  protected Client client = null;

  @Before
  public void setUp(){
      client = new Client(host, port, true);
      client.setProjectBaseDirectory(projectBaseDirectory);
      client.setReporter("xml", "reports", "Indigo_SeeTest_Script");
  }

  @Test
  public void testIndigo_SeeTest_Script() throws NeotysAPIException, GeneralSecurityException, IOException, ODataException, URISyntaxException
  {
	 
      client.setDevice("adb:SM-T800");
      final ContextBuilder cb=new ContextBuilder();
      cb.hardware("Samsung Galaxy TAb").location("BBS").software("Android").script("Indigo");
      
      DataExchangeAPIClient dataExchangeAPIClient = DataExchangeAPIClientFactory.newClient("http://localhost:7400/DataExchange/v1/Service.svc/",cb.build(),""); 
      com.neotys.rest.dataexchange.model.TimerBuilder timer = com.neotys.rest.dataexchange.model.TimerBuilder.start("Indigo","landingpage");
      
      client.launch("in.goindigo.android/.Splash", false, true);
      dataExchangeAPIClient.addEntry(timer.stop());
      
     
      if(client.waitForElement("NATIVE", "xpath=//*[@text='IndiGo']", 0, 60000)){
          // If statement
      }
      client.sleep(5000);
      
    //  DataExchangeAPIClient dataExchangeAPIClient1 = DataExchangeAPIClientFactory.newClient("http://localhost:7400/DataExchange/v1/Service.svc/"); 
      //com.neotys.rest.dataexchange.model.TimerBuilder timer1 = com.neotys.rest.dataexchange.model.TimerBuilder.start("Indigo","bookingpage");
      timer = com.neotys.rest.dataexchange.model.TimerBuilder.start("Indigo","bookingpage");
      
      client.click("Indigo_New_App", "Menu", 0, 1);
      if(client.waitForElement("NATIVE", "xpath=//*[@text='Booking']", 0, 30000)){
          // If statement
      }
      client.click("NATIVE", "xpath=//*[@text='Booking']", 0, 1);
      if(client.waitForElement("NATIVE", "xpath=//*[@text='Search']", 0, 10000)){
          // If statement
      }
      
      dataExchangeAPIClient.addEntry(timer.stop());
      
    //  DataExchangeAPIClient dataExchangeAPIClient2 = DataExchangeAPIClientFactory.newClient("http://localhost:7400/DataExchange/v1/Service.svc/"); 
     // com.neotys.rest.dataexchange.model.TimerBuilder timer2 = com.neotys.rest.dataexchange.model.TimerBuilder.start("Indigo","flightpage");
      timer= com.neotys.rest.dataexchange.model.TimerBuilder.start("Indigo","flightpage");
      
      client.click("NATIVE", "xpath=//*[@text='One Way']", 0, 1);
      client.click("NATIVE", "xpath=//*[@text='FROM']", 0, 1);
      if(client.waitForElement("NATIVE", "xpath=//*[@text='City']", 0, 10000)){
          // If statement
      }
      client.elementSendText("NATIVE", "xpath=//*[@text='City']", 0, "Mumbai");
      if(client.waitForElement("NATIVE", "xpath=//*[@text='Mumbai (BOM)']", 0, 10000)){
          // If statement
      }
      client.click("NATIVE", "xpath=//*[@text='Mumbai (BOM)']", 0, 1);
      if(client.waitForElement("NATIVE", "xpath=//*[@text='BOM']", 0, 10000)){
          // If statement
      }
      client.click("NATIVE", "xpath=//*[@text='TO']", 0, 1);
      if(client.waitForElement("NATIVE", "xpath=//*[@text='City']", 0, 10000)){
          // If statement
      }
      client.elementSendText("NATIVE", "xpath=//*[@text='City']", 0, "Delhi");
      if(client.waitForElement("NATIVE", "xpath=//*[@text='Delhi (DEL)']", 0, 10000)){
          // If statement
      }
      client.click("NATIVE", "xpath=//*[@text='Delhi (DEL)']", 0, 1);
      if(client.waitForElement("NATIVE", "xpath=//*[@text='DEL']", 0, 10000)){
          // If statement
      }
      client.click("NATIVE", "xpath=//*[@text='Search']", 0, 1);
          
      if(client.waitForElement("NATIVE", "xpath=//*[@text='Book']", 0, 30000)){
          // If statement
      }
     //.addEntry(
      dataExchangeAPIClient.addEntry(timer.stop());
      
     // DataExchangeAPIClient dataExchangeAPIClient3 = DataExchangeAPIClientFactory.newClient("http://localhost:7400/DataExchange/v1/Service.svc/"); 
     // com.neotys.rest.dataexchange.model.TimerBuilder timer3 = com.neotys.rest.dataexchange.model.TimerBuilder.start("Indigo","searchpage");
      timer= com.neotys.rest.dataexchange.model.TimerBuilder.start("Indigo","searchpage");
      
      client.click("NATIVE", "xpath=//*[@contentDescription='IndiGo']", 0, 1);
     
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
     dataExchangeAPIClient.addEntries(Arrays.asList(eb1.build(),eb2.build(),eb3.build()));
      System.out.println(cpu);
      
      String str0 = client.getMonitorsData("D:\\SeeTest_NeoLoad_Integration\\Indigo_Monitors.csv");
      System.out.println(str0);
      
      /* Capturing Values */
      
      String lines[] = str0.split("\\r?\\n");
		
		String[] val=lines[2].split(",");
		
		String[] valFinal=new String[val.length];
		for(int i=0; i<val.length; i++)
		{
			valFinal[i] = val[i];
		//System.out.println(val[i]);
		}
		
		for(int i=0; i<valFinal.length; i++)
		{
		//	valFinal[i] = val[i];
		System.out.println(valFinal[i]);
		}
      System.out.println("\n");
      /* Capturing Values Complete */
		
      client.applicationClearData("in.goindigo.android");
      
      dataExchangeAPIClient.addEntry(timer.stop());
      
  	}
  

  @After
  public void tearDown(){
      // Generates a report of the test case.
      // For more information - http://experitest.com/studio/help2/WebHelp/help.htm#Report_Of_Executed_Script.htm .
      client.generateReport(false);
      // Releases the client so that other clients can approach the agent in the near future. 
      client.releaseClient();
  }
}
