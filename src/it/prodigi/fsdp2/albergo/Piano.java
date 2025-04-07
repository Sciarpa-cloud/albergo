package it.prodigi.fsdp2.albergo;

public class Piano {
    private int numeroPiano;
    private Stanza[] stanze;

    public Piano(int numeroPiano, int nStanze) {
        this.numeroPiano = numeroPiano;
        this.stanze = new Stanza[nStanze];
        for (int i = 0; i < nStanze; i++) {
            if (i % 2 == 0) {
                stanze[i] = new StanzaSingola(i + 1, true);
            } else {
                stanze[i] = new StanzaDoppia(i + 1, false);
            }
        }
    }

    public Stanza[] getStanze() {
        return stanze;
    }

    public int getNumeroPiano() {
        return numeroPiano;
    }

    public boolean occupaStanza(int numeroStanza) {
        if (numeroStanza > 0 && numeroStanza <= stanze.length) {
            if (stanze[numeroStanza - 1].occupazione() == false) {
                stanze[numeroStanza - 1].occupa();
                return true;
            }
        }
        return false;
    }

    public boolean liberaStanza(int numeroStanza) {
        if (numeroStanza > 0 && numeroStanza <= stanze.length) {
            if (stanze[numeroStanza - 1].occupazione() == true) {
                stanze[numeroStanza - 1].libera();
                return true;
            }
        }
        return false;
    }
}
