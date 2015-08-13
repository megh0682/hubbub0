
package edu.acc.j2ee.hubbub0;

import java.util.ArrayList;
import java.util.Date;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class StartupListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
       ArrayList<User> users = new ArrayList<>();
       User jd = new User("johndoe", new Date(113, 4, 9));
       User jj = new User("jilljack", new Date(113, 9, 31));
       users.add(jd);
       users.add(jj);
       sce.getServletContext().setAttribute("users", users);
       
       ArrayList<Post> posts = new ArrayList<>();
       Post post1 = new Post("My wonky Twonky server conked out.", new Date(113,5,23),jd.getUserName());
       Post post2 = new Post("I see good reason not to configure Twonky.", new Date(114, 9, 13),jj.getUserName());
       Post post3 = new Post("I'm a white-hat hacking my wonky Twonky server.", new Date(113, 4, 9),jd.getUserName());
       posts.add(post1);
       posts.add(post2);
       posts.add(post3);
       sce.getServletContext().setAttribute("posts", posts);
       
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
