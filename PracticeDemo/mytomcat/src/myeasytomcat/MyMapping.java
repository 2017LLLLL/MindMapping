package myeasytomcat;

import java.util.HashMap;
import java.util.Map;

public class MyMapping {
    private static HashMap<String,String> mapping = new HashMap<String,String>();

    static {
        mapping.put("/tomcat","myeasytomcat.MyServlet");
    }



    public static String getMap(String requestUri) {
        return mapping.get(requestUri);
    }
}
