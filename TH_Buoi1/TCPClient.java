import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
    public static void main( String args[]){
        try{
            Socket s = new Socket("127.0.0.1", 12345);
            System.out.println("Ket noi thanh cong");

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            while (true) {
                System.out.println("Nhap 1 ki tu: ");
                int ch = System.in.read();
                System.in.skip(2);

                os.write(ch);

                if(ch == '@') break;

                int len = is.read();
                byte [] butter = new byte[len];
                is.read(butter, 0, len);

                String result = new String(butter);
                System.out.println("Nhan duoc: "+ result);

            }
            System.out.println("Dong ket noi!");
            s.close();
        } catch(UnknownHostException e){
            System.out.println("Sai dia chi Server");
        } catch(IOException  e){
            System.out.println("Loi nhap/xuat");
        }
    }
}
