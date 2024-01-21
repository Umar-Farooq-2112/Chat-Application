package Main;

import javax.swing.*;
import java.io.*;
import java.lang.Thread;
import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;

public class User extends Basic_User implements Runnable, ContactsManager,Sender,BackendManagement{
    private ServerSocket server;
//    private ArrayList <Socket> Sockets=new ArrayList<Socket>();
    private ArrayList<Contacts>All_Contacts=new ArrayList<Contacts>();
    private String password;
    private String ID;
    public User(String name,String id,int port,String pass){
        super(name,port);
        setPassword(pass);
        setID(id);
    }
    public void setID(String id){
        this.ID=id;
    }
    public void setPassword(String pass){
        this.password=pass;
    }
    public ArrayList<Contacts> getAll_Contacts(){
        return All_Contacts;
    }

    public void newMessages(Message input) throws IOException {
        for(int i=0;i<All_Contacts.size();i++)
        {
            if (input.getPort()==All_Contacts.get(i).getport()){
                All_Contacts.get(i).addmsg(input);
            }
        }
    }
    public void storemsgs() throws IOException {
        for (int i=0;i<All_Contacts.size();i++)
        {
            All_Contacts.get(i).storemsgs();
        }
    }

    public void run() {
        while (true) {
            Message temp=null;
            Socket socket = null;
            try {
                socket = server.accept();
                InputStream in = socket.getInputStream();
                DataInputStream inp = new DataInputStream(in);

                if (!socket.getInputStream().toString().isEmpty()) {
                    String incoming_msg = inp.readUTF();
                    temp=new Message(Integer.parseInt(incoming_msg.substring(0,4)),incoming_msg.substring(4)) ;
                    newMessages(temp);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if ((All_Contacts.get(Main.UI.getCon()).getport())==temp.getPort()){
                Main.UI.chatArea.append("Person : "+temp.getContent()+"\n");
            }
        }
    }
    public void sendmsg(Message msg) throws IOException {
    Socket socket=new Socket(InetAddress.getLocalHost(),msg.getPort());
    DataOutputStream out=new DataOutputStream(socket.getOutputStream());
    out.writeUTF(Integer.toString(Main.User_Person.getport())+msg.getContent());
    newMessages(new Message(Main.User_Person.getport(),msg.getContent()));
    out.flush();
    out.close();
    socket.close();
}

    public void startServer(){
        try{
            server=new ServerSocket(getport());
        }catch (Exception e) {
            System.out.println("Port Number is not available");
            port_number++;
            try {
                server = new ServerSocket(Main.User_Person.getport());
                JOptionPane.showMessageDialog(null,"Port Number set to: "+Integer.toString(port_number));
            }catch (Exception b)
            {
                JOptionPane.showMessageDialog(null,"Cannot initialize socket unavailable");
            }
        }

    }
    public void stopServer(){
        try {
            server.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean authenticatenewcontacts(String Name,int port) {
        for (int i = 0; i < All_Contacts.size(); i++) {
            if (All_Contacts.get(i).getname() == Name || All_Contacts.get(i).getport() == port) {
                return true;
            }
        }
        return false;
    }
    public boolean authenticateport(int port){
        for (int i = 0; i < All_Contacts.size(); i++) {
            if (All_Contacts.get(i).getport() == port) {
                return true;
            }
        }
        return false;
    }
    public void add_New_Contact(String Name,int port) throws IOException {
        Contacts temp = new Contacts(Name, port);
        All_Contacts.add(temp);
        String file = "Files/Database/" + Main.User_Person.getname() + Integer.toString(Main.User_Person.getport());
        File myfile = new File(file + "/" + Name + port + ".txt");
        myfile.createNewFile();
        FileWriter contacts=new FileWriter(file+"/Contacts.txt",true);
        FileWriter ports=new FileWriter(file+"/Ports.txt",true);
        contacts.write(Name+"\n");
        ports.write(Integer.toString(port)+"\n");
        contacts.close();
        ports.close();
    }
    public void deleteContact(int port) {
        String name="";

        for (int i=0;i<All_Contacts.size();i++)
        {
            if(All_Contacts.get(i).getport()==port)
            {
                name=All_Contacts.get(i).getname();
                All_Contacts.remove(i);
            }
        }
        try {
            String file="Files/Database/"+Main.User_Person.getname()+Integer.toString(Main.User_Person.getport())+"/";
            File files=new File(file+name+port);
            files.delete();
            FileWriter contacts = new FileWriter(file + "Contacts.txt");
            FileWriter ports = new FileWriter(file + "Ports.txt");

            for (int i = 0; i < All_Contacts.size(); i++) {
                contacts.write(All_Contacts.get(i).getname() + "\n");
                ports.write(All_Contacts.get(i).getport() + "\n");
            }
            contacts.close();
            ports.close();
        }catch(Exception e){}
    }
    public void loadAllContacts() throws IOException {
        String directory="Files/Database/"+Main.User_Person.getname()+ Integer.toString(Main.User_Person.getport())+"/";
        Scanner contacts=new Scanner(new File(directory+"Contacts.txt"));
        Scanner ports=new Scanner(new File(directory+"Ports.txt"));
        Scanner messages;
        String messg;

        while(contacts.hasNextLine()){
            Contacts temp=new Contacts(contacts.nextLine(), ports.nextInt());
            messages=new Scanner(new File(directory+temp.getname()+Integer.toString(temp.getport())+".txt"));
            while(messages.hasNextLine()){
                messg=messages.nextLine();
                temp.addmsg((new Message(Integer.parseInt(messg.substring(0,4)),(messg.substring(4)))));
            }
            All_Contacts.add(temp);
            messages.close();
        }
        contacts.close();
        ports.close();
        startServer();
        Thread thr=new Thread(Main.User_Person);
        thr.start();
    }
}
