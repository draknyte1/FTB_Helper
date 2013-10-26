package AutoSave;


import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class autosave {
	private int timer = 0;
	private FTBHelper plugin;
	public autosave(FTBHelper plugin){
		this.plugin = plugin;
	}
	public void saveall(){
		if(plugin.getConfig().getBoolean("AutoSave")){	
			plugin.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new BukkitRunnable() {
				@Override
				public void run() {
					if(timer >= plugin.getConfig().getInt("AutoSaveDelay")){
						timer = 0;
						Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "save-all");
					}
					timer ++;
				}
			
			}, 0L, 20L);
		}
	}
}
