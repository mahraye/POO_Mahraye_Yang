package Model.reseau;
import java.io.*;
import java.net.*;
import Controller.Controller_reseau;
import Model.messages.Message;

public class Sender {
	private DatagramSocket socket;
    
    public Sender(Controller_reseau controler) throws SocketException{
        socket = new DatagramSocket();
    }
    
    public void sendTo(Message m, String hostName, int desPort) {
        try {
            InetAddress address = InetAddress.getByName(hostName);
            ByteArrayOutputStream byteStream = new ByteArrayOutputStream(5000);
            ObjectOutputStream os = new ObjectOutputStream(new BufferedOutputStream(byteStream));
            os.flush();
            os.writeObject(m);
            os.flush();
            //retrieves byte array
            byte[] sendBuf = byteStream.toByteArray();
            DatagramPacket packet = new DatagramPacket(sendBuf, sendBuf.length, address, desPort);
          //  int byteCount = packet.getLength();
            socket.send(packet);
            os.close();
        }
        catch (UnknownHostException e)
        {
          System.err.println("Exception:  " + e);
        }
        catch (IOException e)    {}
  }

}
