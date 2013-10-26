package Update;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import com.gmail.mike546378.FTBHelper.FTBHelper;

public class LoginListener implements Listener{

	public FTBHelper plugin;
	
	public LoginListener(FTBHelper ftbHelper){
		plugin = ftbHelper;
		CheckClass = new Check(plugin);
	}
	Update.Check CheckClass;

	public String formatedDesc(String desc){
		while(desc.contains("<") && desc.contains(">")){
			int StartIndex = desc.indexOf("<");
			int EndIndex = desc.indexOf(">") + 1;
			String toBeReplaced = desc.substring(StartIndex, EndIndex);
			desc = desc.replace(toBeReplaced, "");
		}
		return desc;
	}
	@EventHandler(priority = EventPriority.HIGHEST)
		public void onPlayerLogin(PlayerJoinEvent ev){
			if(ev.getPlayer().hasPermission("FTBHelper.notifyupdate")){
				if(CheckClass.updateNeeded()){
					final Player player = ev.getPlayer();
					plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
						public void run() {
							player.sendMessage(ChatColor.BLUE+"---------------------------------------------");
							player.sendMessage(ChatColor.BLUE+"---------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"---------");
							player.sendMessage(ChatColor.BLUE+"---------------------------------------------");
							player.sendMessage(ChatColor.AQUA+"Version " + ChatColor.GREEN+CheckClass.getVersion() +ChatColor.AQUA+ " of FTBHelper is now avalible! Grab it now over at:");
							player.sendMessage(ChatColor.GREEN+"http://dev.bukkit.org/bukkit-plugins/ftbhelper/files/"+ChatColor.AQUA+" for these new features!:");
							player.sendMessage(ChatColor.GREEN+formatedDesc(CheckClass.getDescription()));
						}
					}, 10L);
				}
			}
		}
}