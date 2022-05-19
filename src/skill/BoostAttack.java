package skill;

import logic.UnitHero;

public class BoostAttack {
	int buff=10;
	int times=0;
	
	public void setBoostAttack(UnitHero unitHero) {
		unitHero.setAttack(unitHero.getAttack()+buff);
	}
	
	public int getBuff() {
		return buff;
	}

	public int getTimes() {
		return times;
	}

	public void setBuff(int buff) {
		this.buff = buff;
	}

	public void setTimes(int times) {
		this.times = times;
	}

}
