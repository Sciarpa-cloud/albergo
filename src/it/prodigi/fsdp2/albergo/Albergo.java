package it.prodigi.fsdp2.albergo;

import java.util.Scanner;

public class Albergo {
    private Piano[] piani;

    public Albergo(int NumeroPiani, int NumeroStanzePerPiano) {
        piani = new Piano[NumeroPiani];
        for (int i = 0; i <  NumeroPiani; i++) {
            piani[i] = new Piano(i + 1, NumeroStanzePerPiano); //l'indice corrisponde al piano
        }
    }

    public boolean occupaStanza(int numeroPiano, int numeroStanza) {
        if (numeroPiano > 0 && numeroPiano <= piani.length) {
            return piani[numeroPiano - 1].occupaStanza(numeroStanza); //-1 perchè parte da 0!!
        }
        return false;
    }


    public boolean liberaStanza(int numeroPiano, int numeroStanza) {
        if (numeroPiano > 0 && numeroPiano <= piani.length) {
            return piani[numeroPiano - 1].liberaStanza(numeroStanza);
        }
        return false;
    }


    public void mostraStatoAlbergo() {
        for (int i = 0; i < piani.length; i++) {
            Piano piano = piani[i];
            System.out.println("Piano " + piano.getNumeroPiano() + ":");

            for (int j = 0; j < piano.getStanze().length; j++) {
                Stanza stanza = piano.getStanze()[j];
                String tipoStanza = "Singola";
                if (stanza instanceof StanzaDoppia) {
                    tipoStanza = "Doppia";
                }

                System.out.println("  Stanza " + stanza.getNumeroStanza() + " - " +
                        tipoStanza + " - " +
                        (stanza.occupazione() ? "Occupata" : "Libera"));
            }
        }
    }

    public static void main(String[] args) {
        boolean operazione = true;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero di piani dell'albergo: ");
        int numeroPiani = scanner.nextInt();
        System.out.print("Inserisci il numero di stanze per piano: ");
        int numeroStanzePerPiano = scanner.nextInt();


        Albergo albergo = new Albergo(numeroPiani, numeroStanzePerPiano);


        while (operazione == true) {
            System.out.println("Che operazione vuoi eseguire?");
            System.out.println("1 Mostra stato dell'albergo");
            System.out.println("2 Occupa una stanza");
            System.out.println("3 Libera una stanza");
            System.out.println("4 Esci");
            int scelta = scanner.nextInt();

            if (scelta == 1) {
                albergo.mostraStatoAlbergo();
            } else if (scelta == 2) {
                System.out.print("Inserisci il numero del piano: ");
                int piano = scanner.nextInt();
                System.out.print("Inserisci il numero della stanza: ");
                int stanza = scanner.nextInt();
                if (albergo.occupaStanza(piano, stanza)) {
                    System.out.println("Stanza occupata con successo!");
                } else {
                    System.out.println("Non è stato possibile occupare la stanza.");
                }
            } else if (scelta == 3) {
                System.out.print("Inserisci il numero del piano: ");
                int piano = scanner.nextInt();
                System.out.print("Inserisci il numero della stanza: ");
                int stanza = scanner.nextInt();
                if (albergo.liberaStanza(piano, stanza)) {
                    System.out.println("Stanza liberata con successo!");
                } else {
                    System.out.println("Non è stato possibile liberare la stanza.");
                }
            } else if (scelta == 4) {
                System.out.println("Uscita dal programma.");
                break;
            } else {
                System.out.println("Scelta non valida.");
            }
        }
        scanner.close();
    }
}
