package edu.acc.j2ee.hubbub4;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Controller extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HubbubDAO db = (HubbubDAO)getServletContext().getAttribute("db");
        List<Post> posts = db.getSortedPosts();
        request.setAttribute("posts", posts);
        request.getRequestDispatcher("timeline.jsp").forward(request, response);
    }
    
    public void doPost (HttpServletRequest request, HttpServletResponse response)
         throws ServletException,IOException{
    
     String username =request.getParameter("user");
     String pwd= request.getParameter("pass");  
     LoginBean user =new LoginBean(username,pwd);   
     HttpSession session = request.getSession();
     HubbubDAO daoConn = new HubbubDAO();
     UserValidator uv = new UserValidator();
     String destination = "login.jsp";
        if(session!= null)
           { 
            if(!(UserValidator.isValid(user)))	
             {
             String flash = "One or more fields are invalid in username and password";
             request.setAttribute("flash", flash);
             }
          else
              {        
                UserAuthenticator ua = new UserAuthenticator(daoConn);  
                        if(!(ua.isAuthentic(user)))
                          {
                      String flash = "Access denied";
                      request.setAttribute("flash", flash);
                          }
                        else
                          {
                      session.setAttribute("loginBean",user);
                      destination = "timeline.jsp";
                          }
                 }

            }
     RequestDispatcher rd=request.getRequestDispatcher(destination);
     rd.forward(request,response);
 }
}
