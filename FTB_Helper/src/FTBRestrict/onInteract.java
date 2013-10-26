package FTBRestrict;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import com.gmail.mike546378.FTBHelper.FTBHelper;

public class onInteract implements Listener{

	
	public FTBHelper plugin;
	
	public onInteract(FTBHelper ftbhelper){
		plugin = ftbhelper;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(PlayerInteractEvent ev){
		if(ev.getClickedBlock() != null){
			int item = ev.getClickedBlock().getTypeId();
			byte data = ev.getClickedBlock().getData();
			if((ev.getAction().equals(Action.RIGHT_CLICK_AIR) || ev.getAction().equals(Action.RIGHT_CLICK_BLOCK) || ev.getAction().equals(Action.LEFT_CLICK_AIR) || ev.getAction().equals(Action.LEFT_CLICK_BLOCK)) && !ev.getPlayer().hasPermission("FTBHelper.bypassban")){
				if((ev.getPlayer().hasPermission("FTBHelper.ban."+item+"."+data) || ev.getPlayer().hasPermission("FTBHelper.ban."+item+".*") || ev.getPlayer().hasPermission("FTBHelper.interactban."+item+".*") || ev.getPlayer().hasPermission("FTBHelper.interactban."+item+"."+data)) && !ev.getPlayer().hasPermission("FTBHelper.bypassban")){
					ev.setCancelled(true);
					ev.getPlayer().sendMessage(ChatColor.DARK_RED+"Sorry, the clicked item is banned.");
					if(plugin.getConfig().getBoolean("BroadcastBanItem")){
						Bukkit.broadcastMessage(ChatColor.WHITE+"["+ChatColor.RED+"FTBHelper"+ChatColor.WHITE+"] "+ChatColor.RED+ev.getPlayer().getName()+" is trying to interact with banned item: "+item+":"+data);
					}
				}
			}
		}
	}
}
