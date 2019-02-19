import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
 

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


class Kota {
	
	//@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		int arr[] = {40, 60,50}; 
        System.out.println("The highest common factor: "+highestCommonFactor(arr));
        
		String file_path = "address.json"; //Path for json file
		displayAllAddress(file_path); //Displays all addresses in file
		        
	}
	

	// Finds Highest common divisor between 2 numbers
	static int gcd(int a, int b){ 
		if(a == 0)
			return b;
		return gcd(b % a,a);	
    } 
  
    // Determines highest common factor between numbers in an array
    static int highestCommonFactor(int arr[]) 
    { 
        int result = arr[0]; 
        for (int i = 1; i < arr.length; i++){
            result = gcd(arr[i], result);
        }
        return result; 
    }

    
    // Returns pretty print address format
    public static String prettyPrintAddress(Address address) {
    	//Line details - city - province/state - postal code – country
    	
    	String addressFormat = address.getStreet()+" - "+address.getCity()+" - "+address.getPostalCode()+" - "+address.getCountry();
    	if(address.getISO().toUpperCase().equals("ZA")){
    		addressFormat = address.getStreet()+" - "+address.getCity()+" - "+address.getPostalCode()+" - "+address.getProvince()+" - "+address.getCountry();
    	}
    	return  addressFormat;
    	
    }
    
   
   //Address validation function which return address status
    public static boolean addressValidation(Address address){
    	
    	boolean status = false; // default status of address
    	
    	if(address.getStreet().isEmpty()){
    		//System.out.println("Missing street data");
    		address.setStreet("Missing street data");
    		status = true;
    	}
    	
    	if(address.getCity().isEmpty()){
    		//System.out.println("Missing city data");
    		address.setCity("Missing city data");
    		status = true;
    	}
    	
    	if(address.getPostalCode().isEmpty()){
    		//System.out.println("Missing postalcode data");
    		address.setPostalCode("Missing postal data");
    	}
    	
    	if(address.getProvince().isEmpty() && address.getISO().toUpperCase().equals("ZA")){
    		//System.out.println("Missing province data");
    		address.setProvince("Missing province data");
    		status = true;
    	}
    	
    	if(address.getCountry().isEmpty()){
    		//System.out.println("Missing country data");
    		address.setCountry("Missing country data");
    		status = true;
    	}
    	
    	return status;
    }
    
    //Display address based on address type
    public static void addressType(Address address){
    	
    	if(address.getStreet().toLowerCase().contains("box") || address.getStreet().toLowerCase().contains("private")){
    		addressValidation(address);
    	}
    	if(address.getStreet().toLowerCase().contains("str") || address.getStreet().toLowerCase().contains("ave")){
    		addressValidation(address);
    	}
    	
    }
    
    //Display all addresses in address file
    public static void displayAllAddress(String file_path){
    	
		//JSON parser object to parse read file
        JSONParser json_parser = new JSONParser();
        Address address = new Address();
        try (FileReader reader = new FileReader(file_path))
        {
            //Read JSON file
            Object obj = json_parser.parse(reader);
            JSONArray address_list = (JSONArray) obj;
            
            for (int i = 0; i < address_list.size(); i++) {
            	JSONObject json_obj = (JSONObject) address_list.get(i);
            	
            	//Set Address fields 
            	address.setStreet((String) json_obj.get("street"));
            	address.setCity((String) json_obj.get("city"));
            	address.setPostalCode((String)json_obj.get("postalcode"));
            	address.setCountry((String) json_obj.get("country"));
            	address.setProvince((String) json_obj.get("province"));
            	address.setISO((String) json_obj.get("iso2"));
            	address.setStatus(addressValidation(address)); //Validate addresses
            	System.out.println(prettyPrintAddress(address));
			}
            
            
            //addressType(address);
 
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e){
        	e.printStackTrace();
        }
  
    }
      
}
