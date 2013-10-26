package commands;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class Vote implements CommandExecutor{

	private FTBHelper plugin;
	public Vote(FTBHelper plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	if(cmd.getName().equalsIgnoreCase("Vote")){
		sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
		sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version")+ " - By mike546378"+ChatColor.BLUE+"-----------");
		sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
		List<?> links = plugin.getConfig().getList("VoteLinks");
		for(int x = 0; x < links.size(); x++){
			sender.sendMessage(""+ChatColor.GREEN+links.get(x));
		}
		return true;
	}
	return true;}
}
