package Main;

import com.sun.source.tree.UsesTree;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Objects;
import java.util.Scanner;

public class UserAuthentiation{
    private String name;
    private String id;
    private String password;
    private int port;
    public boolean authenticate(String id,String password) throws FileNotFoundException {
        File ids=new File("Files/Users.txt");
        File pass=new File("Files/Passwords.txt");
        File in_port= new File("Files/Ports.txt");
        File in_name=new File("Files/Names.txt");

        String id_check,pass_check,name_check;
        int port_check;
        Scanner scanids=new Scanner(ids);
        Scanner scanpass=new Scanner(pass);
        Scanner scanname=new Scanner(in_name);
        Scanner scanport=new Scanner(in_port);
        while(scanids.hasNext()) {
            id_check = scanids.nextLine();
            pass_check = scanpass.nextLine();
            name_check=scanname.nextLine();
            port_check=scanport.nextInt();
            if(id_check.equals(id))
            {
                if(pass_check.equals( password))
                {
                    name=name_check;
                    id=id_check;
                    password=pass_check;
                    port=port_check;
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    public boolean ifUserAvailable(String ID) throws FileNotFoundException {
        File file=new File("Files/Users.txt");
        Scanner scanuser=new Scanner(file);
        while(scanuser.hasNext()){
            if(ID.equals(scanuser.nextLine())){
                return false;
            }
        }
        return true;
    }
    public boolean ifPortAvailable(int port_number) throws FileNotFoundException {
        Boolean Output;
        File file=new File("Files/Ports.txt");
        Scanner scanuser=new Scanner(file);
        while(scanuser.hasNextInt()){
            if(port_number==scanuser.nextInt()){
                return false;
            }
        }
        try {
            ServerSocket temp = new ServerSocket(port_number);
            temp.close();
            return true;
        }catch(Exception e){
            return false;
        }
    }
    public void newUser(String ID,String Pass,String Name) throws IOException {
        name=Name;
        id=ID;
        password=Pass;
        int temp_port;
        while(true) {
            temp_port= (int) (Math.random() * 10000);
            temp_port%=5000;
            temp_port+=4999;
            if (ifPortAvailable(temp_port)){
                port=temp_port;
                break;
            }
        }

        FileWriter names=new FileWriter("Files/Names.txt",true);
        FileWriter passwords=new FileWriter("Files/Passwords.txt",true);
        FileWriter Users=new FileWriter("Files/Users.txt",true);
        FileWriter ports=new FileWriter("Files/Ports.txt",true);

        names.write(name+"\n");
        passwords.write(password+"\n");
        Users.write(id+"\n");
        ports.write(Integer.toString(port)+"\n");

        names.close();
        passwords.close();
        Users.close();
        ports.close();

        String location="Files/Database/"+name+Integer.toString(port);
        File directory=new File(location);
        directory.mkdir();
        File temp=new File(location+"/Contacts.txt");
        temp.createNewFile();
        temp=new File(location+"/Ports.txt");
        temp.createNewFile();
    }
    public User Successful(){
        return new User(name,id,port,password);
    }
}
