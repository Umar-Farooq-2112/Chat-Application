package Main;

import javax.sound.sampled.Port;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Contacts extends Basic_User{
    private ArrayList<Message> Messages;
    public Contacts(String name,int port){
        super(name,port);
        Messages=new ArrayList<Message>();
    }

    public void addmsg(Message temp){
        Messages.add(temp);
    }
    public void addmessage(Message newMsg,String directory) throws IOException {
        Messages.add(newMsg);

        BufferedWriter msgsfile=new BufferedWriter(new FileWriter(new File(directory),true));
        msgsfile.write(newMsg.getContent());
        msgsfile.close();
    }

    public void storemsgs() throws IOException {
        String directory="Files/Database/"+Main.User_Person.getname()+Main.User_Person.getport()+"/"+getname()+getport()+".txt";
        FileWriter file=new FileWriter(directory);

        for (int j=0;j<Messages.size();j++)
            file.write(Integer.toString(Messages.get(j).getPort())+Messages.get(j).getContent()+"\n");
    }
    public ArrayList<Message> getMessages(){return Messages;}
}