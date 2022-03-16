// Hovedprogram

public class HovedprogramTest{

  public static void main(String [] args){

    Dataklynge saga = new Dataklynge();

    System.out.println("Noder med minst 128 GB: " + saga.noderMedNokMinne(128));
    System.out.println("Noder med minst 512 GB: " + saga.noderMedNokMinne(512));
    System.out.println("Noder med minst 1024 GB: " + saga.noderMedNokMinne(1024));

    System.out.println("Antall prosessorer: " + saga.antProsessorer());
    System.out.println("Antall rack: " + saga.antRack());
  }
}
