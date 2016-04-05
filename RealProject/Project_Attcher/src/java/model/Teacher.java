/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Teacher extends User{
    
    private String th_prename, th_name;
    private String en_prename, en_name;
    private String email;

    public Teacher(String th_prename, String th_name, String en_prename, String en_name, String email, String username, String password, String type) {
        super(username, password, type);
        this.th_prename = th_prename;
        this.th_name = th_name;
        this.en_prename = en_prename;
        this.en_name = en_name;
        this.email = email;
    }

    public Teacher(String th_prename, String th_name, String en_prename, String en_name, String email) {
        this.th_prename = th_prename;
        this.th_name = th_name;
        this.en_prename = en_prename;
        this.en_name = en_name;
        this.email = email;
    }
    
    public Teacher(){
    }

    public String getTh_prename() {
        return th_prename;
    }

    public void setTh_prename(String th_prename) {
        this.th_prename = th_prename;
    }

    public String getTh_name() {
        return th_name;
    }

    public void setTh_name(String th_name) {
        this.th_name = th_name;
    }

    public String getEn_prename() {
        return en_prename;
    }

    public void setEn_prename(String en_prename) {
        this.en_prename = en_prename;
    }

    public String getEn_name() {
        return en_name;
    }

    public void setEn_name(String en_name) {
        this.en_name = en_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    
}
