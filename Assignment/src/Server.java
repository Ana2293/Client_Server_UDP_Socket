import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
        public static void main(String[] args){

                try(DatagramSocket datagramSocket = new DatagramSocket(1080)){

                    System.out.println("Asteapta cererea...");

                    byte [] buffer = new byte[128];

                    DatagramPacket p = new DatagramPacket(buffer, buffer.length);
                    datagramSocket.receive(p);

                    String message = new String(p.getData(), 0, p.getLength());

                    System.out.println(message);

                    buffer=(message).getBytes();
                    p = new DatagramPacket(buffer, buffer.length, p.getAddress(), p.getPort());
                    datagramSocket.send(p);

                } catch (IOException exc) {
                    System.out.println(exc.getMessage());
                }
            }
        }