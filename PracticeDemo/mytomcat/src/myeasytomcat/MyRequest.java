package myeasytomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {

    private String RequestMethod;

    private String RequestUri;

    public MyRequest(InputStream inputStream) throws Exception {
        byte[] bytes = new byte[1024];
        int len = 0;

        String httpInput = null;

        if((len = (inputStream.read(bytes))) >0){
            httpInput = new String(bytes,0,len);
        }
        // 根据HTTP请求分割出请求头
        String requestHeader = httpInput.split("\n")[0];
        this.RequestUri = requestHeader.split(" ")[1];
        this.RequestMethod = requestHeader.split(" ")[0];
    }


    public String getRequestMethod() {
        return RequestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        RequestMethod = requestMethod;
    }

    public String getRequestUri() {
        return RequestUri;
    }

    public void setRequestUri(String requestUri) {
        RequestUri = requestUri;
    }


}
