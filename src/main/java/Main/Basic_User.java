package Main;

import java.util.Vector;

public class Basic_User {
    protected int port_number;
    protected String name;
    public Basic_User(String name,int port){
        setname(name);
        setport(port);
    }
    public void setname(String name){
        this.name=name;
    }
    public void setport(int port){
        if(port>1000&&port <65000)
            this.port_number=port;
    }
    public String getname(){
        return this.name;
    }
    public int getport(){
        return this.port_number;
    }

}
