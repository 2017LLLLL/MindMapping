package myeasytomcat;

public class MyServlet extends MyInterface{

    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) throws Exception {
        myResponse.write("my get");
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) throws Exception {
        myResponse.write("my post");
    }
}
