  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import sanjeevani.dbutil.DBConnection;
import sanjeevani.pojo.PatientPojo;

/**
 *
 * @author Genius
 */
public class PatientDao {
    
    
    public static boolean addPatient(PatientPojo p)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into patient values(?,?,?,?,?,?,?,?,?,?,?,?)");
        ps.setString(1, p.getP_id());
        ps.setString(2, p.getF_name());
        ps.setString(3, p.getS_name());
        ps.setInt(4, p.getAge());
        ps.setString(5,p.getOpd());
        ps.setString(6, p.getGender());
        ps.setString(7, p.getM_status());
        ps.setDate(8, p.getDate());
        ps.setString(9, p.getAddress());
        ps.setString(10,p.getCity());
        ps.setString(11, p.getMno());
        ps.setString(12, p.getDocter_id());
       return (ps.executeUpdate()!=0);

    }
    
    
    public static String getNewId() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
       Statement st=conn.createStatement();
      ResultSet rs=st.executeQuery("Select max(p_id) from patient");
       int id=1;
       //System.out.println(rs.next());
       if(rs.next())
       {
           String empid=rs.getString(1);
          
          System.out.println(empid.substring(1));
           int eno=Integer.parseInt(empid.substring(1));
           id=id+eno;
           String sr="P"+id;
           return sr;
       }
       else
           return "P101";
    }
    
    
    
    public static ArrayList<PatientPojo> getAllPatient()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select*from patient");
        ArrayList <PatientPojo> empList=new ArrayList<>();
        while(rs.next())
        {
            PatientPojo e=new PatientPojo();
            
            e.setP_id(rs.getString(1) );
            e.setF_name(rs.getString(2));
            e.setS_name(rs.getString(3));
            e.setAge(rs.getInt(4));
            e.setOpd(rs.getString(5));
            e.setGender(rs.getString(6));
            e.setDate(rs.getDate(8));
            e.setDocter_id(rs.getString(12));
            e.setCity(rs.getString(10));
            e.setMno(rs.getString(11));
            e.setAddress(rs.getString(9));
           
            empList.add(e);
        }
        return empList;
    }
    
    
     public static HashMap<String,String> getRegisterPatient()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        String qry="select * from patient";
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> employee=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            
            employee.put(id, name);
            
            
        }
        return employee;
    }
    
     
     public static boolean deletePatient(PatientPojo e)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from patient where p_id=?");
        
       ps.setString(1,e.getP_id());
       int x=ps.executeUpdate();
       return x==1;

        
    }
     
     public static ArrayList<String> getAllPatientId() throws SQLException 
    {
      ArrayList<String> pId=new ArrayList<>();
      Statement st=DBConnection.getConnection().createStatement();
      ResultSet rs=st.executeQuery("select p_id from patient");
      while(rs.next())
      {
          pId.add(rs.getString(1));
      }
      return pId;
    }
     
     
     
     public static boolean updatePatient(PatientPojo p)throws SQLException
    {
        
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update patient set f_name=?,s_name=?,age=?,opd=?,address=?,phone_no=?,city=?,p_date=?,docter_id=? where p_id=?");
        ps.setString(1, p.getF_name());
        ps.setString(2, p.getS_name());
        ps.setInt(3, p.getAge());
        ps.setString(4, p.getOpd());
        //ps.setString(5, p.getGender());
        //ps.setString(6, p.getM_status());
        ps.setString(5, p.getAddress());
        ps.setString(6, p.getMno());
        ps.setString(7, p.getCity());
        ps.setDate(8, p.getDate());
        //ps.setString(7, p.getMno());
        ps.setString(9, p.getDocter_id());
        ps.setString(10, p.getP_id());
        int response=ps.executeUpdate();
        return response==1;  
    }
    
}
