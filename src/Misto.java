
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
public class Misto {

    public static void main(String[] args) {
        try {
            ServidorEmail disparador = (ServidorEmail) Naming.lookup("//127.0.0.1:1099/ServidorEmail");
            Email email = new Email("fernando_eac@hotmail.com", "oi", "smtp.fernando.com", 587);
            
            boolean disparado = disparador.disparaEmail(email);
            
            if(disparado){
                System.out.println("Email disparado com sucesso");
            }else{
                System.out.println("Erro ao disparar o email");
            }
            
            
        } catch (Exception e) {
            System.out.println(e);
        }

    }

}
