package pl.org.mensa.rp.mc.SpectatorRespawn;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeathListener implements Listener {
	SpectatorRespawnPlugin plugin;
	
	public PlayerDeathListener(SpectatorRespawnPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		final Player p = e.getEntity();
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				p.spigot().respawn();
			}
		}, 1L);
		
		if (!p.hasPermission("spectatorrespawn.exemptoverride") && (p.hasPermission("spectatorrespawn.exempt") || p.isOp())) {
			return;
		}
		
		Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
			@Override
			public void run() {
				p.setGameMode(GameMode.SPECTATOR);
			}
		}, 2L);
	}
}
