package Main;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class Main extends UserInterface{
    public static User User_Person;
    public static int Port;
    public static UserInterface UI;
    public static Thread thread;
    public static Thread receivemsgs;



    public static void main(String[] args) throws InterruptedException, IOException {

        UI = new UserInterface();
            UI.LoginScreen();
            UI.MainDisplay();

    }

    public static void setUser_Person(User input){
        User_Person=input;
    }
    public static User getUser_Person(){
        return User_Person;
    }
    public static int getPort(){
        return Port;
    }
    public static void setPort(int port){
        Port=port;
    }





}