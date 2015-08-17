package edu.acc.j2ee.hubbub4;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User implements java.io.Serializable {
    private String userName;
    private String passWord;
    private Date joinDate;
    private List<Post> posts = new ArrayList<>();
    
    public User(String userName, String passWord, Date joinDate) {
        this.userName = userName;
        this.passWord = passWord;
        this.joinDate = joinDate;
    }
    
    public User() {}

    public String getUserName() {
        return userName;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    
    public List<Post> getPosts() {
        return posts;
    }
    
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    
    @Override
    public String toString() {
        return userName;
    }

  
}
