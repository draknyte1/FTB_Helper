package FTBRestrict;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class CraftListener implements Listener{
	public static boolean craftban = false;
	public FTBHelper plugin;
	
	public CraftListener(FTBHelper ftbhelper){
		plugin = ftbhelper;
	}
@EventHandler(priority = EventPriority.HIGHEST)
//On craft
	public void onCraft(CraftItemEvent ci){

//Getting the data value
		String data = ci.getCurrentItem().getData().toString();
		Player player = (Player)ci.getWhoClicked();
		int endIndex = data.indexOf("(");
		String replacement = "";
		String toBeReplaced = data.substring(0, endIndex + 1);
		String newData = data.replace(toBeReplaced, replacement);
		endIndex = data.indexOf(")");
		toBeReplaced = data.substring(endIndex);
		String finalData = newData.replace(toBeReplaced, replacement);
		
		if((player.hasPermission("FTBHelper.ban."+ci.getCurrentItem().getTypeId() + "." + finalData) || player.hasPermission("FTBHelper.craftban."+ci.getCurrentItem().getTypeId()+".*") || player.hasPermission("FTBHelper.craftban."+ci.getCurrentItem().getTypeId()+"."+finalData)) && !player.hasPermission("FTBHelper.bypassban") && !player.isOp()){
			craftban = true;
			ci.setCancelled(true);
			player.sendMessage(ChatColor.DARK_RED+"Sorry, this item is banned.");
			Bukkit.broadcastMessage(ChatColor.WHITE+"["+ChatColor.RED+"FTBHelper"+ChatColor.WHITE+"] "+ChatColor.RED+player.getName()+" is trying to craft banned item: "+ci.getCurrentItem().getTypeId()+":"+finalData);
		}else if(player.hasPermission("FTBHelper.ban."+ci.getCurrentItem().getTypeId() + ".*") && !player.hasPermission("FTBHelper.bypassban") && !player.isOp()){
			craftban = true;
			ci.setCancelled(true);
			player.sendMessage(ChatColor.DARK_RED+"Sorry, this item is banned.");
			if(plugin.getConfig().getBoolean("BroadcastBanItem")){
				Bukkit.broadcastMessage(ChatColor.WHITE+"["+ChatColor.RED+"FTBHelper"+ChatColor.WHITE+"] "+ChatColor.RED+player.getName()+" is trying to craft banned item: "+ci.getCurrentItem().getTypeId()+":"+finalData);
			}
		}
	}
}
