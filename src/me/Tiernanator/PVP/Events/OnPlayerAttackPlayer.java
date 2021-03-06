package me.Tiernanator.PVP.Events;

import java.util.List;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import me.Tiernanator.Factions.Factions.Faction;
import me.Tiernanator.Factions.Factions.FactionAccessor;
import me.Tiernanator.PVP.PvPMain;
import me.Tiernanator.Utilities.Events.CustomEvents.PlayerDamagePlayerEvent;

public class OnPlayerAttackPlayer implements Listener {
	

	public OnPlayerAttackPlayer(PvPMain main) {
	}

	@EventHandler
	public void onPlayerAttackPlayer(PlayerDamagePlayerEvent event) {
		
		Player attacked = (Player) event.getAttackedPlayer();
		Player attacker = (Player) event.getPlayer();
		
		FactionAccessor attackedAccessor = new FactionAccessor(attacked);
		FactionAccessor attackerAccessor = new FactionAccessor(attacker);
		
		Faction attackedFaction = attackedAccessor.getPlayerFaction();
		Faction attackerFaction = attackerAccessor.getPlayerFaction();
		
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
