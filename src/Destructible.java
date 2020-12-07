
abstract class Destructible implements MapObject {
    protected double life = 100;
    public void hit_me(int damage){
        life -= damage;
    }
}

class Monster extends Destructible{
    char msymbol = 'M';

    @Override
    public char getSymbol(){
        return msymbol;
    }
}

class Obstacle extends Destructible{
    char osymbol = 'O';

    @Override
    public char getSymbol(){
        return osymbol;
    }
}