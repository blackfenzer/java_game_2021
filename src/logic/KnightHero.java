package logic;

public class KnightHero extends UnitHero {
	public KnightHero() {
		super();
		this.setHealth(30);
		this.setShield(5);
		this.setName("Knight Hero");
	}

	@Override
	public void attack(Boss boss) {
		boss.setHealth(boss.getHealth()-this.getAttack());
		this.setShield(this.getShield()+1);
	}
	
	
}
