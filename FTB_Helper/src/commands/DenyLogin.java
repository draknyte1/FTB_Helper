package commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.gmail.mike546378.FTBHelper.FTBHelper;

public class DenyLogin implements CommandExecutor{
	

	
	private FTBHelper plugin;
	public DenyLogin(FTBHelper plugin){
		this.plugin = plugin;
	}
	public static ArrayList<String> denylogin = new ArrayList<String>();
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	
//On use of /DenyLoginList
	if(cmd.getName().equalsIgnoreCase("DenyLoginList")){
		if(sender.hasPermission("ftbhelper.denylogin.list")){
			sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
			sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"-----------");
			sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
			sender.sendMessage(ChatColor.DARK_GREEN+"Players being denied login:");
			for(int x = 0; x < denylogin.size(); x++){
				sender.sendMessage(ChatColor.RED+denylogin.get(x));
			}
		}else{
			sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
		}
		return true;
	}

	
//On use of /AllowLogin
	if(cmd.getName().equalsIgnoreCase("AllowLogin")){
		if(args.length == 1) {
				if(sender.hasPermission("ftbhelper.denylogin.allowlogin")){
					if(denylogin.contains("CraftPlayer{name="+args[0]+"}")){
						denylogin.remove("CraftPlayer{name="+args[0]+"}");
						sender.sendMessage(ChatColor.GREEN+args[0]+" is now allowed to login.");
					}else{
						sender.sendMessage(ChatColor.DARK_RED+"PLayer not found.. use /DenyLoginlist to list all players currently not allowed to login");
					}
				}else{
					sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
				}
				return true;
			}else{
				sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
				sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper "+plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"-----------");
				sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
				sender.sendMessage(ChatColor.GOLD+"Usage:"+ChatColor.WHITE+" /AllowLogin <player>");
			}
	}
	
//On use of DenyLogin
	if(cmd.getName().equalsIgnoreCase("denylogin")){
		if(args.length == 1){
			if(sender.hasPermission("ftbhelper.denylogin.denylogin")){
				denylogin.add("CraftPlayer{name="+args[0]+"}");
				sender.sendMessage(ChatColor.GREEN+args[0]+" has now been denied login.");
			}else{
				sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
			}
			}else{
				sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
				sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper "+plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"-----------");
				sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
				sender.sendMessage(ChatColor.GOLD+"Usage:"+ChatColor.WHITE+" /DenyLogin <player>");
			}
		return true;
		}
		return true;
	}
	
}

