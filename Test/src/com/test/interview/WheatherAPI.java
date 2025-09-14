package com.test.interview;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class WheatherAPI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		xmlLoader();
	}
	public static final String[] xmlLoader(){
	    String xmlData[] = new String[2];
	    int dateCounter = 1;
	    try {
		    try {
		    	// Creating an object of URL class
		        URL u = new URL("https://api.postalpincode.in/pincode/560100");
		        // communicate between application and URL
		        URLConnection urlconnect = u.openConnection();
		        // for our application streams to be read
		        BufferedReader br = new BufferedReader(new InputStreamReader(urlconnect.getInputStream()));
		        // Declaring an integer variable
		        String readAPIResponse = " ";
		        StringBuilder builder = new StringBuilder();
		        // Till the time URL is being read
		        while ((readAPIResponse = br.readLine()) != null) {
		        	builder.append(readAPIResponse);
		        }
		        JSONArray jsonArray = new JSONArray(builder.toString().trim());
		        String cuntryName = "";
		        for (int i =0;i<jsonArray.length();i++) {
		        	JSONArray jsonObj = jsonArray.getJSONObject(i).getJSONArray("PostOffice");//.getJSONObject(i);	
		        	if(jsonObj.getJSONObject(i) instanceof JSONObject) {
			        	JSONObject arrayOfJson = jsonObj.getJSONObject(i);
			        	if(arrayOfJson.get("Country") != null)
			        	cuntryName = arrayOfJson.get("Country").toString();
			            System.out.println(cuntryName);
			        	break;
                      }
		        }
	        }
	 
	        // Catch block to handle the exception
	        catch (Exception e) {
	 
	            // Print the exception on the console
	            System.out.println(e);
	        }
	    	
	        URL googleWeatherXml = new URL("https://api.postalpincode.in/pincode/560100");
	        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();    
	        Document doc = db.parse(googleWeatherXml.openStream());

	         // normalize text representation
	        doc.getDocumentElement ().normalize ();
	        NodeList listOfWeek = doc.getElementsByTagName("");

	            Node firstWeekNode = listOfWeek.item(dateCounter-1);


	            //Break xml file into parts, then break those parts down int an array by passing individual elements to srtings
	            if(firstWeekNode.getNodeType() == Node.ELEMENT_NODE){
	                Element firstWeekElement = (Element)firstWeekNode;
	                //-------
	                NodeList dateList = firstWeekElement.getElementsByTagName("date");
	                Element dateElement = (Element)dateList.item(0);

	                NodeList textDateList = dateElement.getChildNodes();
	                xmlData[0]= (((Node)textDateList.item(0)).getNodeValue().trim()).toString();

	                //-------
	                NodeList riddleList = firstWeekElement.getElementsByTagName("riddle");
	                Element riddleElement = (Element)riddleList.item(0);

	                NodeList textRiddleList = riddleElement.getChildNodes();
	                xmlData[1]= (((Node)textRiddleList.item(0)).getNodeValue().trim()).toString();

	                //----
	                NodeList lWSList = firstWeekElement.getElementsByTagName("lastWeekSolution");
	                Element ageElement = (Element)lWSList.item(0);

	                NodeList textLWSList = ageElement.getChildNodes();
	                xmlData[2]= (((Node)textLWSList.item(0)).getNodeValue().trim()).toString();

	                //------
	            }//end of if clause

	    }
	    catch(MalformedURLException f){System.err.println(f.getMessage()); }
	    catch(NullPointerException npe){
	        System.out.println("The Weather Data you searched for is incorrect or does not yet exist, try again. ");
	        String s[] = {" ", " "};
	        main(s);
	    }

	   catch (SAXParseException err) {
	    System.out.println ("** Parsing error" + ", line " 
	         + err.getLineNumber () + ", uri " + err.getSystemId ());
	    System.out.println(" " + err.getMessage ());

	    }
	    catch (SAXException e) {
	    Exception x = e.getException ();
	    ((x == null) ? e : x).printStackTrace ();

	    }catch (Throwable t) {
	    t.printStackTrace ();
	    }
	    

	    
	    return xmlData;
	}
}
