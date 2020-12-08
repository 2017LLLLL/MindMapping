package myeasytomcat;

public abstract class MyInterface {

    public abstract void doGet(MyRequest myRequest,MyResponse myResponse) throws Exception;

    public abstract void doPost(MyRequest myRequest,MyResponse myResponse) throws Exception;


    public void service(MyRequest myRequest, MyResponse myResponse) throws Exception {
        if("GET".equals(myRequest.getRequestMethod())){
            doGet(myRequest,myResponse);
        }else if("POST".equals(myRequest.getRequestMethod())) {
            doPost(myRequest,myResponse);
        }
    }

}
