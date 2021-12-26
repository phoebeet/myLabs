import java.util.Scanner;

public class PokemonLab {
  static Scanner in =  new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("Please select a pokemon type:");
    System.out.println("1: Fire type");
    System.out.println("2: Water type");
    System.out.println("3: Leaf type");
    int n = in.nextInt();
    in.nextLine();
    System.out.println("Pick a name for your pokemon:");
    String name = in.nextLine();

    if (n == 1) {
      // create a fire pokemon
      Pokemon pokemon = PokemonFactory.getPokemon(name, "Fire");
      System.out.println("Charmander received! What do you want to do with it?");
      System.out.println("1: feed");
      System.out.println("2: eat");
      System.out.println("3: Leaf type");
      int c = in.nextInt();
    } else if (n == 2) {
      // create a water pokemon
      Pokemon pokemon = PokemonFactory.getPokemon(name, "Water");
    } else if (n == 3) {
      // create a leaf pokemon
      Pokemon pokemon = PokemonFactory.getPokemon(name, "Leaf");
    } else
      System.out.println("Format not supported");
  }
}


abstract class Pokemon
{
  String name;
  String type;
  int healthpoint;
  int damage;
  int hunger;
  int level;
  int experience;

  public Pokemon(String n, String t) {
    this.name = n;
    this.type = t;
    this.healthpoint = 10;
    this.damage = 0;
    this.hunger = 0;
    this.level = 1;
    this.experience = 0;
  }

  abstract public void eat();
  abstract public void speak();

  public void faint() {
    if (this.healthpoint == 0 || this.hunger == 10)
      System.out.println("Your Pokemon fainted! Game over.");
  }

  public void fight(Pokemon enemy) {
    if (this.level > enemy.level)
      enemy.damage++;
    else if (this.level == enemy.level) {
      enemy.damage++;
      this.damage++;
    } else
      this.damage++;
  }

  public void medical() {
    this.healthpoint = 10;
    System.out.println("Your Pokemon fainted! Game over.");
  }
}

class Charmander extends Pokemon
{
  public Charmander(String n) {
    super(n, "Fire");
  }

  public void eat() {
    if (hunger != 0)
      System.out.println("Charmander isn't hungry.");
    else {
      System.out.println("You feed Charmander a pokepuff.");
      hunger = 0;
    }
  }

  public void speak() {
    System.out.println("Char char.");
    System.out.println("I am " + this.name + " and I am a " + this.type + "pokemon");
  }
}

class Squirtle extends Pokemon
{
  public Squirtle(String n) {
    super(n, "Water");
  }

  public void eat() {
    if (hunger != 0)
      System.out.println("Squirtle isn't hungry.");
    else {
      System.out.println("You feed Squirtle a pokepuff.");
      hunger = 0;
    }
  }

  public void speak() {
    System.out.println("Squirtle squirtle.");
  }
}

class Turtwig extends Pokemon
{
  public Turtwig(String n) {
    super(n, "Leaf");
  }

  public void eat() {
    if (hunger != 0)
      System.out.println("Turtwig isn't hungry.");
    else {
      System.out.println("You feed Turtwig a pokepuff.");
      hunger = 0;
    }
  }

  public void speak() {
    System.out.println("Turt turt.");
  }
}

class PokemonFactory
{
  public static Pokemon getPokemon(String n, String t)
  {
    if (t.equals("Fire"))
      return new Charmander(n);
    else if (t.equals("Water"))
      return new Squirtle(n);
    else // the default is "Leaf"
      return new Turtwig(n);
  }
}
