import java.util.Scanner;
import java.io.PrintWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class someService implements Runnable
{
        Socket socket;
        InputStream is;
        OutputStream os;
        Scanner lRdr;
        PrintWriter pw;
        String command, response;
        public someService(Socket fromServer)
        {
            socket = fromServer;
        }
        public void run()
        {
            try
            {
                try
                {
                    is = socket.getInputStream();
                    lRdr = new Scanner(is);
                    os = socket.getOutputStream();
                    pw = new PrintWriter(os);
                    while(lRdr.hasNext())
                    {
                        command = lRdr.nextLine();
                        if(command.equals("quit"))
                        {
                            response = "bye";
                            pw.println(response);
                            pw.flush();
                            response = " ";
                        }
                        else
                        {
                            processCommand();
                        }
                    }
                }
                finally
                {
                    socket.close();
                }
            }
                catch(IOException ioe)
                {
                    System.out.println("Error here in service class" + ioe.getMessage());
                }
        }
public void processCommand()
{
    String pieces[] = command.split(" ");
    int op1 = Integer.parseInt(pieces[0]);
    int op2 = Integer.parseInt(pieces[2]);
    char operator = pieces[1].charAt(0);
    switch(operator)
    {
        case '+' :  response = op1 + op2 + "";
                    pw.println (response);
                    response = "";
                    pw.flush ();
                    break;
        case '-' :  response = op1 - op2 + "";
                    pw.println (response);
                    response = "";
                    pw.flush ();
                    break;
        case '*' :  response = op1 * op2 + "";
                    pw.println (response);
                    response = ""; pw.flush ();
                    break;
        case '/' :  response = op1 / op2 + "";
                    pw.println (response);
                    response = "";
                    pw.flush ();
                    break;
        default  :  response = "bad command";
                    pw.println (response);
                    response = "";
                    pw.flush ();
                    break;
    }
}
        
}



