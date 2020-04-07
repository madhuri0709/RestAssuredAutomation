package javacollections;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.TimeZone;

public class ArrayListExample {
	
	// loop arraylist 
	
	public static void main(String args[]) {
        // initialize ArrayList  
        ArrayList<Integer> al = new ArrayList<Integer>();
        // add elements to ArrayList object
        al.add(3);
        al.add(17);
        al.add(6);
        al.add(9);
        al.add(7);
        System.out.println("Using Advanced For Loop");   
        // printing ArrayList 
        for (Integer num : al) {         
            System.out.println(num);   
        }
        
        //converting arraylist to array
        /*ArrayList declaration and initialization*/
        ArrayList<String> cities= new ArrayList<String>();
        cities.add("Boston");
        cities.add("Dallas");
        cities.add("San jose");
        cities.add("Chicago");

        /*ArrayList to Array Conversion */
        String citinames[]=cities.toArray(new String[cities.size()]);

        /*Displaying Array elements*/
        for(String k: citinames)
        {
        System.out.println(k);
        }
        
    // sorting elements of arraylist
	
	ArrayList<String> arraylist = new ArrayList<String>();
    arraylist.add("Apple");
    arraylist.add("Banana");
    arraylist.add("Pear");
    arraylist.add("Mango");

    /*Unsorted List: ArrayList content before sorting*/
    System.out.println("ArrayList Before Sorting:");
    for(String str: arraylist){
   System.out.println(str);
  }

    /* Sorting in decreasing (descending) order*/
    Collections.sort(arraylist, Collections.reverseOrder());

    /* Sorted List in reverse order*/
    System.out.println("ArrayList in descending order:");
    for(String str: arraylist){
   System.out.println(str);
    }
	
	
	}
	
	// in real time we can make use ArrayList in multiple situatioms .
	// for example, in below scenario I have different ship address , depending on area code the shipping options may vary
	
	public static String getDate(int days) {
        Date currentDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.mmm");
        Calendar cal = Calendar.getInstance();
        cal.setTime(currentDate);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        dateFormat.setTimeZone(TimeZone.getTimeZone("EST"));
        return dateFormat.format(cal.getTime()).replace(" ", "T");
    }
	
	public static ArrayList<String> getShipMethodWithDueDate(String addType, String shipMType) {
        ArrayList<String> shipDate = new ArrayList<String>();
        String shipMethod = "";
        String dueDate = "";
        if (addType.equals("apo_addresses") || addType.equals("fpo_addresses") || addType.equals("us_territories") || addType.equals("iship_address")) {
            dueDate = getDate((addType.equals("apo_addresses") || addType.equals("fpo_addresses")) ? 42 : (addType.equals("us_territories") ? 21 : 10));
            shipMethod = "USP1";
        } else if (shipMType.equals("Standard")) {
            shipMethod = "UGRD";
            dueDate = getDate(addType.equals("puerto_addresses") ? 12 : 7);
        } else if (shipMType.equals("Express")) {
            shipMethod = "U2DA";
            dueDate = getDate(6);
        } else if (shipMType.equals("Rush")) {
            shipMethod = "UNDA";
            dueDate = getDate(5);
        } else if (shipMType.equals("N/A")) {
            shipMethod = "CPKP";
            dueDate = getDate(0);
        }
        shipDate.add(shipMethod);
        shipDate.add(dueDate);
        return shipDate;
    }

}
