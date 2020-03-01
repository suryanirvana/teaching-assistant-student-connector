package group2.TASC.core;

public interface User {
    String userName = "";
    String name = "";
    String passWord = "";

    String getUserName();
    String getPassWord();
    String getName();
    void setName(String name);
    void setUserName(String userName);
    void setPassWord(String passWord);
}
