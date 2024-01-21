package Main;

import java.io.File;

public class Message {
    private String content;
    private int sender_port;
    public Message(int port,String Content){
        setContent(Content);
        setSender_port(port);
    }
    String getContent(){
        return this.content;
    }
    void setContent(String msg) {
        this.content=msg;
    }
    void setSender_port(int port){
        this.sender_port=port;
    }
    int getPort(){
        return sender_port;
    }



}
