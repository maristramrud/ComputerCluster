// klassen Dataklynge

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Dataklynge{

  // Opprette en dataklynge som er tom
  // holde rede på en liste med racks
  private int antNoderPerRack = 12;
  private ArrayList<Rack> rack = new ArrayList<>();
  private String filnavn;
  private ArrayList<String> linjer = new ArrayList<>();

// Deloppgave A

  //public Dataklynge(int antNoderPerRack){
  //  this.antNoderPerRack = antNoderPerRack;
  //}

  public Dataklynge (String filnavn) {
    lesFraFil(filnavn);
  }

  public void lesFraFil(String filnavn) {
    File fil = new File(filnavn);
    Scanner lesFil = null;
    //int antNoderPerRack = 12;


    try{
      lesFil = new Scanner(fil);
    } catch(FileNotFoundException e){
        System.out.println("Filen ble ikke funnet." + e);
    }

    String linje = "";
    while(lesFil.hasNextLine()){
      linjer.add(lesFil.nextLine());
    }
    //int antNoderPerRack = 12;
    System.out.println("Antall noder per rack: " + antNoderPerRack);

    for (int i=0; i < linjer.size(); i++) {
      String[] linjeSplit = linjer.get(i).split("\\s+");
      int antNoder = Integer.parseInt(linjeSplit[0]);
      int antPros = Integer.parseInt(linjeSplit[1]);
      int minne = Integer.parseInt(linjeSplit[2]);
      for(int j=0; j < antNoder; j++){
        settInnNode(minne, antPros);
      }
    }
    return;

  }


// metode for å opprette et rack
  public void opprettRack() {
    this.rack.add(new Rack(this.antNoderPerRack));
  }

// metode for å sette inn node
  public int settInnNode( int minne, int antPros) {

    Node nyNode = new Node(antPros, minne);

    if (this.rack.size() == 0) {
      opprettRack();
    }
    else if (this.rack.get(this.rack.size() - 1).Fullt()) {
      opprettRack();
    }

    this.rack.get(this.rack.size() - 1).settInn(nyNode);

    return minne;
  }


  // Metode som tar i mot et node-objekt
  // og plasserer det i et rack med ledig plass
  // dersom racket er fullt, laget et nytt rack-objekt og noden plasseres der

  // metode antProsessorer som returnerer det totale antall prosessorer i dataklyngen
  public int antProsessorer() {
      int antPros = 0;

      for(int i = 0; i < this.rack.size(); i++) {
        antPros += this.rack.get(i).antProsessorer();
      }
      return antPros;
  }

  // henter antall noder som har nok nok minne
  // gaar over alle rackene i ArrayList
  // kaller på Rack-objektets noderMedNokMinne
  // paakrevdMinne er minnet som kreves av hver prosessor i klyngen

  public int noderMedNokMinne(int paakrevdMinne) {
    // Antall noder med nok minne i regneklyngen
    int antNoderMedNokMinne = 0;

    // Sjekker antall noder med nok minne i hvert rack med en loop
    for (int i = 0; i < this.rack.size(); i++) {
      Rack currentRack = this.rack.get(i);
      antNoderMedNokMinne += currentRack.noderMedNokMinne(paakrevdMinne);
    }
    // returnerer antallet noder med nok minne
    return antNoderMedNokMinne;
  }

  public int antRack() {
    return this.rack.size();
  }
}
