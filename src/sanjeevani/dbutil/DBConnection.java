
package sanjeevani.dbutil;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection
{
    private static Connection conn;
    static 
    {
        try
        {
            Class.forName("oracle.jdbc.OracleDriver");
            conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-21CMEF8:1521/XE","sca","students");
            JOptionPane.showMessageDialog(null,"Connection done successfully");
        }
        catch(ClassNotFoundException cnfe)
        {
            JOptionPane.showMessageDialog(null,"Cannot load driver!"+cnfe);
            cnfe.printStackTrace();
        }
        catch(SQLException sqlex)
        {
            JOptionPane.showMessageDialog(null,"Problem in DB!"+sqlex);
            sqlex.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return conn;
    }
    public static void closeConnection()
    {
        
            try
            {
                if(conn!=null)
                {
                conn.close();
                JOptionPane.showMessageDialog(null,"Connection closed successfully!");
            }
            }
            catch(SQLException sqlex)
            {
                JOptionPane.showMessageDialog(null,"Problem in closing Connection!"+sqlex);
                sqlex.printStackTrace();
            }
            
        }
    
}
