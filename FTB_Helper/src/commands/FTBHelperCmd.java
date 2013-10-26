package commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class FTBHelperCmd implements CommandExecutor{

	private FTBHelper plugin;
	public FTBHelperCmd(FTBHelper plugin){
		this.plugin = plugin;
	}
	//On use of the /FTBHelper command
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if(cmd.getName().equalsIgnoreCase("FTBHelper")) {

//On use of /FTBHelper ?
				if(args.length == 1 && args[0].equalsIgnoreCase("?")) {
							if(sender.hasPermission("FTBHelper.use")){
							sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
							sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"-----------");
							sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
							sender.sendMessage(ChatColor.GOLD + "/FTBHelper ?" + ChatColor.WHITE + ": Opens this help menu");
							if(sender.hasPermission("FTBHelper.halt.halt")){sender.sendMessage(ChatColor.GOLD + "/Halt <player>" + ChatColor.WHITE + ": Stopps a player from moving.");}
							if(sender.hasPermission("FTBHelper.halt.unhalt")){sender.sendMessage(ChatColor.GOLD + "/Unhalt <player>" + ChatColor.WHITE + ": Allows a player to move");}
							if(sender.hasPermission("FTBHelper.halt.list")){sender.sendMessage(ChatColor.GOLD + "/HaltList" + ChatColor.WHITE + ": Lists all halted players");}
							if(sender.hasPermission("FTBHelper.denylogin.denylogin")){sender.sendMessage(ChatColor.GOLD + "/DenyLogin <player>" + ChatColor.WHITE + ": Stops the player from logging in.");}
							if(sender.hasPermission("FTBHelper.denylogin.allowlogin")){sender.sendMessage(ChatColor.GOLD + "/AllowLogin" + ChatColor.WHITE + ": Allows a player to login");}
							if(sender.hasPermission("FTBHelper.denylogin.list")){sender.sendMessage(ChatColor.GOLD + "/DenyLoginList" + ChatColor.WHITE + ": Shows players currently not allowed to login.");}
							if(sender.hasPermission("FTBHelper.vote")){sender.sendMessage(ChatColor.GOLD + "/Vote" + ChatColor.WHITE + ": Displays links to vote.");}
							if(sender.hasPermission("FTBHelper.banneditems")){sender.sendMessage(ChatColor.GOLD + "/BannedItems" + ChatColor.WHITE + ": Displays a list of the servers BannedItems");}
							if(sender.hasPermission("FTBHelper.poll")){sender.sendMessage(ChatColor.GOLD + "/Poll" + ChatColor.WHITE + ": Allows a server poll to change stuff like time and weather");}
							if(sender.hasPermission("FTBHelper.IdFinder")){sender.sendMessage(ChatColor.GOLD + "/IdFinder" + ChatColor.WHITE + ": Tells you the id of any clicked block");}
							if(sender.hasPermission("FTBHelper.togglespawn")){sender.sendMessage(ChatColor.GOLD + "/ToggleSpawn" + ChatColor.WHITE + ": Toggles the spawning of mobs");}
							if(sender.hasPermission("FTBHelper.findentities")){sender.sendMessage(ChatColor.GOLD + "/FindEntities" + ChatColor.WHITE + ": Tells you what chunks contain the most entities");}
							if(sender.hasPermission("FTBHelper.reload")){sender.sendMessage(ChatColor.GOLD + "/FTBHelper reload" + ChatColor.WHITE + ": Reloads the configuration file");}

							return true;
						}else{
							sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
						}
					}else if(args.length == 1 && args[0].equalsIgnoreCase("reload")){
						if(sender.hasPermission("FTBHelper.reload")){
							sender.sendMessage("Reloading configs....");
							plugin.reloadConfig();
							sender.sendMessage(ChatColor.GREEN+"Reload Successful");
						}else{
							sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
						}
					}else{
						sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
						sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"-----------");
						sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
						sender.sendMessage(ChatColor.GOLD + "/FTBHelper ?"+ChatColor.WHITE+": List all avalible commands.");
						return true;
					}
				}
			return true;
		}
}
