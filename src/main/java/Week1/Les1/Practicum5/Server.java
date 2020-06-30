package Week1.Les1.Practicum5;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4711);
        while (true) {
            MyServlet servlet = new MyServlet(ss.accept());

            servlet.start();
        }
    }
}
