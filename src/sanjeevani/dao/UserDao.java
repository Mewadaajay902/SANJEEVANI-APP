 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.User;

/**
 *
 * @author Genius
 */
public class UserDao {
    
    
    
    public static String validateUser(User user)throws SQLException
    {
        System.out.println(user);
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select username from users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserId());
        ps.setString(2,user.getPassword());
        ps.setString(3,user.getUserType());
        
        ResultSet rs=ps.executeQuery();
        String username=null;
        if(rs.next())
        {
            username=rs.getString(1);
        }
        return username;

    }
    
    public static boolean changePassword(String userid,String pwd)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update users set password=? where userid=?");
        ps.setString(1, pwd);
        ps.setString(2, userid);
        return (ps.executeUpdate()!=0);
    }
    public static HashMap<String,String> getReceptionistList()throws SQLException
    {
        HashMap<String,String> receptionistList=new HashMap<>();
     Statement st=DBConnection.getConnection().createStatement();
     String qry="select userid,username from users where usertype='RECIEPTIONIST'";
     ResultSet rs=st.executeQuery(qry);
     while(rs.next())
     {
         receptionistList.put(rs.getString(1),rs.getString(2));
     }
     return receptionistList;
     
    }
    
    
    
}
