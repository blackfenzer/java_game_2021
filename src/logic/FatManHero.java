package logic;

public class FatManHero extends UnitHero {

	public FatManHero() {
		super();
		this.setHealth(1000);
		this.setName("Fat Man Hero");
	}

	@Override
	public void attack(Boss boss) {
		// TODO Auto-generated method stub
		boss.setHealth(boss.getHealth() - this.getAttack());
	}

}
