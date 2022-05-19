package logic;

public abstract class UnitHero {
	private int health;
	private int attack;
	private int shield;
	private String name;
	
	public UnitHero() {
		this.setHealth(100);
		this.setAttack(20);
		this.setShield(0);
		this.setName("Classic Hero");
	}
	
	public abstract void attack(Boss boss);
		
	public int attacked(int damage) {
		int downdamage = damage-this.getShield();
		if (downdamage < 0) { downdamage = 0;}
		return downdamage;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void setHealth(int health) {
		if (health >= 0) {
			this.health = health;
		} else {
			this.health = 0;
		}
	}
	
	
	
	public int getAttack() {
		return attack;
	}
	
	public void setAttack(int attack) {
		if (attack >= 0) {
			this.attack = attack;
		} else {
			this.attack = 0;
		}
	}
	
	public int getShield() {
		return shield;
	}
	
	public void setShield(int shield) {
		if (shield >= 0) {
			this.shield = shield;
		} else {
			this.shield = 0;
		}
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	
}
