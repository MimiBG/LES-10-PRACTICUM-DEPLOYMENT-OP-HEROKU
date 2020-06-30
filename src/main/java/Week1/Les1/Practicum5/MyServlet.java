package Week1.Les1.Practicum5;

import java.io.IOException;
import java.io.OutputStream;
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

                    String httpResponse = "HTTP/1.1 200 OK\r\n\r\n" + "<h1>It Works!</h1>";
                    os.write(httpResponse.getBytes("UTF-8"));

                    socket.close();
                }
            }


        } catch (IOException ioe) {
            System.out.println("IOexception");
        }
			// TODO Auto-generated catch block

    }
}

