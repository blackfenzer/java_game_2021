package skill;

import logic.UnitHero;

public class ShieldUp {
	int shieldUp=10;
	int times=0;
	
	public void setHeal(UnitHero unitHero) {
		unitHero.setShield(unitHero.getHealth() + shieldUp);
	}

	public int getShieldUp() {
		return shieldUp;
	}

	public int getTimes() {
		return times;
	}

	public void setShieldUp(int shieldUp) {
		this.shieldUp = shieldUp;
	}

	public void setTimes(int times) {
		this.times = times;
	}
	
}
