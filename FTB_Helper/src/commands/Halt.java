package commands;

import java.util.ArrayList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import com.gmail.mike546378.FTBHelper.FTBHelper;

public class Halt implements CommandExecutor{
		
	private FTBHelper plugin;
	public Halt(FTBHelper plugin){
		this.plugin = plugin;
	}

//Variables
	public static ArrayList<String> halted = new ArrayList<String>();

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

//On use of the /HaltList
		if(cmd.getName().equalsIgnoreCase("Haltlist")) {
			if(sender.hasPermission("ftbhelper.halt.list")){
				sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
				sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version")+ " - By mike546378"+ChatColor.BLUE+"-----------");
				sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
				sender.sendMessage(ChatColor.DARK_GREEN+"Halted Players:");
				if(!halted.isEmpty()){
					for(int x = 0; x < halted.size() && x >= 0; x++){
						sender.sendMessage(ChatColor.RED+halted.get(x));
					}
				}
			}else{
				sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
			}
			return true;
		}
//On use of the /halt <player>
		if(cmd.getName().equalsIgnoreCase("Halt")){
			if(sender.hasPermission("ftbhelper.halt.halt")){
				if(args.length == 1){
					halted.add("CraftPlayer{name="+args[0]+"}");
					sender.sendMessage(ChatColor.GREEN+args[0]+" has now been halted.");
				}else{
					sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
					sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper "+plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"-----------");
					sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
					sender.sendMessage(ChatColor.GOLD+"Usage:"+ChatColor.WHITE+" /Halt <player>");
				}
			}else{
				sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
			}
			return true;
		}
			
//On use of the unhalt <player> arg
		if(cmd.getName().equalsIgnoreCase("Unhalt")){
			if(sender.hasPermission("ftbhelper.halt.unhalt")){
				if(args.length == 1){
					if(halted.contains("CraftPlayer{name="+args[0]+"}")){
						halted.remove("CraftPlayer{name="+args[0]+"}");
						sender.sendMessage(ChatColor.GREEN+args[0]+" has now been unhalted.");
					}else{
						sender.sendMessage(ChatColor.DARK_RED+"Player not found, use /HaltList to see all halted players");
					}
				}else{
					sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
					sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper "+plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"-----------");
					sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
					sender.sendMessage(ChatColor.GOLD+"Usage:"+ChatColor.WHITE+" /UnHalt <player>");
				}
			}else{
					sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");
			}
			return true;
		}
		return false;
	}
}