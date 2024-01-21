package Main;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class UserInterface implements ActionListener {
    Frame MainFrame = new Frame();
    JLayeredPane MainPanel = new JLayeredPane();
    Button SignInButton;
    Button SignUpButton;

    public UserInterface() {
        JLabel BackgroundImage = new JLabel();
        ImageIcon bg = new ImageIcon("bg_logo.png");
        BackgroundImage.setIcon(bg);
        BackgroundImage.setSize(1024, 768);

        MainPanel.add(BackgroundImage, Integer.valueOf(0));
        MainPanel.setSize(1024, 768);
        MainPanel.setBackground(Color.black);
        MainFrame.add(MainPanel);
    }

    public void MainDisplay() throws InterruptedException {
        this.MainFrame.setVisible(true);
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
    }

    public void LoginScreen() {
        MainPanel.removeAll();
        JPanel login = new JPanel();
        login.setBackground(new Color(8, 1, 43));
        login.setOpaque(true);
        login.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        login.setBounds(570, 400, 300, 150);
        this.MainPanel.add(login, Integer.valueOf(1));

        JLabel BackgroundImage = new JLabel();
        ImageIcon bg = new ImageIcon("bg_logo2.png");
        BackgroundImage.setIcon(bg);
        BackgroundImage.setSize(1024, 768);
        this.MainPanel.add(BackgroundImage, Integer.valueOf(0));

        SignInButton = new Button("Sign In");
        SignInButton.addActionListener(this);
        SignUpButton = new Button("Sign Up");
        SignUpButton.addActionListener(this);
        login.setLayout(new GridLayout(2, 1));
        login.add(SignInButton);
        login.add(SignUpButton);
        this.MainFrame.setVisible(true);
    }

    TextFields User_Name;
    PasswordFields Password;
    Button LoginButton;
    Button Back;

    public void signIn() {
        JPanel login = new JPanel();
        login.setBackground(new Color(8, 1, 43));
        login.setOpaque(true);
        login.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        login.setBounds(570, 400, 400, 170);
        login.setLayout(new GridLayout(3, 2, 3, 3));

        JLabel BackgroundImage = new JLabel();
        ImageIcon bg = new ImageIcon("bg_logo2.png");
        BackgroundImage.setIcon(bg);
        BackgroundImage.setSize(1024, 768);
        this.MainPanel.add(BackgroundImage, Integer.valueOf(0));

        Labels loginTop = new Labels("Sign In");
        loginTop.setHorizontalAlignment(SwingConstants.CENTER);
        loginTop.setFont(new Font("Segue Script", Font.ITALIC, 40));
        loginTop.setBounds(570, 340, 400, 60);
        this.MainPanel.add(loginTop, Integer.valueOf(1));
        this.MainPanel.add(login, Integer.valueOf(2));

        Labels UserName_label = new Labels("User ID");
        UserName_label.setBounds(2, 2, 120, 50);
        User_Name = new TextFields();
        User_Name.setBounds(52, 2, 200, 50);
        login.add(UserName_label);
        login.add(User_Name);

        Labels Password_label = new Labels("Password:");
        Password_label.setBounds(2, 54, 200, 50);
        Password = new PasswordFields();
        Password.setBounds(57, 54, 200, 50);
        login.add(Password_label);
        login.add(Password);

        ImageIcon backIcon = new ImageIcon("back.png");
        Back = new Button(backIcon.getImage());
        Back.addActionListener(this);
        LoginButton = new Button("Login");
        LoginButton.addActionListener(this);
        login.add(Back);
        login.add(LoginButton);

        this.MainFrame.setVisible(true);
    }

    TextFields NAME_INPUT;
    TextFields USER_ID_INPUT;
    PasswordFields PASSWORD_INPUT;
    PasswordFields CONFIRM_PASSWORD_INPUT;
    Button SignupButton;
    Button Menu_B1;
    Button Menu_B2;
    Button Menu_B3;
    Button Menu_B4;
    Button Menu_B5;

    public void signUp() {
        JLabel BackgroundImage = new JLabel();
        ImageIcon bg = new ImageIcon("bg_logo3.png");
        BackgroundImage.setIcon(bg);
        BackgroundImage.setSize(1024, 768);
        this.MainPanel.add(BackgroundImage, Integer.valueOf(0));

        Labels SignUp_Label = new Labels("Sign Up");
        SignUp_Label.setBounds(200, 150, 600, 100);
        SignUp_Label.setHorizontalAlignment(SwingConstants.CENTER);
        SignUp_Label.setFont(new Font("Segue Script", Font.ITALIC, 60));
        this.MainPanel.add(SignUp_Label, Integer.valueOf(2));

        JPanel subPanel = new JPanel();
        subPanel.setBackground(new Color(8, 1, 43));
        subPanel.setBounds(200, 250, 600, 260);
        subPanel.setOpaque(true);
        subPanel.setLayout(new GridLayout(5, 2, 3, 3));

        Labels NAME = new Labels("Name:");
        NAME_INPUT = new TextFields();
        subPanel.add(NAME);
        subPanel.add(NAME_INPUT);
        Labels USER_ID = new Labels("User ID:");
        USER_ID_INPUT = new TextFields();
        subPanel.add(USER_ID);
        subPanel.add(USER_ID_INPUT);
        Labels PASSWORD = new Labels("Password:");
        PASSWORD_INPUT = new PasswordFields();
        subPanel.add(PASSWORD);
        subPanel.add(PASSWORD_INPUT);
        Labels CONFIRM_PASSWORD = new Labels("Confirm Password:");
        CONFIRM_PASSWORD_INPUT = new PasswordFields();
        subPanel.add(CONFIRM_PASSWORD);
        subPanel.add(CONFIRM_PASSWORD_INPUT);

        ImageIcon backIcon = new ImageIcon("back.png");
        Back = new Button(backIcon.getImage());
        Back.setBounds(200, 550, 300, 60);
        Back.addActionListener(this);
        SignupButton = new Button("Sign Up");
        SignupButton.setBounds(500, 550, 300, 60);
        SignupButton.addActionListener(this);
        subPanel.add(Back);
        subPanel.add(SignupButton);
        this.MainPanel.add(subPanel, Integer.valueOf(1));
        this.MainPanel.moveToFront(subPanel);
        this.MainFrame.setVisible(true);
    }

    public void Menu() throws IOException {
        this.MainPanel.removeAll();
        Labels WallPaper = new Labels();
        WallPaper.setSize(1020, 768);
        ImageIcon wallpaper = new ImageIcon("bg_logo3.png");
        WallPaper.setIcon(wallpaper);
        MainPanel.add(WallPaper, Integer.valueOf(0));

        Labels Menu_Label = new Labels("I Chat");
        Menu_Label.setHorizontalAlignment(SwingConstants.CENTER);
        Menu_Label.setBounds(400, 140, 240, 100);
        Menu_Label.setFont(new Font("Sans Serif", Font.TYPE1_FONT, 60));

        Menu_B1 = new Button("Display Contacts");
        Menu_B2 = new Button("Add Contact");
        Menu_B3 = new Button("Remove Contact");
        Menu_B4 = new Button("Chats");
        Menu_B5 = new Button("Sign Out");

        Menu_B1.setFont(new Font("Segue Script", Font.ITALIC, 15));
        Menu_B2.setFont(new Font("Segue Script", Font.ITALIC, 15));
        Menu_B3.setFont(new Font("Segue Script", Font.ITALIC, 15));
        Menu_B4.setFont(new Font("Segue Script", Font.ITALIC, 15));
        Menu_B5.setFont(new Font("Segue Script", Font.ITALIC, 15));

        Menu_B1.setBounds(120, 300, 200, 60);
        Menu_B2.setBounds(420, 300, 200, 60);
        Menu_B3.setBounds(720, 300, 200, 60);
        Menu_B4.setBounds(120, 460, 200, 60);
        Menu_B5.setBounds(420, 460, 200, 60);

        Menu_B1.addActionListener(this);
        Menu_B2.addActionListener(this);
        Menu_B3.addActionListener(this);
        Menu_B4.addActionListener(this);
        Menu_B5.addActionListener(this);

        MainPanel.add(Menu_Label, Integer.valueOf(2));
        MainPanel.add(Menu_B1, Integer.valueOf(2));
        MainPanel.add(Menu_B2, Integer.valueOf(2));
        MainPanel.add(Menu_B3, Integer.valueOf(2));
        MainPanel.add(Menu_B4, Integer.valueOf(2));
        MainPanel.add(Menu_B5, Integer.valueOf(2));
        MainFrame.setVisible(true);
    }

    Button Return;
    ChatPanel MP0;
    ChatPanel MP1;
    ChatPanel MP2;
    ChatPanel MP3;

    public void Display_Window() {
        Contacts_Present = Main.User_Person.getAll_Contacts();

        this.MainPanel.removeAll();

        MP0 = new ChatPanel(0, 0, 350, 60, 8, 1, 43);
        MP1 = new ChatPanel(350, 0, 674, 60, 8, 1, 43);
        MP2 = new ChatPanel(0, 60, 350, 708, 8, 1, 43);
        MP3 = new ChatPanel(350, 60, 674, 708, 8, 1, 43);

        MP0.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        MP0.setLayout(new BorderLayout());
        MP1.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        MP2.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));
        MP3.setBorder(BorderFactory.createLineBorder(Color.yellow, 2));

        ImageIcon returnIcon = new ImageIcon("back.png");
        Return = new Button(returnIcon.getImage());
        Return.setSize(45, 20);
        Return.addActionListener(this);
        MP0.add(Return, BorderLayout.WEST);

        String UserName = Main.User_Person.name;
        int Port_no = Main.User_Person.port_number;
        String UN_PN = UserName + "  " + Port_no;
        Labels Name = new Labels(UN_PN);
        Name.setFont(new Font("Sans Serif", Font.PLAIN, 20));
        MP0.add(Name);

        Labels WallPaper = new Labels();
        WallPaper.setBounds(350, 60, 674, 708);
        ImageIcon wallpaper = new ImageIcon("wallpaper.png");
        WallPaper.setIcon(wallpaper);
        MP3.add(WallPaper);

        this.MainPanel.add(MP0, Integer.valueOf(2));
        this.MainPanel.add(MP1, Integer.valueOf(2));
        this.MainPanel.add(MP2, Integer.valueOf(1));
        this.MainPanel.add(MP3, Integer.valueOf(0));
        this.MainFrame.setVisible(true);
    }

    ArrayList<Contacts> Contacts_Present;//=Main.User_Person.getAll_Contacts();
    ArrayList<Labels> Chat_Label;//=new ArrayList<Labels>();

    public void Contacts_Window() {
        Display_Window();
        Chat_Label = new ArrayList<Labels>();
        int num_of_contacts = Contacts_Present.size();
        for (int i = 0; i < num_of_contacts; i++) {
            Chat_Label.add(new Labels());
            String name = Contacts_Present.get(i).getname();
            int portnum = Contacts_Present.get(i).getport();
            String temp = name + "  " + portnum;
            Chat_Label.get(i).setText(temp);
            MP2.add(Chat_Label.get(i));
        }
        if (num_of_contacts < 9) {
            MP2.setLayout(new GridLayout(num_of_contacts, 1));
        } else {
            MP2.setLayout(new GridLayout(8, 1));

        }
        MainFrame.setVisible(true);
    }

    ArrayList<Button> Chats = new ArrayList<Button>();
    Button go_back;
    Button go_forward;
    int check, num_of_contacts;

    public void ADD_CHATS() {
        Display_Window();
        num_of_contacts = Contacts_Present.size();
        for (int i = 0; i < num_of_contacts; i++) {
            String name = Contacts_Present.get(i).getname();
            int portnum = Contacts_Present.get(i).getport();
            String temp = name + "  " + portnum;
            Chats.add(new Button(temp));
            Chats.get(i).setFont(new Font("Segue Script", Font.ITALIC, 20));
            Chats.get(i).addActionListener(this);
            MP2.add(Chats.get(i));
            if (i == 6 && num_of_contacts > 6) {
                MP2.add(go_back);
                MP2.add(go_forward);
                break;
            }
        }
        ImageIcon returnIcon = new ImageIcon("back.png");
        go_back = new Button(returnIcon.getImage());
        go_back.setSize(45, 20);
        go_back.addActionListener(this);

        ImageIcon go_forward_Icon = new ImageIcon("go_forward.png");
        go_forward = new Button(go_forward_Icon.getImage());
        go_forward.setSize(45, 20);
        go_forward.addActionListener(this);
        check = 0;
        if (num_of_contacts < 7) {

            MP2.setLayout(new GridLayout(num_of_contacts, 1));

        } else {
            MP2.setLayout(new GridLayout(8, 1));
        }
        MainFrame.setVisible(true);
    }

    ArrayList<Button> deleteChats = new ArrayList<Button>();
    int check2;
    Button go_back2;
    Button go_forward2;

    Button Enter;
    TextFields display_chat_text;
    TextFields chat_text;
    Labels text_label;

    JPanel Chat_Panel;
    Box vertical = Box.createVerticalBox();
    private int con;

    public int getCon() {
        return this.con;
    }

    JTextArea chatArea;

    public void setMenu_B3(int con) {
        this.con = con;

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(360, 70, 610, 500);

        chat_text = new TextFields();
        chatArea.setBackground(new Color(8, 1, 43));
        chatArea.setFont(new Font("Segue Script", Font.PLAIN, 16));
        chatArea.setForeground(Color.YELLOW);
        chat_text.setBounds(360, 650, 610, 45);

        for (int i = 0; i < Main.User_Person.getAll_Contacts().get(con).getMessages().size(); i++) {
            String temp = ((Main.User_Person.getAll_Contacts().get(con).getMessages().get(i).getPort()) == Main.User_Person.getport()) ? ("YOU") : ("PERSON");
            String temp2 = ": " + Main.User_Person.getAll_Contacts().get(con).getMessages().get(i).getContent();
            chatArea.append(temp + temp2 + "\n");
            chatArea.setCaretPosition(chatArea.getDocument().getLength());
        }

        Enter = new Button("Enter");
        Enter.setBackground(Color.red);
        Enter.setOpaque(true);
        Enter.setBounds(990, 650, 30, 30);
        Enter.setSize(30, 30);

        Enter.addActionListener(this);

        MainPanel.add(chat_text, Integer.valueOf(3));
        MainPanel.add(Enter, Integer.valueOf(3));
        MainPanel.add(scrollPane, Integer.valueOf(3));

        chat_text.setVisible(true);
        Enter.setOpaque(true);

        MainPanel.repaint();
        MainPanel.revalidate();
        MainPanel.validate();
        MainFrame.setVisible(true);

    }

    TextFields AC_Username;
    TextFields AC_Portno;
    Button AC_Button;

    public void Add_Contact() {
        JPanel login = new JPanel();
        login.setBackground(new Color(8, 1, 43));
        login.setOpaque(true);
        login.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        login.setBounds(570, 400, 400, 170);
        login.setLayout(new GridLayout(3, 2, 3, 3));

        JLabel BackgroundImage = new JLabel();
        ImageIcon bg = new ImageIcon("bg_logo2.png");
        BackgroundImage.setIcon(bg);
        BackgroundImage.setSize(1024, 768);
        this.MainPanel.add(BackgroundImage, Integer.valueOf(0));

        Labels loginTop = new Labels("Add Contact");
        loginTop.setHorizontalAlignment(SwingConstants.CENTER);
        loginTop.setFont(new Font("Segue Script", Font.ITALIC, 40));
        loginTop.setBounds(570, 340, 400, 60);
        this.MainPanel.add(loginTop, Integer.valueOf(1));
        this.MainPanel.add(login, Integer.valueOf(2));

        Labels UserName_label = new Labels("User ID");
        UserName_label.setBounds(2, 2, 120, 50);
        AC_Username = new TextFields();
        AC_Username.setBounds(52, 2, 200, 50);
        login.add(UserName_label);
        login.add(AC_Username);

        Labels Portno_label = new Labels("Port No:");
        Portno_label.setBounds(2, 54, 200, 50);
        AC_Portno = new TextFields();
        AC_Portno.setBounds(57, 54, 200, 50);
        login.add(Portno_label);
        login.add(AC_Portno);

        ImageIcon backIcon = new ImageIcon("back.png");
        Return = new Button(backIcon.getImage());
        Return.addActionListener(this);
        AC_Button = new Button("Add");
        AC_Button.addActionListener(this);
        login.add(Return);
        login.add(AC_Button);

        this.MainFrame.setVisible(true);
    }

    TextFields DC_Username;
    TextFields DC_Portno;
    Button DC_Button;

    public void Delete_Contact() {
        JPanel login = new JPanel();
        login.setBackground(new Color(8, 1, 43));
        login.setOpaque(true);
        login.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        login.setBounds(570, 400, 400, 170);
        login.setLayout(new GridLayout(3, 2, 3, 3));

        JLabel BackgroundImage = new JLabel();
        ImageIcon bg = new ImageIcon("bg_logo2.png");
        BackgroundImage.setIcon(bg);
        BackgroundImage.setSize(1024, 768);
        this.MainPanel.add(BackgroundImage, Integer.valueOf(0));

        Labels loginTop = new Labels("Delete Contact");
        loginTop.setHorizontalAlignment(SwingConstants.CENTER);
        loginTop.setFont(new Font("Segue Script", Font.ITALIC, 40));
        loginTop.setBounds(570, 340, 400, 60);
        this.MainPanel.add(loginTop, Integer.valueOf(1));
        this.MainPanel.add(login, Integer.valueOf(2));

        Labels UserName_label = new Labels("Name");
        UserName_label.setBounds(2, 2, 120, 50);
        DC_Username = new TextFields();
        DC_Username.setBounds(52, 2, 200, 50);
        login.add(UserName_label);
        login.add(DC_Username);

        Labels Portno_label = new Labels("Port No:");
        Portno_label.setBounds(2, 54, 200, 50);
        DC_Portno = new TextFields();
        DC_Portno.setBounds(57, 54, 200, 50);
        login.add(Portno_label);
        login.add(DC_Portno);

        ImageIcon backIcon = new ImageIcon("back.png");
        Return = new Button(backIcon.getImage());
        Return.addActionListener(this);
        DC_Button = new Button("Delete");
        DC_Button.addActionListener(this);
        login.add(Return);
        login.add(DC_Button);

        this.MainFrame.setVisible(true);
    }

    public void actionPerformed(ActionEvent a) {
        if (a.getSource() == SignInButton) {
            MainPanel.removeAll();
            signIn();
        }
        if (a.getSource() == SignUpButton) {
            MainPanel.removeAll();
            signUp();

        }
        if (a.getSource() == LoginButton) {
            String name = User_Name.getText();
            String pass = Password.getText();
            if (name.isEmpty() || pass.isEmpty()) {

                if (name.isEmpty() && pass.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "No Credentials");
                } else {
                    JOptionPane.showMessageDialog(null, (name.isEmpty()) ? "Username Empty" : "Password Incorrect");
                }
            } else {
                UserAuthentiation temp = new UserAuthentiation();
                try {
                    if (temp.authenticate(name, pass)) {
                        Main.setUser_Person(temp.Successful());
                        Main.setPort(Main.User_Person.getport());
                        Main.User_Person.loadAllContacts();
                        Main.thread = new Thread(Main.User_Person);
                        Main.thread.start();
                        this.Menu();
                    } else {
                        JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (a.getSource() == Back) {
            this.LoginScreen();
        }
        if (a.getSource() == SignupButton) {
            String name = NAME_INPUT.getText();
            String Pass1 = PASSWORD_INPUT.getText();
            String Pass2 = CONFIRM_PASSWORD_INPUT.getText();
            String ID = USER_ID_INPUT.getText();
            ;
            if (name.isEmpty() || Pass1.isEmpty() || ID.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter all fields");
            } else {
                if (!(Pass1.equals(Pass2))) {
                    JOptionPane.showMessageDialog(null, "Password do not match");
                } else {
                    UserAuthentiation check_User = new UserAuthentiation();
                    try {
                        if (!(check_User.ifUserAvailable(ID))) {
                            JOptionPane.showMessageDialog(null, "User ID is not available!\nEnter another User ID");
                        } else {
                            check_User.newUser(ID, Pass1, name);
                            Main.setUser_Person(check_User.Successful());
                            Main.setPort(Main.User_Person.getport());
                            Main.User_Person.startServer();
                            Main.thread = new Thread(Main.User_Person);
                            Main.thread.start();
                            JOptionPane.showMessageDialog(null, "Your Port Number is: " + Integer.toString(Main.getPort()));
                            this.Menu();
                        }
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        if (a.getSource() == Menu_B1) {
            Contacts_Window();
        }
        if (a.getSource() == Menu_B2) {
            MainPanel.removeAll();
            Add_Contact();
        }
        if (a.getSource() == AC_Button) {
            String name = AC_Username.getText();
            String prt = AC_Portno.getText();
            if (name.isEmpty() || prt.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please fil all the required fields");
            } else {
                int port = Integer.parseInt(prt);
                if (Main.User_Person.authenticatenewcontacts(name, port)) {
                    JOptionPane.showMessageDialog(null, "User Name or port already present");
                } else {
                    try {
                        Main.User_Person.add_New_Contact(name, port);
                        JOptionPane.showMessageDialog(null, "Contact added");
                        Menu();

                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }


        }
        if (a.getSource() == Menu_B3) {
            MainPanel.removeAll();
            Delete_Contact();
        }
        if (a.getSource() == DC_Button) {
            String prt = DC_Portno.getText();
            int port = Integer.parseInt(prt);

            if (Main.User_Person.authenticateport(port)) {
                Main.User_Person.deleteContact(port);
                try {
                    Menu();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No such port number exists");
            }
        }
        if (a.getSource() == Menu_B4) {
            ADD_CHATS();
        }
        if (a.getSource() == Menu_B5) {
            MainPanel.removeAll();
            Main.thread.interrupt();
            Main.User_Person.stopServer();
            LoginScreen();
        }
        if (a.getSource() == Return) {
            try {
                Menu();
            } catch (IOException e) {
            }
        }
        if (a.getSource() == go_back) {
            if (check == 0) {
                return;
            }
            check--;
            for (int i = 6 * check; i > 0; i++) {
                String name = Contacts_Present.get(i).getname();
                int portnum = Contacts_Present.get(i).getport();
                String temp = name + "  " + portnum;
                Chats.add(new Button(temp));
                Chats.get(i).addActionListener(this);
                MP2.add(Chats.get(i));
                if ((i == 6 * check - 6) && ((6 * check) > 0)) {
                    MP2.add(go_back);
                    MP2.add(go_forward);
                    break;
                }
            }
        }
        if (a.getSource() == go_forward) {
            if ((num_of_contacts > 6) && (check == 0)) {
                return;
            }
            check++;
            for (int i = 6 * check; i < num_of_contacts; i++) {
                String name = Contacts_Present.get(i).getname();
                int portnum = Contacts_Present.get(i).getport();
                String temp = name + "  " + portnum;
                Chats.add(new Button(temp));
                Chats.get(i).addActionListener(this);
                MP2.add(Chats.get(i));
                if ((i == 6 * check + 6) && (num_of_contacts > 6 * check + 6)) {
                    MP2.add(go_back);
                    MP2.add(go_forward);
                    break;
                }
            }

        }
        if (a.getSource() == Enter) {
            String Text = chat_text.getText();
            chat_text.setText("");
            if (!Text.equals("")) {
                chatArea.append("YOU : " + Text + "\n");
                try {
                    Sender sender = Main.User_Person;
                    sender.sendmsg(new Message(Main.User_Person.getAll_Contacts().get(con).getport(), Text));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            }
        }
        if (a.getSource() == Chats.get(0)) {
            setMenu_B3(0);
        }
        if (a.getSource() == Chats.get(1)) {
            setMenu_B3(1);
        }
        if (a.getSource() == Chats.get(2)) {
            setMenu_B3(2);
        }
        if (a.getSource() == Chats.get(3)) {
            setMenu_B3(3);
        }
        if (a.getSource() == Chats.get(4)) {
            setMenu_B3(4);
        }
        if (a.getSource() == Chats.get(5)) {
            setMenu_B3(5);
        }
    }
}