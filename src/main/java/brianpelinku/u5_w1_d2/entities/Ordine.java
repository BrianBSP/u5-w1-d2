package brianpelinku.u5_w1_d2.entities;

import brianpelinku.u5_w1_d2.enums.StatoOrdinazione;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ordine {
    private int numeroOrdine;
    private List<Pizza> pizzeOrdinate;
    private List<Bevande> bevandeOrdinate;
    private int numCopertiOrdine;
    private Tavolo numTavolo;
    private LocalTime oraOrdinazione;
    private StatoOrdinazione statoOrdinazione;
    private double costoCoperto;
    private double totImportoOrdine;

    public Ordine(int numCopertiOrdine, Tavolo numTavolo){
        Random random = new Random();
        if (numTavolo.getMaxCoperti()<=numCopertiOrdine) throw new RuntimeException("Numero coperti eccessivo.");
        this.numeroOrdine = random.nextInt(1000,10000);
        this.statoOrdinazione = StatoOrdinazione.IN_CORSO;
        this.numCopertiOrdine= numCopertiOrdine;
        this.oraOrdinazione =LocalTime.now();
        this.pizzeOrdinate = new ArrayList<>();
        this.bevandeOrdinate = new ArrayList<>();
    }

    public void aggiungiPizza(Pizza pizza){
        this.pizzeOrdinate.add(pizza);
    }

    public void aggiungiBevanda(Bevande bevande){
        this.bevandeOrdinate.add(bevande);
    }

    public double getTotale(){
        double totPizze = this.pizzeOrdinate.stream().mapToDouble(Pizza::getPrezzo).sum();
        double totBevande = this.bevandeOrdinate.stream().mapToDouble(Bevande::getPrezzo).sum();
        return totPizze + totBevande;
    }


    public void printOrdine(){
        System.out.println("\n**** ORDINE ****");
        System.out.println("Ordine: " + this.numeroOrdine);
        System.out.println("Ora Ordinazione: " + this.oraOrdinazione);
        System.out.println("Pizze ordinate: ");
        pizzeOrdinate.forEach(System.out::println);
        System.out.println("Bevande ordinate: ");
        bevandeOrdinate.forEach(System.out::println);
        System.out.println("Numero di Coperti: " + this.numCopertiOrdine);
        System.out.println("Costo TOTALE: ----> " + this.getTotale());
    }
}
