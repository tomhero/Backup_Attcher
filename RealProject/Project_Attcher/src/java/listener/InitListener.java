
package listener;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.sql.DataSource;

/**
 * Web application lifecycle listener.
 *
 * @author goku-
 */
public class InitListener implements ServletContextListener {

    private Connection conn;
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        
        try {
            conn = getIt_15().getConnection();
            ServletContext context = sce.getServletContext();
            context.setAttribute("databaseConnection", conn);
        } catch (NamingException | SQLException ex) {
            Logger.getLogger(InitListener.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(InitListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private DataSource getIt_15() throws NamingException {
        Context c = new InitialContext();
        return (DataSource) c.lookup("java:comp/env/it_15");
    }
}
