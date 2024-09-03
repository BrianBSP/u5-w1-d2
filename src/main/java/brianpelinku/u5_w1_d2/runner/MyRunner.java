package brianpelinku.u5_w1_d2.runner;

import brianpelinku.u5_w1_d2.U5W1D2Application;
import brianpelinku.u5_w1_d2.entities.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private Tavolo tavolo;

    /*@Autowired
    private Ordine ordine;*/

    @Autowired
    private Menu menu;


    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(U5W1D2Application.class);

        tavolo.printTavolo();

        System.out.println("Ciao e benuvenuti \nRistoria Pizzorante se non vieni sei ignorante");
        menu.printMenu();

        Ordine ordine1 = new Ordine(3, this.tavolo);
        ordine1.aggiungiPizza(context.getBean("pizza_margherita", Pizza.class));
        ordine1.aggiungiPizza(context.getBean("pizza_prosciutto", Pizza.class));
        ordine1.aggiungiPizza(context.getBean("pizza_bufalotta", Pizza.class));
        ordine1.aggiungiBevanda(context.getBean("birra", Bevande.class));
        ordine1.aggiungiBevanda(context.getBean("vino", Bevande.class));
        ordine1.aggiungiBevanda(context.getBean("acqua_frizzante", Bevande.class));
        ordine1.printOrdine();

    }


}
