package Week1.Les1.Practicum3;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	public static void main(String[] arg) throws Exception {
while (true) {
		ServerSocket ss = new ServerSocket(4711);
			Socket s = ss.accept();
			InputStream is = s.getInputStream();
			Scanner sc = new Scanner(is);

			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}

			s.close();
			ss.close();
			sc.close();
		}
	}
}
