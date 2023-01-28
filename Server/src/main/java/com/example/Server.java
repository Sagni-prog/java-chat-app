package com.example;

import java.net.*;
import java.util.ArrayList;
import java.io.*;  
public class Server{  

    ArrayList<String> incoming = new ArrayList<>();

   public String Comm() throws IOException{
        ServerSocket ss=new ServerSocket(3333);  
        Socket s=ss.accept();  
        DataInputStream din=new DataInputStream(s.getInputStream());  
        DataOutputStream dout=new DataOutputStream(s.getOutputStream());  
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));  
        
        String str="",str2="";  
        while(!str.equals("stop")){  
            str=din.readUTF();  
            incoming.add(str);
            System.out.println(incoming);
            // System.out.println("client says: "+str);  
            str2=br.readLine();  
            dout.writeUTF(str2);  
            dout.flush();  
        }  
        din.close();  
        s.close();  
        ss.close();
        return str;  
            }
public static void main(String args[])throws Exception{  
    //   Server server = new Server();
    //   System.out.println("List => "+server.Comm());
}}  