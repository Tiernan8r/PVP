package me.Tiernanator.PVP;

import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import me.Tiernanator.PVP.Events.OnPlayerAttackPlayer;

public class Main extends JavaPlugin {
	
	@Override
	public void onEnable() {
		registerCommands();
		registerEvents();
	}

	@Override
	public void onDisable() {

	}

	public void registerCommands() {
		
	}

	public void registerEvents() {
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new OnPlayerAttackPlayer(this), this);
	}

}
