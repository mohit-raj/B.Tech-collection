import java.util.Scanner;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class serverClass
{   
    public static void main(String args[])
    {   
            try
            {
                Socket socket;
                ServerSocket serverSocket;
                final int PORTNUM = 12345;
                serverSocket = new ServerSocket(PORTNUM);
                someService calculatorService;
                Thread thread;
                while(true)
                {
                    System.out.println("Server Waiting");
                    socket = serverSocket.accept();
                    calculatorService = new someService(socket);
                    thread = new Thread(calculatorService);
                    thread.start();
                }
            }
            catch(IOException ioe)
            {
                System.out.println("Error occured: " + ioe.getMessage());
            }
    }
}