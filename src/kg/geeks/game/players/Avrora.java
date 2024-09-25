package kg.geeks.game.players;

public class Avrora extends Hero {
    private boolean hasUsedInvisibility = false;
    private int invisibilityRounds = 2;
    private int damageTakenInInvisibility = 0;

    public Avrora(int health, int damage, String name) {
        super(health, damage, name, SuperAbility.INVISIBILITY);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (!hasUsedInvisibility) {
            hasUsedInvisibility = true;
            System.out.println(this.getName() + " В режим невидимости.");
        } else if (invisibilityRounds > 0) {
            invisibilityRounds--;
            damageTakenInInvisibility += boss.getDamage();
            System.out.println(this.getName() + " в невидимости и не получает урона.");
        } else if (invisibilityRounds == 0 && damageTakenInInvisibility > 0) {
            boss.setHealth(boss.getHealth() - damageTakenInInvisibility);
            System.out.println(this.getName() + " вышел из невидимости и вернул " + damageTakenInInvisibility + " урона боссу.");
            damageTakenInInvisibility = 0;
        }
    }
}
