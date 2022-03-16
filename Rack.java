// Klassen Rack

import java.util.ArrayList;

public class Rack{

  // Array som refererer til node-objekter
  // Tomt array uten noder
  private Node[] noder;
  int maksAntNoder = 12;
  int antNoder;
  boolean fulltRack = false;

  public Rack(int maksAntNoder) {
    this.maksAntNoder = maksAntNoder;
    this.noder = new Node[maksAntNoder];
  }

  public int getAntNoder() {
    return antNoder;
  }

  // ny node legges til i racket og antall noder i et rack økes
  // sjekker også om det er ledig plass i racket
  public void settInn(Node nyNode) {
    this.antNoder++;
    this.noder[antNoder - 1] = nyNode;
    oppdaterRack(); // racket er fullt, oppdaterer
  }

  // Deloppgave C - utvider klassen Rack med
  // metoden antProsessorer og noderMedNokMinne
  public int antProsessorer() {

    int antPros = 0;

    for (int i = 0; i < antNoder; i++){
      antPros += this.noder[i].antProsessorer();
    }
    return antPros;
  }

  // sjekker hvor mye minne nodene har
  public int noderMedNokMinne(int paakrevdMinne) {
    int antNoderMedNokMinne = 0;

    for (int i = 0; i < antNoder; i ++){
      if (this.noder[i].nokMinne(paakrevdMinne)){
        antNoderMedNokMinne++;
      }
    }

    return antNoderMedNokMinne;
  }

// oppdaterer "fulltRack" til true dersom det er fullt
  public void oppdaterRack(){
    if (this.antNoder >= this.maksAntNoder){
      this.fulltRack = true;
    }
  }

// metodesom forteller om racket er fullt
  public boolean Fullt() {
    return this.fulltRack;
  }
}
