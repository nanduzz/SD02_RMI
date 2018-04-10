
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

    public Misto() {

        try {
            ServidorEmail disparador = (ServidorEmail) Naming.lookup("//127.0.0.1:1099/ServidorEmail");;;
            FrontEmailImpl frontEnd = new FrontEmailImpl(disparador);
            Naming.rebind("//127.0.0.1:1099/FrontEndEmail", disparador);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        Misto m = new Misto();
    }

}
