package Week1.Les1.Practicum2;

import java.net.Socket;
import java.io.OutputStream;
import java.io.PrintWriter;

class Client {
  public static void main(String[] arg) throws Exception {
    Socket s = new Socket("145.89.154.25", 90);
    OutputStream os = s.getOutputStream();
    PrintWriter out = new PrintWriter(s.getOutputStream(), true);
    
    out.println("Dit bericht verschijnt in de console van de servers");
    out.flush();
    out.close();
    os.close();
    s.close();
  }
}
