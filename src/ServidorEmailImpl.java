
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest-vuu80z
 */
public class ServidorEmailImpl extends java.rmi.server.UnicastRemoteObject implements ServidorEmail {

    private HashMap<String, List<Email>> hashEmails = new HashMap<>();

    public ServidorEmailImpl() throws RemoteException {
        super();
        this.hashEmails = new HashMap<>();
    }

    @Override
    public boolean disparaEmail(Email email) throws RemoteException {
        System.out.println("Disparando email" + email.toString());

        //Chance de não enviar o e-mail = 20%
        boolean emailEnviado = emailEnviado();
        if (emailEnviado) {
            if (!this.hashEmails.containsKey(email.getEmail())) {
                this.adicionaNoHash(email.getEmail());
            }

            this.hashEmails.get(email.getEmail()).add(email);
        }
        return emailEnviado;
    }

    @Override
    public boolean realizaLogin(String login, String senha) throws RemoteException {
        return ((login.equals("cliente") && senha.equals("senhacliente")
                || login.equals("leitor") && senha.equals("senhaleitor")));
    }

    @Override
    public Email leEmail(String login) throws RemoteException {
        if (!this.hashEmails.containsKey(login) || this.hashEmails.get(login).isEmpty()) {
            return null;
        }

        return this.hashEmails.get(login).remove(0);
    }

    private void adicionaNoHash(String email) {
        this.hashEmails.put(email, new ArrayList<>());
    }

    private static boolean emailEnviado() {
        return Math.random() > 0.2;
    }

}
