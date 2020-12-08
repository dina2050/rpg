
abstract class Destructible implements MapObject {
    protected double life = 100;
    int damage;
    public void hit_me(int damage){
        this.damage = damage;
        Elfe player = new Elfe("name", 100, 100, 50, 0);
        player.health-=damage;
        life -= damage;
    }
}

class Monster extends Destructible{
    char msymbol = 'M';
    int damage = 20;
    @Override
    public void hit_me(int damage) {
        this.damage = damage;
        super.hit_me(damage);
    }

    @Override
    public char getSymbol(){
        return msymbol;
    }
}

class Obstacle extends Destructible{
    char osymbol = 'O';
    int damage = 10;
    @Override
    public void hit_me(int damage) {
        this.damage = damage;
        super.hit_me(damage);
    }
    @Override
    public char getSymbol(){
        return osymbol;
    }
}