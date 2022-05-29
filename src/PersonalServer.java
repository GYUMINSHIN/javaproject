import java.io.IOException;
import java.io.*;
import java.net.*;

public class PersonalServer extends Thread {
    //=========================================================================================
    
    public Socket socket;
    public ObjectOutputStream oos;
    public ObjectInputStream ois;
    public User user;        //  현재 계정 객체 저장
    
    // 생성자 ================================
    public PersonalServer(Socket socket) {
        this.socket = socket;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        }catch(IOException e) {}
    }
    //========================================
    @Override
    public void run() {
        while(socket.isConnected()) {
            String received = null;
            try {
                received = (String)ois.readObject();
            }catch(IOException | ClassNotFoundException e) {    // 비정상 종료시
                System.out.println("[server] 비정상 종료");
            }
            
            System.out.println("[server] " + received + " joined");
            user = new User(received, 0);
        }
    }
    
    // TCP를 이용한 클라이언트에게 데이터전송
    public void sendToString(String resp) {
        try {
            oos.reset();
            oos.writeObject(resp);
//            System.out.println(resp);
        }catch(IOException e) {
            System.out.println("server write fail.. " + e.toString());
        }
    }
    
    public void sendToInt(int resp) {
        try {
            oos.reset();
            oos.writeObject(resp);
            System.out.println(resp);
        }catch(IOException e) {
            System.out.println("server write fail.. " + e.toString());
        }
    
    }
}
