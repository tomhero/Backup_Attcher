/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import javax.mail.*;
//import javax.mail.internet.*;

/**
 *
 * @author goku-_000
 */
public class MailAuth extends Authenticator{
    
    @Override
    public PasswordAuthentication getPasswordAuthentication(){
        String username = "it.kmitl.system";
        String password = "it.kmitl.system2016";
        System.out.println("Authenticating...");
        return new PasswordAuthentication(username, password);
    }
    
}
