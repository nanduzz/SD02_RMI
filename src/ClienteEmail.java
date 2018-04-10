
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author fernando
 */
public abstract class ClienteEmail {

    private String login;
    private String senha;

    static FrontEndEmail frontEmail;

    public ClienteEmail() throws RemoteException, MalformedURLException, NotBoundException {
        frontEmail = (FrontEndEmail) Naming.lookup("//127.0.0.1:1099/FrontEndEmail");

    }

    public boolean realizaLogin() throws RemoteException {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("Digite 0 no login para sair:");
            System.out.println("Login:");
            this.login = s.nextLine().trim();
            if (login.equals("0")) {
                break;
            }
            System.out.println("Senha:");
            this.senha = s.nextLine().trim();

            if (frontEmail.realizaLogin(this.login, this.senha)) {
                return true;
            }
            System.out.println("============== LOGIN ERRADO ==============");
        }
        return false;
    }

    public String getLogin() {
        return login;
    }
    
    

}
