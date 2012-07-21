package pixelmon.battles.attacks.specialAttacks;

import java.util.ArrayList;

import pixelmon.battles.attacks.Attack;
import pixelmon.battles.attacks.attackEffects.EffectBase;
import pixelmon.battles.attacks.statusEffects.Flying;
import pixelmon.battles.attacks.statusEffects.StatusEffectBase;
import pixelmon.battles.attacks.statusEffects.StatusEffectType;
import pixelmon.comm.ChatHandler;
import pixelmon.entities.pixelmon.helpers.PixelmonEntityHelper;

import net.minecraft.src.DamageSource;
import net.minecraft.src.EntityLiving;
import net.minecraft.src.ModLoader;

public class Fly extends MultiTurnSpecialAttackBase {

	public Fly(MultiTurnSpecialAttackType type, int turnCount) {
		super(type, turnCount);
	}

	@Override
	public boolean ApplyEffect(PixelmonEntityHelper user, PixelmonEntityHelper target, Attack a, ArrayList<String> attackList) {
		if (!persists){
			persists = true;
			turnCounter=0;
		}
		turnCounter++;
		if (turnCounter == 1){
			ChatHandler.sendChat(user.getOwner(), target.getOwner(), user.getName() + " Flies up in the air!");
			user.getStatus().add(new Flying());
			return true;
		}else{
			for (int i =0; i < user.getStatus().size(); i++){
				StatusEffectBase e = user.getStatus().get(i);
				if (e.type == StatusEffectType.Flying) user.getStatus().remove(e);
			}
			persists = false;
			return false;
		}
	}

	@Override
	public boolean cantMiss() {
		if (turnCounter ==0) return true;
		return false;
	}
}