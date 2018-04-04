
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
public class Server {

    public Server() {
        try{
            DisparadorEmail disparador = new DisparadorImpl();
            Naming.rebind("//127.0.0.1:1099/ServidorEmail", disparador);
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    
    
    
    public static void main(String[] args) {
        Server s = new Server();
    }
           
}
