import java.io.*;
import java.net.*;

public class TCP_Client {
    private static InetAddress host;
    private static final int PORT = 5154;

    public static void main(String[] args) {
        try {
            host = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            System.out.println("\n could not get a host with such address\n");
        }
        runclient();
    }

    private static void runclient() {
        Socket link = null;
        try {
            link = new Socket(host, PORT);
            BufferedReader input = new BufferedReader(new InputStreamReader(link.getInputStream()));
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);
            BufferedReader sign = new BufferedReader(new InputStreamReader(System.in));

            String message, response;
            do {
                System.out.println("\n Enter a message to send: \n");
                message = sign.readLine();
                output.println(message);
                response = input.readLine();
                System.out.println("\n message received: " + response);
            } while (!message.equals("EXIT"));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (link != null) {
                    link.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}