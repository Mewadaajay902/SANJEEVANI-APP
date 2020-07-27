/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sanjeevani.pojo;

import java.sql.Date;

/**
 *
 * @author Genius
 */
public class PatientPojo {

    public PatientPojo(String P_id, String F_name, String S_name, int age, String opd, Date date, String address, String city, String mno, String Docter_id) {
        this.P_id = P_id;
        this.F_name = F_name;
        this.S_name = S_name;
        this.age = age;
        this.opd = opd;
        this.date = date;
        this.address = address;
        this.city = city;
        this.mno = mno;
        this.Docter_id = Docter_id;
    }
    
    
    public PatientPojo()
    {
        
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    /*public java.util.Date getDate() {
        return date;
    }

    public void setDate(java.util.Date date) {
        this.date = date;
    }*/

    public PatientPojo(String P_id, String F_name, String S_name, int age, String opd, String gender, String M_status,Date date, String address, String city, String mno, String Docter_id) {
        this.P_id = P_id;
        this.F_name = F_name;
        this.S_name = S_name;
        this.age = age;
        this.opd = opd;
        this.gender = gender;
        this.M_status = M_status;
        this.date = date;
        this.address = address;
        this.city = city;
        this.mno = mno;
        this.Docter_id = Docter_id;
    }

    public String getP_id() {
        return P_id;
    }

    public void setP_id(String P_id) {
        this.P_id = P_id;
    }

    public String getF_name() {
        return F_name;
    }

    public void setF_name(String F_name) {
        this.F_name = F_name;
    }

    public String getS_name() {
        return S_name;
    }

    public void setS_name(String S_name) {
        this.S_name = S_name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getOpd() {
        return opd;
    }

    public void setOpd(String opd) {
        this.opd = opd;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getM_status() {
        return M_status;
    }

    public void setM_status(String M_status) {
        this.M_status = M_status;
    }

    /*public java.util.Date getDate() {
        return date;
    }

    /*public void setDate(java.util.Date date) {
        this.date = date;
    }*/

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMno() {
        return mno;
    }

    public void setMno(String mno) {
        this.mno = mno;
    }

    public String getDocter_id() {
        return Docter_id;
    }

    public void setDocter_id(String Docter_id) {
        this.Docter_id = Docter_id;
    }
    
    private String P_id;
    
    private String F_name;
    private String S_name;
    private int age;
    private String opd;
    
    private String gender;
    private String M_status;
    private Date date;
    private String address; 
    private String city;
    private String mno;
    private String Docter_id;
    

    
}
