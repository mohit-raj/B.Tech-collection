import java.util.Scanner;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;

public class clientClass
{
    public static void main(String args[])
    {
        try
        {
            final int PORTNUM = 12345;
            Socket socket = new Socket("localhost",PORTNUM);
            InputStream is = socket.getInputStream();
            Scanner lRdr = new Scanner(is);
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);

            String command = " ";
            String response = " ";
            Scanner kdb = new Scanner(System.in);
            while(true)
            {
                System.out.println("Enter a command");
                command = kdb.nextLine();
                if(command.equalsIgnoreCase("quit"))
                {
                    pw.println(command);
                    pw.flush();
                    break;
                }
                else
                {
                    pw.println(command);
                    pw.flush();
                    if(lRdr.hasNext())
                    {
                        response = lRdr.nextLine();
                        System.out.println(response);
                    }
                }
            }
        }
        catch(IOException ioe)
        {
            System.out.println("Error message: " + ioe.getMessage());
        }  
    }
}