package ExtProb;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CSVFIle {
 
public static void main(String[] args) {
    
    String str =  "A1: 5, A2: 7, A3: 9, B1: 3, B2: 8, B3: =4+5, C1: =5+A1, C2: =A2+B2, C3: =C2+B3";

    String[] arr = str.split(",");

    Map<String,String> map = new LinkedHashMap<>();

    for(String st : arr){
       String[] a =  st.split(":");
       a[1]=a[1].trim();
       if(a[1].startsWith("="))a[1]=a[1].substring(1);
        map.put(a[0], a[1]);
    }
    System.out.println(map);

}

}
