package edu.acc.j2ee.hubbub4;

public class LoginBean implements java.io.Serializable
{
   private String username ;
   private String password ;
   

   public LoginBean() 
   {
   }
   public LoginBean(String username,String password) 
   {
   	   this.username=username;
   	   this.password=password;
      
   }
   
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      
    @Override public String toString() 
    {
		return String.format("[user: %s]", username);
	}
}