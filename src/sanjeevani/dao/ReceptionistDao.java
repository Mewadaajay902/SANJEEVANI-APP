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
import java.util.ArrayList;
import java.util.HashMap;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.UserPojo;

/**
 *
 * @author Genius
 */
public class ReceptionistDao {
    
    
    public static boolean addReceptionist(UserPojo user)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(1,user.getUserid());
        ps.setString(2, user.getUserName());
        ps.setString(3,user.getEmpId());
        ps.setString(4,user.getPassword());
        ps.setString(5, user.getUserType());
        int x=ps.executeUpdate();
        return x>0;
    }
    
    
    public static ArrayList<UserPojo> getAllReceptionist()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select*from users where usertype='RECEPTIONIST'");
        ArrayList <UserPojo> empList=new ArrayList<>();
        while(rs.next())
        {
            UserPojo e=new UserPojo();
            e.setEmpId(rs.getString(3));
            e.setUserName(rs.getString(2));
            e.setUserid(rs.getString(1));  
           
            empList.add(e);
        }
        return empList;
    }
    
    public static boolean deleteReceptionist(UserPojo user)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from users where empid=?");
        ps.setString(1,user.getEmpId());
        
        int x=ps.executeUpdate();
        return x>0;
    }
    
    
    public static HashMap<String,String> getRegisterReceptionist()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        String qry="select empid,username from users where usertype='RECEPTIONIST'";
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> reception=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
           
            reception.put(id, name);
            
            
        }
        return reception;
    }
    
}
