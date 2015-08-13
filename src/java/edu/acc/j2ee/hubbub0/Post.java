
package edu.acc.j2ee.hubbub0;

import java.util.Date;


 
public class Post implements java.io.Serializable{
    private String postDesc;
    private Date postedOn;
    private String userName;
    
    public Post(String postDesc, Date postedOn, String userName){
        this.postDesc=postDesc;
        this.postedOn=postedOn;
        this.userName=userName;
    }
            

    public String getPostDesc() {
        return postDesc;
    }

    public Date getPostedOn() {
        return postedOn;
    }
    
     public String getUserName() {
        return userName;
    }

    public void setPostDesc(String postDesc) {
        this.postDesc = postDesc;
    }

    public void setPostedOn(Date postedOn) {
        this.postedOn = postedOn;
    }
    
     public void setUserName(String userName) {
        this.userName = userName;
    }
    
    @Override
    public String toString(){
        return postDesc;
    }
    
    
    
}
