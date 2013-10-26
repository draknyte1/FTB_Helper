package commands;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import com.gmail.mike546378.FTBHelper.FTBHelper;

public class IdFinderListener implements Listener{

	
	public FTBHelper plugin;
	
	public IdFinderListener(FTBHelper ftbhelper){
		plugin = ftbhelper;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(PlayerInteractEvent ev){
		if(IdFinder.active.contains(ev.getPlayer().getName())){
			int item = ev.getClickedBlock().getTypeId();
			byte data = ev.getClickedBlock().getData();;
			ev.getPlayer().sendMessage(ChatColor.GRAY+""+item+":"+data);
			ev.setCancelled(true);
		}
	}
}

