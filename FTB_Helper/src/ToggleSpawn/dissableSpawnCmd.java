package ToggleSpawn;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class dissableSpawnCmd implements CommandExecutor{
	public FTBHelper plugin;
	
	public dissableSpawnCmd(FTBHelper ftbhelper){
		plugin = ftbhelper;
	}
	
public static boolean dissableSpawn;
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("ToggleSpawn")){
			if(sender.hasPermission("FTBHelper.togglespawn")){
				if(dissableSpawn == true){
					dissableSpawn = false;
					Bukkit.broadcastMessage(ChatColor.AQUA+sender.getName()+" has enabled mob spawning");
				}else if(dissableSpawn == false){
					dissableSpawn = true;
					Bukkit.broadcastMessage(ChatColor.AQUA+sender.getName()+" has dissabled mob spawning");
				}
			}
		}
		return true;
	}
}
