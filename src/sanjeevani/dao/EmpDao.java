
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
import sanjeevani.pojo.EmpPojo;

/**
 *
 * @author Genius
 */
public class EmpDao {
    
    
    public static String getNewId()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select max(Empid) from employees");
        int id=1;
        rs.next();
        
            String empid=rs.getString(1);
            int eno=Integer.parseInt(empid.substring(1));
            id=id+eno;
        
        String sr="E" +id;
        System.out.println(sr);
        return sr;
     
    }
    
    public static boolean addEmployee(EmpPojo e)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("insert into employees values(?,?,?,?)");
        
       ps.setString(1,e.getEmpid());
       ps.setString(2,e.getEmpname());
       ps.setString(3,e.getJob().toUpperCase());
       ps.setDouble(4,e.getSal());
       int x=ps.executeUpdate();
       return x==1;

        
    }
    
    public static ArrayList<EmpPojo> getAllEmp()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        ResultSet rs=st.executeQuery("select*from employees");
        ArrayList <EmpPojo> empList=new ArrayList<>();
        while(rs.next())
        {
            EmpPojo e=new EmpPojo();
            e.setEmpid(rs.getString(1));
            e.setEmpname(rs.getString(2));
            e.setJob(rs.getString(3));
            e.setSal(rs.getDouble(4));
            empList.add(e);
        }
        return empList;
    }
    /*public static EmpPojo findEmpById(int eno)throws SQLException
    {
        EmpPojo e=null;
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("select * from employees where empid=?");
        ps.setInt(1, eno);
        ResultSet rs=ps.executeQuery();
        if(rs.next())
        {
            e=new EmpPojo();
            e.setEmpid(rs.getString(1));
            e.setEmpname(rs.getString(2));
            e.setJob(rs.getString(2));
            e.setSal(rs.getDouble(3));
        }
        return e;
    }*/ 
    
    public static  HashMap<String,String> getNonRegisteredReceptionist()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        String qry="select empid,empname from employees where role='RECEPTIONIST' and empid not in (select empid from users where usertype='RECEPTIONIST')";
        
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> receptionist=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            receptionist.put(id,name);
        }
        return receptionist;
    }
    
    public static HashMap<String,EmpPojo> getRegisterEmployee()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        String qry="select * from employees";
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,EmpPojo> employee=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            String job=rs.getString(3);
            double sal=rs.getDouble(4);
            EmpPojo employe=new EmpPojo();
            employee.put(id,employe);
            //employee.put(id, employe)  
        }
        return employee;
    }
    public static HashMap<String,String> getRegisterEmploye()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        String qry="select * from employees";
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> employee=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            //String job=rs.getString(3);
            //double sal=rs.getDouble(4);
            //EmpPojo employe=new EmpPojo();
            //employee.put(employe.getEmpid(), employe);
            employee.put(id, name);
            //employee.put(id,sal);
            
        }
        return employee;
    }
    
    
    
    
    
    
    
    
    public static boolean updateEmployee(EmpPojo e)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("update employees set empname=?,role=?,sal=? where empid=?");
        
       ps.setString(4,e.getEmpid());
       ps.setString(1,e.getEmpname());
       ps.setString(2,e.getJob().toUpperCase());
       ps.setDouble(3,e.getSal());
       int x=ps.executeUpdate();
       return x==1;

        
    }
    
    public static boolean deleteEmployee(EmpPojo e)throws SQLException
    {
        PreparedStatement ps=DBConnection.getConnection().prepareStatement("delete from employees where empid=?");
        
       ps.setString(1,e.getEmpid());
       int x=ps.executeUpdate();
       return x==1;

        
    }
    
    
    
    public static  HashMap<String,String> getNonRegisteredDocter()throws SQLException
    {
        Statement st=DBConnection.getConnection().createStatement();
        String qry="select empid,empname from employees where role='DOCTER' and empid not in (select empid from users where usertype='DOCTER')";
        
        ResultSet rs=st.executeQuery(qry);
        
        HashMap<String,String> docter=new HashMap<>();
        while(rs.next())
        {
            String id=rs.getString(1);
            String name=rs.getString(2);
            docter.put(id,name);
        }
        return docter;
    }
}
