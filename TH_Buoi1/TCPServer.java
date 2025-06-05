import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args){
        try {
            ServerSocket ss = new ServerSocket(12345);
            System.out.println("Server dang chay...");

            Socket s = ss.accept();
            System.out.println("Client da ket noi: " + s.getInetAddress());

            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();

            while (true) {
                int ch = is.read();
                if (ch == -1 || ch == (int)'@') break; // Dừng khi gặp '@' hoặc client ngắt

                String response;
                switch (ch) {
                    case '0': response = "khong"; break;
                    case '1': response = "mot"; break;
                    case '2': response = "hai"; break;
                    case '3': response = "ba"; break;
                    case '4': response = "bon"; break;
                    case '5': response = "nam"; break;
                    case '6': response = "sau"; break;
                    case '7': response = "bay"; break;
                    case '8': response = "tam"; break;
                    case '9': response = "chin"; break;
                    default: response = "Khong phai so nguyen";
                }

                // Gửi phản hồi về cho client
                os.write(response.getBytes());
                os.write('\n'); // để client biết là hết chuỗi (tùy client xử lý)
            }

            System.out.println("Client da thoat. Dong ket noi.");
            s.close();
            ss.close();

        } catch (IOException e) {
            System.out.println("Loi server: " + e.getMessage());
        }
    }
}
