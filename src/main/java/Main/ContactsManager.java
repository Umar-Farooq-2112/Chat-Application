package Main;

import java.io.IOException;

public interface ContactsManager {
    void add_New_Contact(String Name, int port) throws IOException;
    void deleteContact(int port);
    boolean authenticatenewcontacts(String Name,int port);
    void loadAllContacts() throws IOException;

}
