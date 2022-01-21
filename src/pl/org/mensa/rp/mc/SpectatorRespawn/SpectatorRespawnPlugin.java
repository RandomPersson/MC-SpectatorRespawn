package pl.org.mensa.rp.mc.SpectatorRespawn;

import org.bukkit.plugin.java.JavaPlugin;

public class SpectatorRespawnPlugin extends JavaPlugin {
	@Override
	public void onEnable() {
		this.getServer().getPluginManager().registerEvents(new PlayerDeathListener(this), this);
	}
}
