package myeasytomcat;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {

    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String data) throws Exception {
        StringBuilder sb = new StringBuilder();
        // 这里要注意一定要返回相应行
        String returnData = sb.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:text/html\n")
                .append("\r\n").append("<html>")
                .append("<head>Tomcat</head>")
                .append("<body><h1>" + data + "</body></h1>")
                .append("</html>").toString();
        this.outputStream.write(returnData.getBytes());
        this.outputStream.flush();
        this.outputStream.close();
    }
}
