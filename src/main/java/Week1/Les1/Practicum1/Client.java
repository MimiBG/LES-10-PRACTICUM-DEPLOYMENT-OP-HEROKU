package Week1.Les1.Practicum1;

import java.net.Socket;
import java.io.OutputStream;

class Client {
  public static void main(String[] arg) throws Exception {
    Socket s = new Socket("145.89.166.167", 4711);
    OutputStream os = s.getOutputStream();
    os.write("Daan man\n".getBytes());
    s.close();
  }
}