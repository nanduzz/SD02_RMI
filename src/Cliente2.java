
import java.rmi.Naming;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest-vuu80z
 */
public class Cliente2 {

    public static void main(String[] args) {
        try {
            FrontEndEmail fronEmail = (FrontEndEmail) Naming.lookup("//127.0.0.1:1099/FrontEndEmail");
            Email email = fronEmail.leEmail("fernando_eac@hotmail.com");
            
            email.leEmail();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
