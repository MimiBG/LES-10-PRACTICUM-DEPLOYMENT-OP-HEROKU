package Week1.Les1.Practicum2;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] arg) throws Exception {
	    ServerSocket ss = new ServerSocket(90);
	    Socket s = ss.accept();
	    InputStream is=s.getInputStream();
	    Scanner sc = new Scanner(is);

	    while (sc.hasNextLine()) {
	      System.out.println(sc.nextLine());
	    } 
	   
	    s.close();
	    ss.close();
	    sc.close();
	    }
}
