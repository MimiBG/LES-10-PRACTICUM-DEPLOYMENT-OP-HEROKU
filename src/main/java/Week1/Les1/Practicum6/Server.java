package Week1.Les1.Practicum6;

import java.net.ServerSocket;

public class Server {
    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4712);
        while (true) {
            MyServlet servlet = new MyServlet(ss.accept());

            servlet.start();
        }
    }
}