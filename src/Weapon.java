class Weapon {
    protected int damage;
    public Weapon (int damage) {
        this.damage = damage;
    }
}

class Axe extends Weapon {
    private static final int damage = 10;
    public Axe() {

        super (damage);
    }
}

class Hammer extends Weapon {
    private static final int damage = 20;
    public Hammer () {
        super(damage);
    }
}
