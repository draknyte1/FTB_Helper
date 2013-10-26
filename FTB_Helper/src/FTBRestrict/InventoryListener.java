package FTBRestrict;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class InventoryListener implements Listener{

	public FTBHelper plugin;
	
	public InventoryListener(FTBHelper ftbhelper){
		plugin = ftbhelper;
	}
	
		@EventHandler(priority = EventPriority.HIGHEST)
		public void onInventoryClick(InventoryClickEvent ev){
			Player player = (Player)ev.getWhoClicked();
				if(ev.getCurrentItem() != null && ev.getCurrentItem().getTypeId() !=0){
					int item = ev.getCurrentItem().getTypeId();
					String data = ev.getCurrentItem().getData().toString();		
		//Getting Data Value
					int endIndex = data.indexOf("(");
					String replacement = "";
					String toBeReplaced = data.substring(0, endIndex + 1);
					String newData = data.replace(toBeReplaced, replacement);
					endIndex = data.indexOf(")");
					toBeReplaced = data.substring(endIndex);
					String finalData = newData.replace(toBeReplaced, replacement);		
					if((player.hasPermission("FTBHelper.ban."+item+"."+finalData) || player.hasPermission("FTBHelper.ban."+item+".*") || player.hasPermission("FTBHelper.invban."+item+".*") || player.hasPermission("FTBHelper.invban."+item+"."+finalData)) && !player.hasPermission("FTBHelper.bypassban") && CraftListener.craftban == false){
						CraftListener.craftban = false;
						player.sendMessage(ChatColor.DARK_RED+"Sorry, this item is banned.");
						if(plugin.getConfig().getBoolean("DeleteInvBanItem") == true){
							ev.setCurrentItem(null);
						}
						if(plugin.getConfig().getBoolean("DropInvBanItem") == true){
							ItemStack toDrop = ev.getCurrentItem();
							player.getWorld().dropItemNaturally(player.getLocation(), toDrop);
							ev.setCurrentItem(null);
						}
						ev.setCancelled(true);
						if(plugin.getConfig().getBoolean("BroadcastBanItem")){
							Bukkit.broadcastMessage(ChatColor.WHITE+"["+ChatColor.RED+"FTBHelper"+ChatColor.WHITE+"] "+ChatColor.RED+player.getName()+" has banned item: "+item+":"+finalData+" in their inv.");
						}
					}
				}
			}
		}