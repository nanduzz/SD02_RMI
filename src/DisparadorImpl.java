
import java.rmi.RemoteException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest-vuu80z
 */
public class DisparadorImpl extends java.rmi.server.UnicastRemoteObject implements DisparadorEmail {

    public DisparadorImpl() throws RemoteException {
        super();
    }

    @Override
    public boolean disparaEmail(Email email) throws RemoteException {
        System.out.println("Disparando email" + email.toString());

        //Chance de não enviar o e-mail = 20%
        return Math.random() > 0.2;
    }

}
