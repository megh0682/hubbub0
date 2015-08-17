
package edu.acc.j2ee.hubbub4;

public class UserValidator{
  
    public void UserValidator(){
       }
    
       public static boolean isValid(LoginBean user){
       
       if(user.getPassword().length() > 5 && user.getPassword().length() <16) {
           if (!((user.getPassword().contains(">")) ||
                  (user.getPassword().contains("<")) || 
                   (user.getPassword().contains("'")) || 
                   (user.getPassword().contains("&")) || 
                   (user.getPassword().contains("\"")))){
            return true;
           } 
           else {
            return false;
            }
        }
       else
           return false;
       }
}