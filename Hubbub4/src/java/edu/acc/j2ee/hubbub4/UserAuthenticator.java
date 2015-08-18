package edu.acc.j2ee.hubbub4;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class UserAuthenticator{ 
	
  //ServletContext sc;
  ServletContext sc;
  private User uname;
	
   public UserAuthenticator(ServletContext sc)     
          {
          	  this.sc = sc;
          }
        
   public boolean isAuthentic(LoginBean user){
       
 HubbubDAO daoConn = (HubbubDAO)sc.getAttribute("db");
       
    uname = daoConn.find(user.getUsername());
    
    if(uname != null){
          if(uname.getPassWord().equals(user.getPassword())){
              return true;
          }
          else 
              return false;
        }
      return false;
    }

 }