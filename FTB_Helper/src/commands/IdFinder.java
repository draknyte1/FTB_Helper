package commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class IdFinder implements CommandExecutor{
	public static ArrayList<String> active = new ArrayList<String>();
	 
	@SuppressWarnings({ "unused" })
	private FTBHelper plugin;
	public IdFinder(FTBHelper plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("IdFinder")){
			if(sender.hasPermission("FTBHelper.IdFinder")){
				if(active.contains(sender.getName())){
					active.remove(sender.getName());
					sender.sendMessage("IdFinder deactivated");
					return true;
				}else{
					active.add(sender.getName());
					sender.sendMessage("IdFinder activated");
					return true;
				}
			}
		}
		return true;
	}
}
