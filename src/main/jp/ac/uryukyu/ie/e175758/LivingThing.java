package jp.ac.uryukyu.ie.e175758;

public class LivingThing {
    String name;
    int hitPoint;
    int attack;
    boolean dead;

    public LivingThing (String name, int maximumHP, int attack) {
        System.out.printf("%sのHPは%d。攻撃力は%dです。\n", name, maximumHP, attack);
        this.name = name;
        hitPoint = maximumHP;
        this.attack = attack;
        dead = false;
    }

    public boolean isDead() { return dead; }
    public String getName() { return name; }

    public void attack(LivingThing opponent) {
        int damage = (int) (Math.random() * attack);
        if (dead == true)
            damage = 0;
        System.out.printf("%sの攻撃！%sに%dのダメージを与えた！！\n", name, opponent.getName(), damage);
        opponent.wounded(damage);
    }

    public void wounded(int damage) {
        hitPoint -= damage;
        if (hitPoint <= 0) {
            dead = true;
            System.out.printf("%sは倒れた。\n", name);
        }
    }
}
