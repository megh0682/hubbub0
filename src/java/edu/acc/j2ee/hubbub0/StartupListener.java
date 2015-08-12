
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
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }
}
