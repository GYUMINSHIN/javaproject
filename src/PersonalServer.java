import java.io.IOException;
import java.io.*;
import java.net.*;

public class PersonalServer extends Thread {
    //=========================================================================================
    
    public Socket socket;
    public ObjectOutputStream oos;
    public ObjectInputStream ois;
    public User user;        //  ���� ���� ��ü ����
    
    // ������ ================================
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
            }catch(IOException | ClassNotFoundException e) {    // ������ �����
                System.out.println("[server] ������ ����");
            }
            
            System.out.println("[server] " + received + " joined");
            user = new User(received, 0);
        }
    }
    
    // TCP�� �̿��� Ŭ���̾�Ʈ���� ����������
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
