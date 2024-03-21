package Seetest;

//package <set your test package>;
import java.io.Console;
import java.io.IOException;
import java.net.URISyntaxException;
import java.security.GeneralSecurityException;

import com.experitest.client.*;
import com.neotys.rest.dataexchange.client.DataExchangeAPIClient;
import com.neotys.rest.dataexchange.client.DataExchangeAPIClientFactory;


import com.neotys.rest.error.NeotysAPIException;

import org.apache.olingo.odata2.api.exception.ODataException;
import org.junit.*;

/**
*
*/
public class demo {
	public static void main(String[] args){
		
		
	}
  private String host = "localhost";
  private int port = 8889;
  private String projectBaseDirectory = "C:\\Users\\vijesh\\workspace\\project2";
  protected Client client = null;

  @Before
  public void setUp(){
      client = new Client(host, port, true);
      client.setProjectBaseDirectory(projectBaseDirectory);
      client.setReporter("xml", "reports", "Untitled");
  }

  @Test
  public void testUntitled() throws NeotysAPIException, GeneralSecurityException, IOException, ODataException, URISyntaxException {
      client.setDevice("adb:GT-N7100");
    DataExchangeAPIClient dataExchangeAPIClient = DataExchangeAPIClientFactory.newClient("http://localhost:7400/DataExchange/v1/Service.svc/");     
      com.neotys.rest.dataexchange.model.TimerBuilder timer = com.neotys.rest.dataexchange.model.TimerBuilder.start("Ushaidi","landingpage");
      client.launch("http://ushahidi.demo.neotys.com/", true, false);
     
      if(client.waitForElement("WEB", "text=Submit a Report", 0, 120000)){
          // If statement
      }
    dataExchangeAPIClient.addEntry(timer.stop());
    client.startMonitor("cpu");
    String str0 = client.getCounter("cpu");
    System.out.println(str0);
      
      client.click("WEB", "text=Submit a Report", 0, 1);
      if(client.waitForElement("WEB", "id=incident_title", 0, 30000)){
          // If statement
      }
      client.elementSendText("WEB", "id=incident_title", 0, "fire");
      if(client.waitForElement("NATIVE", "contentDescription=Web View", 0, 10000)){
          // If statement
      }
      client.click("NATIVE", "contentDescription=Web View", 0, 1);
      client.elementSendText("NATIVE", "contentDescription=Web View", 0, "ddddd");
      client.click("NATIVE", "contentDescription=Web View", 0, 1);
      client.click("NATIVE", "contentDescription=Web View", 0, 1);
      client.click("NATIVE", "xpath=//*[@class='android.widget.LinearLayout' and ./*[@class='android.view.ViewStub']]", 0, 1);
     

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
