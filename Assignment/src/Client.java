import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

            try (DatagramSocket datagramSocket = new DatagramSocket(1082)) {

                System.out.println("Introduceti primul numar:");
                Scanner scanner = new Scanner(System.in);
                int a = scanner.nextInt();

                System.out.println("Introduceti al doilea numar:");
                Scanner scanner1 = new Scanner(System.in);
                int b = scanner1.nextInt();

                int sum = a+b;

                byte[] message = ("Suma numerelor este:"+ sum).getBytes();

                InetSocketAddress ep = new InetSocketAddress("192.168.100.12", 1080);
                DatagramPacket p = new DatagramPacket(message, message.length, ep);
                datagramSocket.send(p);

                message = new byte[128];

                p = new DatagramPacket(message, message.length, ep);
                datagramSocket.receive(p);

                System.out.println(new String(p.getData(), 0, p.getLength()));

            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
