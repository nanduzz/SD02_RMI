/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guest-vuu80z
 */
public interface DisparadorEmail extends java.rmi.Remote {
    
    public boolean disparaEmail(Email email) throws java.rmi.RemoteException;
    
    
}
