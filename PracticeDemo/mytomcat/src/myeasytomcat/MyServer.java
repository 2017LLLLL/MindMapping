package myeasytomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void startServer(int port) throws Exception {
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket = null;

        while(true){
            System.out.println("start");
            socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();
            MyRequest myRequest = new MyRequest(inputStream);
            MyResponse myResponse = new MyResponse(outputStream);
            String handlerStr = MyMapping.getMap(myRequest.getRequestUri());
            if(handlerStr !=null) {
                Class<MyServlet> handlerClass = (Class<MyServlet>)Class.forName(handlerStr);
                MyServlet myServlet = handlerClass.newInstance();
                myServlet.service(myRequest, myResponse);
                System.out.println("finish");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        startServer(12345);
    }

}
