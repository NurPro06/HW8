package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Hacker extends Hero {
    public Hacker(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.HACK);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int stolenHealth = RPG_Game.random.nextInt(30) + 20;
        boss.setHealth(boss.getHealth() - stolenHealth);

        Hero randomHero = heroes[RPG_Game.random.nextInt(heroes.length)];
        if (randomHero.getHealth() > 0) {
            randomHero.setHealth(randomHero.getHealth() + stolenHealth);
            System.out.println(this.getName() + " забрал " + stolenHealth + " здоровья у босса и передал герою " + randomHero.getName());
        }
    }
}