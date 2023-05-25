import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket("localhost",3000);
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            Scanner sc = new Scanner(System.in);
            String line = "";
            while(!"exit".equalsIgnoreCase(line)){
                line = sc.nextLine();
                out.println(line);
                out.flush();

                System.out.println("server msg:"+in.readLine());
            }
            sc.close();

        }catch(IOException e){
            System.out.println(e);
        }

    }


}