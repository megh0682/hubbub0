
package edu.acc.j2ee.hubbub0;

import java.util.Date;


 
public class User implements java.io.Serializable{
    private String userName;
    private Date joinDate;
    
    public User(String userName, Date joinDate){
        this.userName=userName;
        this.joinDate=joinDate;
    }
            

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
    
    @Override
    public String toString(){
        return userName;
    }
    
    
    
}
