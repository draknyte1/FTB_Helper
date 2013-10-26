package FTBRestrict;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import com.gmail.mike546378.FTBHelper.FTBHelper;

public class DropListener implements Listener{
	public FTBHelper plugin;
	
	public DropListener(FTBHelper ftbhelper){
		plugin = ftbhelper;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onDrop(PlayerDropItemEvent ev){
		Player player = ev.getPlayer();
		int id = ev.getItemDrop().getItemStack().getTypeId();
		//Get Data Value
		String data = ev.getItemDrop().getItemStack().getData().toString();
		int endIndex = data.indexOf("(");
		String replacement = "";
		String toBeReplaced = data.substring(0, endIndex + 1);
		String newData = data.replace(toBeReplaced, replacement);
		endIndex = data.indexOf(")");
		toBeReplaced = data.substring(endIndex);
		String finalData = newData.replace(toBeReplaced, replacement);		
		if((player.hasPermission("FTBHelper.ban."+id+".*") || player.hasPermission("FTBHelper.ban."+id+"."+finalData) || player.hasPermission("FTBHelper.dropban."+id+".*") || player.hasPermission("FTBHelper.dropban."+id+"."+finalData)) && !player.hasPermission("FTBHelper.bypassban")){
			player.sendMessage(ChatColor.DARK_RED+"You can not drop banned items.");
			ev.setCancelled(true);
			if(plugin.getConfig().getBoolean("BroadcastBanItem")){
				Bukkit.broadcastMessage(ChatColor.WHITE+"["+ChatColor.RED+"FTBHelper"+ChatColor.WHITE+"] "+ChatColor.RED+player.getName()+" is trying to drop banned item: "+id+":"+finalData);
		
			}
		}
	}
}
