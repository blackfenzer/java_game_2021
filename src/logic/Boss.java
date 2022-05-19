package logic;

public class Boss implements Evolvable{
	private int health;
	private int attack,level;
	private String name;
	
	public Boss(int level) {
		this.level =level;
		this.setHealth(this.level*50);
		this.setAttack(this.level*6);
		this.setName("Demon lord Lv : " + level);

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

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void levelUp(int level) {
		// TODO Auto-generated method stub
		this.setHealth(level*50);
		this.setAttack(level*6);
		this.setName("Demon lord Lv : " + level);
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
