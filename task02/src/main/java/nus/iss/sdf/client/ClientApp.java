package nus.iss.sdf.client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Arrays;
import java.util.List;

public class ClientApp {

    public static void main(String[] args) {
        
        System.out.println("ClientApp");
        String[] connInfo = args[0].split(":");
        String hostName = connInfo[0];
        int portNo = Integer.parseInt(connInfo[1]);
        System.out.println(hostName + " " + portNo);

        Socket clientSocket = null;

        try {
        clientSocket = new Socket(hostName, portNo);
        System.out.println("Successfully connected to server.");

        // Setup input and output streams
        DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
        DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
        
        String dataFromServer = dis.readUTF();
        String[] serverDataArr = dataFromServer.split(" ");
        String requestID = serverDataArr[0];
        List<String> numList = Arrays.asList(serverDataArr[1].split(","));

        float avgNum = 0;
        float totalNum = 0;
        for (String n : numList) {
            float num = Float.parseFloat(n);
            totalNum += num;
        }
        
        avgNum = totalNum / numList.size();

        dos.writeUTF(requestID);
        dos.writeUTF("Rebekah");
        dos.writeUTF("beckykok@hotmail.com");
        dos.writeFloat(avgNum);
        dos.flush();

        boolean output = dis.readBoolean();
        if (output) {
            System.out.println("SUCCESS");
            
            dos.close();
            dis.close();
            clientSocket.close();

        } else {
            System.out.println("TRY AGAIN");
        }
    
        } catch (NumberFormatException | IOException e) { 
            e.printStackTrace();
        } 
        
    }
    
    
}
