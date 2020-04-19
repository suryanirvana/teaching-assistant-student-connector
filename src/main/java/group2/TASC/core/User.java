package group2.TASC.core;

import java.util.HashMap;

public interface User {
    String userName = "";
    String name = "";
    String passWord = "";
    HashMap<String, Student> studentHashMap = new HashMap<>();
    HashMap<String, TeachingAssistant> TAHashMap = new HashMap<>();

    String getUserName();
    String getPassWord();
    String getName();
    void setName(String name);
    void setUserName(String userName);
    void setPassWord(String passWord);
}
