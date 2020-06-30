package Week1.Les1.Practicum3;

import java.net.Socket;
import java.util.Scanner;
import java.io.OutputStream;
import java.io.PrintWriter;

class Client {
	public static void main(String[] arg) throws Exception {
		Socket s = new Socket("localhost", 4711);
		OutputStream os = s.getOutputStream();
		PrintWriter out = new PrintWriter(os);
		Scanner sc = new Scanner(System.in);
		String invoer=sc.nextLine()+"\n";
		out.print(invoer);
		out.flush();
		while (!invoer.equals("stop\n")) {
			sc = new Scanner(System.in);
			invoer=sc.nextLine()+"\n";
			out.print(invoer);
			out.flush();
		}
		//out.println();
		out.flush();
		out.close();
		os.close();
		s.close();
	}
}
