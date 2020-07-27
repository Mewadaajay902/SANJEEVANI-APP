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
import sanjeevani.pojo.DocterPojo;

/**
 *
 * @author Genius
 */
public class DocterDao {
    
    public static boolean addDocter(DocterPojo user)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into users values(?,?,?,?,?)");
        ps.setString(1,user.getUserid());
        ps.setString(2, user.getEmpname());
        ps.setString(3,user.getEmpid());
        ps.setString(4,user.getPassword());
        ps.setString(5, user.getUserType());
        int x=ps.executeUpdate();
        return x>0;
    }
    public static boolean addinDocter(DocterPojo userr)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into docters values(?,?,?,?,'Y')");
        ps.setString(1,userr.getUserid());
        //ps.setString(2, user.getEmpname());
        ps.setString(2,userr.getDocid());
        ps.setString(3,userr.getQualification());
        ps.setString(4, userr.getSpecialist());
        int x=ps.executeUpdate();
        return x>0;
    }
    
    
    
    
    public static ArrayList<DocterPojo> getAllDocter()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select*from docters where active='Y'");
        ArrayList <DocterPojo> empList=new ArrayList<>();
        while(rs.next())
        {
            DocterPojo e=new DocterPojo();
            
            e.setDocid(rs.getString(2));
            e.setUserid(rs.getString(1));
            e.setQualification(rs.getString(3));
            e.setSpecialist(rs.getString(4));  
           
            empList.add(e);
        }
        return empList;
    }
    
    
    public static ArrayList<String> getAllDoctersId()throws SQLException
    {
        ArrayList<String> docId=new ArrayList<>();
        ResultSet rs=DBConnection.getConnection().createStatement().executeQuery("select docterid from docters where active='Y'");
        while(rs.next())
        {
        docId.add(rs.getString(1));
        }
        return docId;
    }
    
    public static boolean deleteDocter(DocterPojo e)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update docters set active='N' where docterid=?");
        
       ps.setString(1,e.getDocid());
       int x=ps.executeUpdate();
       return x==1;

        
    }
    
    
    
    
    public static HashMap<String,String> getRegisterDocter()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        String qry="select * from docters where active='Y'";
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> employee=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(2);
            String qualification=rs.getString(3);
            
            employee.put(id, qualification);
            
            
        }
        return employee;
    }
    
}
