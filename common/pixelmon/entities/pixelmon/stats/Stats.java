package pixelmon.entities.pixelmon.stats;

import net.minecraft.src.NBTTagCompound;

public class Stats {
	public int HP;
	public int Attack;
	public int Defence;
	public int SpecialAttack;
	public int SpecialDefence;
	public int Speed;
	public IVStore IVs;
	public EVsStore EVs = new EVsStore();

	public void setLevelStats(BaseStats baseStats, int level) {
		HP = (int) ((((float) IVs.HP + 2 * (float) baseStats.hp + ((float) EVs.HP) / 4f + 100f) * (float) level) / 100f + 10f);
		Attack = (int) ((((float) IVs.Attack + 2 * (float) baseStats.attack + ((float) EVs.Attack) / 4f) * (float) level) / 100f + 5f);
		Defence = (int) ((((float) IVs.Defence + 2 * (float) baseStats.defence + ((float) EVs.Defence) / 4f) * (float) level) / 100f + 5f);
		SpecialAttack = (int) ((((float) IVs.SpAtt + 2 * (float) baseStats.spAtt + ((float) EVs.SpecialAttack) / 4f) * (float) level) / 100f + 5f);
		SpecialDefence = (int) ((((float) IVs.SpDef + 2 * (float) baseStats.spDef + ((float) EVs.SpecialDefence) / 4f) * (float) level) / 100f + 5f);
		Speed = (int) ((((float) IVs.Speed + 2 * (float) baseStats.speed + ((float) EVs.Speed) / 4f) * (float) level) / 100f + 5f);
	}

	public void writeToNBT(NBTTagCompound var1) {
		var1.setInteger("StatsHP", HP);
		var1.setInteger("StatsAttack", Attack);
		var1.setInteger("StatsDefence", Defence);
		var1.setInteger("StatsSpecialAttack", SpecialAttack);
		var1.setInteger("StatsSpecialDefence", SpecialDefence);
		var1.setInteger("StatsSpeed", Speed);
		if (IVs != null)
			IVs.writeToNBt(var1);
		EVs.writeToNBT(var1);
	}

	public void readFromNBT(NBTTagCompound var1) {
		HP = var1.getInteger("StatsHP");
		Attack = var1.getInteger("StatsAttack");
		Defence = var1.getInteger("StatsDefence");
		SpecialAttack = var1.getInteger("StatsSpecialAttack");
		SpecialDefence = var1.getInteger("StatsSpecialDefence");
		Speed = var1.getInteger("StatsSpeed");
		if (IVs != null)
			IVs.readFromNBT(var1);
		EVs.readFromNBT(var1);
	}
}
