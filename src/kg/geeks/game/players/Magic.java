package kg.geeks.game.players;

public class Magic extends Hero {
    private int boostAmount;
    public Magic(int health, int damage, String name) {

        super(health, damage, name, SuperAbility.BOOST);
        this.boostAmount = 3;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                hero.setDamage(hero.getDamage() + boostAmount);
                System.out.println(this.getName() + " увеличил атаку героя " + hero.getName() + " на " + boostAmount);

            }
        }
    }
}