package business;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@RequestScoped
@Path("")
@Produces({ "application/xml", "application/json" })
@Consumes({ "application/xml", "application/json" })
public class RestService {
	
	public String retrieveJSON(String urlStrg)
	{
		String strg =  " ";
		try
        {

              URL url = new URL(urlStrg);
                                                                                                                                                                                       
              HttpURLConnection conn = (HttpURLConnection) url.openConnection();
              conn.setRequestMethod("GET");
              conn.setRequestProperty("Accept", "application/json");
              if (conn.getResponseCode() != 200)
              {
                     throw new RuntimeException("Failed : HTTP Error code : " + conn.getResponseCode());
              }
              InputStreamReader in = new InputStreamReader(conn.getInputStream());
              BufferedReader br = new BufferedReader(in);
              String output;
              while ((output = br.readLine()) != null)
              {
                   strg += output;
              }
              conn.disconnect();
              return strg;

        }
		catch (Exception e)
        {
              System.out.println("Exception in retireveJSON:- " + e);
        }
		return strg;
 }
}

