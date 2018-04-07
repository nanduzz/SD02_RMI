
import java.io.Serializable;
import java.rmi.RemoteException;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fernando
 */
public class FrontEmailImpl extends java.rmi.server.UnicastRemoteObject implements FrontEndEmail, Serializable {

    private final ServidorEmail disparador;

    public FrontEmailImpl(ServidorEmail disparador) throws RemoteException {
        super();
        this.disparador = disparador;
    }

    @Override
    public boolean enviaEmail(String destino, String conteudo) throws RemoteException {
        Email email = new Email(destino, conteudo, "smtp.fernando.com", 587);
        boolean disparado = disparador.disparaEmail(email);
        return disparado;
    }

    @Override
    public Email leEmail(String login) throws RemoteException {
        return disparador.leEmail(login);
    }
}
