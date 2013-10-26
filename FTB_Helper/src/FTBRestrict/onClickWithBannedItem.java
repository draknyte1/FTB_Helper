package FTBRestrict;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class onClickWithBannedItem implements Listener{

	
	public FTBHelper plugin;
	
	public onClickWithBannedItem(FTBHelper ftbhelper){
		plugin = ftbhelper;
	}
	
	@EventHandler(priority = EventPriority.HIGHEST)
	public void onClick(PlayerInteractEvent ev){
		if(ev.getItem() != null){
			Player player = (Player)ev.getPlayer();
			int item = ev.getItem().getTypeId();
			String data = ev.getItem().getData().toString();
			int endIndex = data.indexOf("(");
			String replacement = "";
			String toBeReplaced = data.substring(0, endIndex + 1);
			String newData = data.replace(toBeReplaced, replacement);
			endIndex = data.indexOf(")");
			toBeReplaced = data.substring(endIndex);
			String finalData = newData.replace(toBeReplaced, replacement);
			if((ev.getAction().equals(Action.RIGHT_CLICK_AIR) || ev.getAction().equals(Action.RIGHT_CLICK_BLOCK) || ev.getAction().equals(Action.LEFT_CLICK_AIR) || ev.getAction().equals(Action.LEFT_CLICK_BLOCK)) && !ev.getPlayer().hasPermission("FTBHelper.bypassban")){
				if((ev.getPlayer().hasPermission("FTBHelper.ban."+item+"."+finalData) || ev.getPlayer().hasPermission("FTBHelper.ban."+item+".*") || ev.getPlayer().hasPermission("FTBHelper.clickban."+item+".*") || ev.getPlayer().hasPermission("FTBHelper.clickban."+item+"."+finalData)) && !ev.getPlayer().hasPermission("FTBHelper.bypassban")){
					ev.setCancelled(true);
					ev.getPlayer().sendMessage(ChatColor.DARK_RED+"Sorry, this item is banned.");
					if(plugin.getConfig().getBoolean("DropInvBanItem") == true){
						ItemStack toDrop = ev.getItem();
						player.getWorld().dropItemNaturally(player.getLocation(), toDrop);
						player.getInventory().remove(player.getItemInHand());
					}
					if(plugin.getConfig().getBoolean("DeleteInvBanItem") == true){
						ev.getItem().setType(null);
					}
					if(plugin.getConfig().getBoolean("BroadcastBanItem")){
						Bukkit.broadcastMessage(ChatColor.WHITE+"["+ChatColor.RED+"FTBHelper"+ChatColor.WHITE+"] "+ChatColor.RED+ev.getPlayer().getName()+" is trying to use/place banned item: "+item+":"+finalData);
					}
				}
			}
		}
	}
}
