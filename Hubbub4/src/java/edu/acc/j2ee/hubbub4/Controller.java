package edu.acc.j2ee.hubbub4;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
        HttpSession session = request.getSession(); 
        LoginBean user = (LoginBean)session.getAttribute("loginBean");   
        String destination = "timeline.jsp";
        if(user == null)
        {
            destination="timeline.jsp";
        }
        else if(request.getParameter("logout")!=null)
        {
            session.removeAttribute("loginBean");
            session.invalidate();
            destination="timeline.jsp";
        }
        else if(request.getParameter("login")!=null)
        {
            destination = "login.jsp";
        }
        RequestDispatcher rd = request.getRequestDispatcher(destination);
        rd.forward(request, response);
              
    }
    
    public void doPost (HttpServletRequest request, HttpServletResponse response)
         throws ServletException,IOException{
    
     String username =request.getParameter("user");
     String pwd= request.getParameter("pass");  
     String newPost=request.getParameter("postArea");
     LoginBean user =new LoginBean(username,pwd);   
     ServletContext sc = getServletContext();
     //HubbubDAO daoConn = (HubbubDAO)getServletContext().getAttribute("db");
     UserValidator uv = new UserValidator();
     String destination = "login.jsp";
     HttpSession session = request.getSession();
     if(session.getAttribute("loginBean")==null){      
        if(session!= null)
           { 
            if(!(UserValidator.isValid(user)))	
             {
             String flash = "One or more fields are invalid in username and password";
             request.setAttribute("flash", flash);
             }
          else
              {        
                UserAuthenticator ua = new UserAuthenticator(sc);  
                        if(!(ua.isAuthentic(user)))
                          {
                      String flash = "Access denied";
                      request.setAttribute("flash", flash);
                          }
                        else
                          {
                      session.setAttribute("loginBean",user);
                      HubbubDAO db = (HubbubDAO)getServletContext().getAttribute("db");
                      List<Post> posts = db.getSortedPosts();
                      request.setAttribute("posts", posts);
                      destination = "timeline.jsp";
                          }
                 }

            }
     }
     else
     {
        HubbubDAO db = (HubbubDAO)getServletContext().getAttribute("db");
        LoginBean uUser = (LoginBean) session.getAttribute("loginBean");
        User uname = db.find(uUser.getUsername());
        String upost = request.getParameter("postArea");
        upost =  uv.findReplaceInvalidChar(upost);
        Post postObj = new Post(upost,new Date(), uname);
        db.addPost(postObj);
        List<Post> posts = db.getSortedPosts();
        request.setAttribute("posts", posts);
        destination = "timeline.jsp";
    }
     RequestDispatcher rd=request.getRequestDispatcher(destination);
     rd.forward(request,response);
 }
}
