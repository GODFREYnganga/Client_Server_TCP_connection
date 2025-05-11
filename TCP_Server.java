import java.io.*;
import java.net.*;

public class TCP_Server {
    private static ServerSocket serverSocket;
    private static final int PORT = 5154;

    public static void main(String[] args) {
        System.out.println("In opening the server port ___\n");
        try {
            serverSocket = new ServerSocket(PORT);
            do {
                runserver();
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void runserver() {
        Socket link = null;
        try {
            link = serverSocket.accept();
            BufferedReader input = new BufferedReader(new InputStreamReader(link.getInputStream()));
            PrintWriter output = new PrintWriter(link.getOutputStream(), true);
            String in = input.readLine();
            int numMess = 0;
            while (!in.equals("EXIT")) {
                numMess++;
                System.out.println(numMess + " received from client\n");
                output.println("\n Message no: " + numMess + " it has been received");
                in = input.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                System.out.println("\n closing the PORT ___\n");
                if (link != null) {
                    link.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}