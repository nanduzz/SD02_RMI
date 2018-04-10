
import java.net.MalformedURLException;
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
 * @author guest-vuu80z
 */
public class LeitorEmail extends ClienteEmail {

    public static void main(String[] args) {
        try {
            LeitorEmail leitor = new LeitorEmail();
            if (leitor.realizaLogin()) {
                leitor.leMultiplesEmails();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public LeitorEmail() throws RemoteException, MalformedURLException, NotBoundException {
        super();
    }

    public void leMultiplesEmails() throws RemoteException {
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("1- Ler email | 0 Sair");
            if (s.nextLine().trim().equals("0")) {
                return;
            }
            Email email = frontEmail.leEmail(this.getLogin());
            email.leEmail();
        }

    }

}
    