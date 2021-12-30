import java.util.Scanner;
import java.lang.Math;

public class PokemonLab {
  static Scanner in =  new Scanner(System.in);

  public static void main(String[] args) {

    System.out.println("Please select a pokemon type:");
    System.out.println("1: Fire type");
    System.out.println("2: Water type");
    System.out.println("3: Leaf type");
    int n = in.nextInt();

    if (n == 1) {
      Pokemon pokemon = PokemonFactory.getPokemon("Fire", false);
      System.out.println("Charmander received! What do you want to do with it?");
      pokemon.game();
      
    } else if (n == 2) {
      Pokemon pokemon = PokemonFactory.getPokemon("Water", false);
      System.out.println("Squirtle received! What do you want to do with it?");
      pokemon.game();
    
    } else if (n == 3) {
      Pokemon pokemon = PokemonFactory.getPokemon("Leaf", false);
      System.out.println("Bulbasaur received! What do you want to do with it?");
      pokemon.game();
      
    } else
      System.out.println("Invalid input.");
  }

}


abstract class Pokemon {
  static Scanner in =  new Scanner(System.in);
  
  String type;
  String name;
  int healthpoints;
  int hunger;
  int level;
  int experience;
  boolean wild;

  public Pokemon(String t, String n, boolean w) {
    this.type = t;
    this.name = n;
    this.healthpoints = 10;
    this.hunger = 0;
    this.level = 1;
    this.experience = 0;
    this.wild = w;
    }

  abstract public void fight();

  public void faint() {
    System.out.println(name + " fainted!");
    System.out.println("You rush " + name + " to a medical center.");
    healthpoints = 10;
    hunger = 0;
    System.out.println("...");
    System.out.println(name + " is all healed! Don't let it lose too much HP or get too hungry.");
  }

  public void eat() {
    if (hunger == 0)
      System.out.println(name + "isn't hungry.");
    else {
      System.out.println("You feed " + name + " a pokepuff.");
      hunger = 0;
    }
  }

  public void speak() {
    if (type == "Fire")
      System.out.println(name + ": Char char.");
    else if (type == "Water")
      System.out.println(name + ": Squirtle Squirtle.");
    else
      System.out.println(name + ": Bulb bulb.");
    hunger++;
  }

  public void medical() {
    System.out.println("HP restored.");
    healthpoints = 10;
  }

  public void levelup() {
    System.out.println("LEVELED UP!!!");
    level++;
    experience = 0;
  }

  public void game() {

    int inputnum = -1;

    while(inputnum != 0) {
    
      if (healthpoints <= 0 || hunger == 10)
        this.faint();
      if (experience == 10)
        this.levelup();

      System.out.println("0: Quit the game");
      System.out.println("1: Feed");
      System.out.println("2: Speak");
      System.out.println("3: Fight");
      System.out.println("4: Take to Pokemon Center");
      System.out.println();

      inputnum = in.nextInt();

      switch (inputnum) {
        case 0:
          break;
        case 1:
          this.eat();
          break;
        case 2:
          this.speak();
          break;
        case 3:
          this.fight();
          break;
        case 4:
          this.medical();
          break;
        default:
          System.out.println("Illegal value entered");
      }
    }

  }

}

class Charmander extends Pokemon {

  public Charmander(String n, boolean w) {
      super("Fire", n, w);
  }

  public void fight() {
    System.out.println("Wild Pokemon Encountered!");
    
    Pokemon wildpokemon = PokemonFactory.getPokemon("", wild = true);

    int wilddamage;
    int damage;

    if (wildpokemon.type == "Water") {
      wilddamage = 2;
      damage = 3;
    } else if (wildpokemon.type == "Fire") {
      wilddamage = 1;
      damage = 3;
    } else {
      wilddamage = 1;
      damage = 4;
    }

    while (healthpoints >= 1  && wildpokemon.healthpoints >= 1) {
      wildpokemon.healthpoints = wildpokemon.healthpoints - damage;
      healthpoints = healthpoints - wilddamage;
    }

    if (healthpoints <= 0)
      System.out.println(name + " lost.");
    else if (wildpokemon.healthpoints <= 0) {
      System.out.println(name + " won!");
      experience++;
      hunger++;
    }

  }
   
}

class Squirtle extends Pokemon {

  public Squirtle(String n, boolean w) {
    super("Water", n, w);
  }

  public void fight() {
    System.out.println("Wild Pokemon Encountered!");
    
    Pokemon wildpokemon = PokemonFactory.getPokemon("", wild = true);

    int wilddamage;
    int damage;

    if (wildpokemon.type == "Water") {
      wilddamage = 1;
      damage = 3;
    } else if (wildpokemon.type == "Fire") {
      wilddamage = 1;
      damage = 4;
    } else {
      wilddamage = 2;
      damage = 3;
    }

    while (healthpoints >= 1  && wildpokemon.healthpoints >= 1) {
      wildpokemon.healthpoints = wildpokemon.healthpoints - damage;
      healthpoints = healthpoints - wilddamage;
    }

    if (healthpoints <= 0)
      System.out.println(name + " lost.");
    else if (wildpokemon.healthpoints <= 0) {
      System.out.println(name + " won!");
      experience++;
      hunger++;
    }

  }

}

class Bulbasaur extends Pokemon {

  public Bulbasaur(String n, boolean w) {
    super("Leaf", n, w);
  }
 
  public void fight() {
    System.out.println("Wild Pokemon Encountered!");
    
    Pokemon wildpokemon = PokemonFactory.getPokemon("", wild = true);

    int wilddamage;
    int damage;

    if (wildpokemon.type == "Water") {
      wilddamage = 1;
      damage = 4;
    } else if (wildpokemon.type == "Fire") {
      wilddamage = 2;
      damage = 3;
    } else {
      wilddamage = 1;
      damage = 3;
    }

    while (healthpoints >= 1  && wildpokemon.healthpoints >= 1) {
      wildpokemon.healthpoints = wildpokemon.healthpoints - damage;
      healthpoints = healthpoints - wilddamage;
    }

    if (healthpoints <= 0)
      System.out.println(name + " lost.");
    else if (wildpokemon.healthpoints <= 0) {
      System.out.println(name + " won!");
      experience++;
      hunger++;
    }

  }

}

class PokemonFactory {
  public static Pokemon getPokemon(String criteria, boolean wild) {

    if (wild) {
      double type = Math.random();
      if (type < 0.33333)
        return new Charmander("Wild Charmander", true);
      else if (type >= 0.33333 && type < 0.666666)
        return new Squirtle("Wild Squirtle", true);
      else
        return new Bulbasaur("Wild Bulbasaur", true);
    } else {
      if (criteria.equals("Fire"))
        return new Charmander("Charmander", false);
      else if (criteria.equals("Water"))
        return new Squirtle("Squirtle", false);
      else if (criteria.equals("Leaf"))
        return new Bulbasaur("Bulbasaur", false);
    }

    return null;

  }
}

