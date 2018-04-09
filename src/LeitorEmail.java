
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guest-vuu80z
 */
public class LeitorEmail {

    private static FrontEndEmail frontEmail;

    public static void main(String[] args) {
        try {
            frontEmail = (FrontEndEmail) Naming.lookup("//127.0.0.1:1099/FrontEndEmail");

            if (realizaLogin()) {
                Email email = frontEmail.leEmail("fernando_eac@hotmail.com");
                email.leEmail();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static boolean realizaLogin() throws RemoteException {
        while (true) {
            Scanner s = new Scanner(System.in);
            System.out.println("Digite 0 no login para sair:");
            System.out.println("Login:");
            String login = s.nextLine().trim();
            if (login.equals("0")) {
                break;
            }
            System.out.println("Senha:");
            String senha = s.nextLine().trim();

            if (frontEmail.realizaLogin(login, senha)) {
                return true;
            }
            System.out.println("============== LOGIN ERRADO ==============");
        }
        return false;
    }

}
