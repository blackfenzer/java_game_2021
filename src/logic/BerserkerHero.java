package logic;

public class BerserkerHero extends UnitHero {
	public BerserkerHero() {
		super();
		this.setAttack(40);
		this.setHealth(70);
		this.setName("Berserker Hero");
	}

	@Override
	public void setHealth(int health) {
		super.setHealth(health);
		this.setAttack(this.getAttack()+10);
	}

	@Override
	public void attack(Boss boss) {
		boss.setHealth(boss.getHealth() - this.getAttack());
		// TODO Auto-generated method stub
		
	}
	
}
