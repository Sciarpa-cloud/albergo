package it.prodigi.fsdp2.albergo;

class Stanza {
    private int numeroStanza;
    private boolean occupata;


    public Stanza(int numeroStanza) {
        this.numeroStanza = numeroStanza;
        this.occupata = false;
    }


    public int getNumeroStanza() {
        return numeroStanza;
    }


    public void occupa() {
        this.occupata = true;
    }


    public void libera() {
        this.occupata = false;
    }


    public boolean occupazione() {
        return occupata;
    }
}


class StanzaSingola extends Stanza {
    private boolean bagnoPrivato;

    public StanzaSingola(int numeroStanza, boolean bagnoPrivato) {
        super(numeroStanza);
        this.bagnoPrivato = bagnoPrivato;
    }


    public boolean BagnoPrivato() {
        return bagnoPrivato;
    }
}


class StanzaDoppia extends Stanza {
    private boolean lettoExtra;


    public StanzaDoppia(int numeroStanza, boolean lettoExtra) {
        super(numeroStanza);
        this.lettoExtra = lettoExtra;
    }


    public boolean LettoExtra() {
        return lettoExtra;
    }
}