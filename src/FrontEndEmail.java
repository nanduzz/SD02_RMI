/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando
 */
public interface FrontEndEmail extends java.rmi.Remote {

    public boolean realizaLogin(String login, String senha) throws java.rmi.RemoteException;

    public boolean enviaEmail(String destino, String conteudo) throws java.rmi.RemoteException;

    public Email leEmail(String login) throws java.rmi.RemoteException;

}
