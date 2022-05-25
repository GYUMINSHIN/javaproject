import java.io.IOException;
import java.io.*;
import java.net.*;

public class PersonalServer extends Thread {
    
    // static ================================================================
    static DatagramSocket ds;                // UDP를 위한 소켓
    static {
        try {
            ds = new DatagramSocket(56789);
        }catch(IOException e) {
            System.out.println("alramSocket create failed.. " + e.toString());
        }
    }
    
    static void sendAlramToAll(String alram, User[] users) {            // 모든 유저에게 UDP전송
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
    
    static void sendAlramToUser(SocketAddress sa, String alram) {        // 특정 유저에게 UDP 전송
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
        String[] command = null;
        while(socket.isConnected()) {
            String received = null;
            try {
                received = (String)ois.readObject();
            }catch(IOException | ClassNotFoundException e) {    // 비정상 종료시
                System.out.println("[server] 비정상 종료");
            }
            
            System.out.println("[server] received : " + received);
            //command = received.split("#");
            //Object resp = null;
            //System.out.println(command[0]);
            //switch(command[0]) {
                
                // 클라이언트의 요청에 따른 처리
                    
            //}
        }
    }
    
    // TCP를 이용한 클라이언트에게 데이터전송
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
