package Week1.Les1.Practicum6;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServlet extends Thread {
    private Socket socket;

    public MyServlet(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            Scanner sc = new Scanner(socket.getInputStream());
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());

                if ("".equals(sc.nextLine())) {
                    OutputStream os = socket.getOutputStream();

                    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "<h1>It works!</h 1>";
                    os.write(httpResponse.getBytes("UTF-8"));
                    Thread.sleep(10000);
                    socket.close();
                }
            }


        } catch (IOException ioe) {
            System.out.println("IOexception");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}