package FTBRestrict;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import com.gmail.mike546378.FTBHelper.FTBHelper;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;


public class ItemPickupListener implements Listener{
public FTBHelper plugin;
public ItemPickupListener(FTBHelper ftbhelper){
	plugin = ftbhelper;
}

//On pickup of an item
@EventHandler(priority = EventPriority.HIGHEST)
	public void onItemPickup(PlayerPickupItemEvent ev){
	//Getting the ID value
	    Item eventitem = ev.getItem();
	    ItemStack eventstack = eventitem.getItemStack();
	    Material eventitemmaterial = eventstack.getType();	
	    int itemid = eventitemmaterial.getId(); 
	//Getting the Data Value
	    String data = eventstack.getData().toString();
		int endIndex = data.indexOf("(");
		String replacement = "";
		String toBeReplaced = data.substring(0, endIndex + 1);
		String newData = data.replace(toBeReplaced, replacement);
		endIndex = data.indexOf(")");
		toBeReplaced = data.substring(endIndex);
		String finalData = newData.replace(toBeReplaced, replacement);		
		
		if((ev.getPlayer().hasPermission("FTBHelper.ban."+itemid+".*") || ev.getPlayer().hasPermission("FTBHelper.pickupban."+itemid+".*") || ev.getPlayer().hasPermission("FTBHelper.pickup."+itemid+"."+finalData)) && !ev.getPlayer().hasPermission("FTBHelper.bypassban")){
			ev.setCancelled(true);
			ev.getPlayer().sendMessage(ChatColor.DARK_RED+"Sorry, you are not allowed to pick up this item as it is banned.");
		}else if(ev.getPlayer().hasPermission("FTBHelper.ban."+itemid+"."+finalData) && !ev.getPlayer().hasPermission("FTBHelper.bypassban")){
			 ev.setCancelled(true);
			 ev.getPlayer().sendMessage(ChatColor.DARK_RED+"Sorry, you are not allowed to pick up this item as it is banned.");
		}
	}	
}
