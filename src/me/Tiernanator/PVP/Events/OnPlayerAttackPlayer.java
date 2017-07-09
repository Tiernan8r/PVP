package me.Tiernanator.PVP.Events;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import me.Tiernanator.Factions.Factions.Faction;
import me.Tiernanator.Factions.Factions.FactionAccessor;
import me.Tiernanator.PVP.PvPMain;

public class OnPlayerAttackPlayer implements Listener {
	

	public OnPlayerAttackPlayer(PvPMain main) {
	}

	@EventHandler
	public void onPlayerAttackPlayer(EntityDamageByEntityEvent event) {
		
		if (!(event.getEntity() instanceof Player)) {
			return;
		}
		if (!(event.getDamager() instanceof Player)) {
			return;
		}

		Player attacked = (Player) event.getEntity();
		Player attacker = (Player) event.getDamager();
		
		FactionAccessor attackedAccessor = new FactionAccessor(attacked);
		FactionAccessor attackerAccessor = new FactionAccessor(attacker);
		
//		Faction attackedFaction = Faction.getPlayerFaction(attacked);
		Faction attackedFaction = attackedAccessor.getPlayerFaction();
		Faction attackerFaction = attackerAccessor.getPlayerFaction();
//		Faction attackerFaction = Faction.getPlayerFaction(attacker);
		
		List<Faction> allFactions = Faction.allFactions();
		Faction rogueFaction = allFactions.get(allFactions.size() - 1);
		
		// Anyone can attack or be attacked by Rogues.
		if(attackerFaction.equals(rogueFaction) || attackedFaction.equals(rogueFaction)) {
			return;
		}

		if (attackedFaction.equals(attackerFaction)) {
			event.setCancelled(true);
			return;
		}

	}
}
