package commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class BannedItems implements CommandExecutor{
	private FTBHelper plugin;
	public BannedItems(FTBHelper plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if(cmd.getName().equalsIgnoreCase("BannedItems")){
		if(sender.hasPermission("FTBHelper.banneditems")){
			sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
			sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version")+ " - By mike546378"+ChatColor.BLUE+"-----------");
			sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
			List<?> links = plugin.getConfig().getList("BannedItems");
			for(int x = 0; x < links.size(); x++){
				sender.sendMessage(""+ChatColor.RED+links.get(x));
			}
		}else{
			sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
		}
		return true;
	}
	return true;}
}