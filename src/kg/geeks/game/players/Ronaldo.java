package kg.geeks.game.players;

import kg.geeks.game.logic.RPG_Game;

public class Ronaldo extends Hero {
    private int roundCounter = 0;
    private int ballDamage = 100;
    private int chanceToMiss = 30;

    public Ronaldo(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.SHOOT_BALL);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        roundCounter++;
        if (roundCounter % 2 == 0) {
            if (RPG_Game.random.nextInt(100) >= chanceToMiss) {
                boss.setHealth(boss.getHealth() - ballDamage);
                System.out.println(this.getName() + " ударил мячом по боссу и нанес " + ballDamage + " урона.");
            } else {
                System.out.println(this.getName() + " промахнулся.");
            }
        }
    }
}
/*Ronaldo - создает мяч с которым он наносит урон, урон будет наносить 10 единиц
но каждые 2 раунда он наносит боссу 100 единиц урона мячом и с шансом 30% он промахивается. */