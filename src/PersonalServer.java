import java.io.IOException;
import java.io.*;
import java.net.*;

public class PersonalServer extends Thread {
    
    // static ================================================================
    static DatagramSocket ds;                // UDP�� ���� ����
    static {
        try {
            ds = new DatagramSocket(56789);
        }catch(IOException e) {
            System.out.println("alramSocket create failed.. " + e.toString());
        }
    }
    
    static void sendAlramToAll(String alram, User[] users) {            // ��� �������� UDP����
        DatagramPacket dp = new DatagramPacket(alram.getBytes(), alram.getBytes().length);
        for(User a : users) {
            dp.setSocketAddress(a.adress);
            try {
                System.out.println("server UDP send");
                
                ds.send(dp);
            }catch(IOException e) {
                System.out.println("[server-Thread] send alarm failed .. " + e.toString());
            }
        }
    }    
    
    static void sendAlramToUser(SocketAddress sa, String alram) {        // Ư�� �������� UDP ����
        DatagramPacket dp = new DatagramPacket(alram.getBytes(), alram.getBytes().length);
        dp.setSocketAddress(sa);
        try {
            System.out.println("server UDP send");
            ds.send(dp);
        }catch(IOException e) {
            System.out.println("[server-Thread] send alarm failed .. " + e.toString());
        }
        
    }
    
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
        String[] command = null;
        while(socket.isConnected()) {
            String received = null;
            try {
                received = (String)ois.readObject();
            }catch(IOException | ClassNotFoundException e) {    // ������ �����
                System.out.println("[server] ������ ����");
            }
            
            System.out.println("[server] received : " + received);
            //command = received.split("#");
            //Object resp = null;
            //System.out.println(command[0]);
            //switch(command[0]) {
                
                // Ŭ���̾�Ʈ�� ��û�� ���� ó��
                    
            //}
        }
    }
    
    // TCP�� �̿��� Ŭ���̾�Ʈ���� ����������
    public void sendToString(String resp) {
        try {
            oos.reset();
            oos.writeObject(resp);
            System.out.println(resp);
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
