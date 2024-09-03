package brianpelinku.u5_w1_d2.configurations;

import brianpelinku.u5_w1_d2.entities.Bevande;
import brianpelinku.u5_w1_d2.entities.Menu;
import brianpelinku.u5_w1_d2.entities.Pizza;
import brianpelinku.u5_w1_d2.entities.Topping;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class PizzaConfig {

    // toppings
    @Bean
    public Topping pomodoto() {
        return new Topping("Pomodoro", 100, 0);
    }

    @Bean
    public Topping mozzarella() {
        return new Topping("Mozzarella", 100, 0);
    }

    @Bean
    public Topping salsiccia() {
        return new Topping("salsiccia", 100, 2.5);
    }

    @Bean
    public Topping salamePiccante() {
        return new Topping("Salame piccante", 100, 2);
    }

    @Bean
    public Topping mozzarellaBufala() {
        return new Topping("Mozzarella di bufala", 100, 3.5);

    }

    @Bean
    public Topping prosciuttoCrudo() {
        return new Topping("Prosciutto crudo", 100, 2.5);
    }

    // pizze
    @Bean
    public Pizza pizzaMargherita() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        toppingList.add(pomodoto());
        return new Pizza("Pizza Margherita", toppingList);
    }

    @Bean
    public Pizza pizzaProsciutto() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        toppingList.add(pomodoto());
        toppingList.add(prosciuttoCrudo());
        return new Pizza("Pizza col prosciutto crudo", toppingList);
    }

    @Bean
    public Pizza pizzaPiccantina() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        toppingList.add(pomodoto());
        toppingList.add(salamePiccante());
        return new Pizza("Pizza Piccantina", toppingList);
    }

    @Bean
    public Pizza pizzaDiavolina() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarella());
        toppingList.add(pomodoto());
        toppingList.add(salamePiccante());
        toppingList.add(salsiccia());
        return new Pizza("Pizza Diavolina", toppingList);
    }

    @Bean
    public Pizza pizzaBufalotta() {
        List<Topping> toppingList = new ArrayList<>();
        toppingList.add(mozzarellaBufala());
        toppingList.add(pomodoto());
        toppingList.add(prosciuttoCrudo());
        return new Pizza("Pizza Bufalotta", toppingList);
    }

    // bevande
    @Bean
    public Bevande acquaNat() {
        return new Bevande("Acqua naturale", 0, 2);
    }

    @Bean
    public Bevande acquaNFriz() {
        return new Bevande("Acqua frizzante", 0, 2);
    }

    @Bean
    public Bevande cocaCola() {
        return new Bevande("Cocacola", 0, 4);
    }

    @Bean
    public Bevande birra() {
        return new Bevande("Birra", 0, 4.5);
    }

    @Bean
    public Bevande vino() {
        return new Bevande("vino", 0, 5);
    }

    @Bean
    public Menu menu() {
        List<Pizza> pizze = new ArrayList<>();
        List<Bevande> bevande = new ArrayList<>();
        List<Topping> toppings = new ArrayList<>();

        pizze.add(pizzaMargherita());
        pizze.add(pizzaBufalotta());
        pizze.add(pizzaProsciutto());
        pizze.add(pizzaDiavolina());
        pizze.add(pizzaPiccantina());

        toppings.add(pomodoto());
        toppings.add(mozzarella());
        toppings.add(mozzarellaBufala());
        toppings.add(prosciuttoCrudo());
        toppings.add(salsiccia());
        toppings.add(salamePiccante());

        bevande.add(acquaNat());
        bevande.add(acquaNFriz());
        bevande.add(cocaCola());
        bevande.add(birra());
        bevande.add(vino());

        return new Menu(pizze, toppings, bevande);
    }

}
