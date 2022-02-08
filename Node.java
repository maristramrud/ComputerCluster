// Klassen Node

public class Node{

  private int antPros; // antall prosessorer
  private int minne; // stoerrelse på minne

// konstruktør
  public Node(int antPros, int minne){
    this.antPros = antPros;
    this.minne = minne;
  }

  //metode for antall prosessorer
  public int antProsessorer(){
    return this.antPros;
  }

  //metode som returnerer størrelse på minne til hver prosessor
  public int antMinne(){
    return this.minne;
  }

  // metode som sjekker om noden har nok minne
  public boolean nokMinne(int paakrevdMinne) {
    if (this.minne >= paakrevdMinne) {
      return true;
    }
    else {
      return false;
    }
  }
}
