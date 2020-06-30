package Week1.Les1.Practicum4;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] arg) throws Exception {
        ServerSocket ss = new ServerSocket(4711);
        try{
            while (true) {
                Socket s = ss.accept();

                OutputStream os = s.getOutputStream();

                String httpResponse = "HTTP/1.1 200 OK\n\n" + "<h1>It Works!</h1>";
                os.write(httpResponse.getBytes("UTF-8"));

                s.close();
            }

        }catch (Exception e) {
            System.out.println("Socket closed");
        }
        ss.close();
    }
}
