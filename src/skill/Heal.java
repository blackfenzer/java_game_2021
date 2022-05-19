package skill;

import logic.UnitHero;

public class Heal {
	int heal=10;
	int times=0;
	
	public void setHeal(UnitHero unitHero) {
		unitHero.setHealth(unitHero.getHealth() + heal);
	}
	
	public int getHeal() {
		return heal;
	}

	public int getTimes() {
		return times;
	}

	public void setHeal(int heal) {
		this.heal = heal;
	}

	public void setTimes(int times) {
		this.times = times;
	}

}
