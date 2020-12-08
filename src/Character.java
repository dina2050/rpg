import java.util.ArrayList;
class Character {
    String name;
    int xp, money, mana, health;
    ArrayList<Weapon> weapons = new ArrayList<>();
    public Character (String name, int xp, int money, int mana, int health){
        this.name = name;
        this.xp = xp;
        this.money = money;
        this.mana = mana;
        this.health = health;

    }

    public void buyWeapon(){
        if (weapons.isEmpty()) {
            Weapon axe = new Axe();
            Weapon hammer = new Hammer();
            weapons.add(axe);
            weapons.add(hammer);
        }
    }

    public int attack (){
        xp+=1;
        System.out.println(xp);
        return xp;
    }
}

class Sorcier extends Character {

    public Sorcier(String name, int xp, int money, int mana, int health) {

        super(name, 100, 100, 50, 0);
    }
    char player = 'S';
    @Override
    public int attack (){
        super.attack();
        return xp;
    }
    public char getSymbol(){
        return player;
    }

}

 class Elfe extends Character {
    String armor;
     public Elfe(String name, int xp, int money, int mana, int health) {
         super(name, 100, 100, 50, 0);

     }
     char player = 'E';
     @Override
     public int attack (){
         super.attack();
         return xp;
     }
     public char getSymbol(){
         return player;
     }
 }