package commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class Poll implements CommandExecutor{

	
private boolean PollActive = false;
private ArrayList<String> Voters = new ArrayList<String>();
private int yes;
private int no;
private boolean RecentTimePoll = false;
private boolean recentWeatherPoll = false;

	private FTBHelper plugin;
	public Poll(FTBHelper plugin){
		this.plugin = plugin;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(cmd.getName().equalsIgnoreCase("Poll")){
			if(sender instanceof Player){
				final Player player = (Player) sender;
				if(sender.hasPermission("FTBHelper.poll")){
					if(args.length == 2){
						if(args[0].equalsIgnoreCase("create")){
							if(args[1].equalsIgnoreCase("DayTime")){
								if(PollActive == false){
									PollActive = true;
									yes = 0;
									no = 0;
									Voters.clear();
									Bukkit.broadcastMessage(ChatColor.GOLD + ""+sender.getName()+" has started a new poll to set time to day! Do you agree with "+sender.getName()+"? Use /poll yes or /poll no to submit your answer!!! Hurry, poll only lasts 30 seconds xD");
									Voters.add(sender.getName());
									yes++;
									plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
										public void run() {
											Bukkit.broadcastMessage(ChatColor.GOLD+"Poll Finished, Results are in.");
											Bukkit.broadcastMessage(ChatColor.GOLD+"Yes: "+yes+" points.");
											Bukkit.broadcastMessage(ChatColor.GOLD+"No: "+no+" points");
											if(yes > no){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"Setting time to day!");	
												player.getWorld().setTime(0);
											}else if(yes == no){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"It was a tie.. Setting time to day!");	
												player.getWorld().setTime(0);
											}else if(no > yes){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"Time will stay as it is.");
											}
											PollActive = false;
										}
									}, 600L);
								}else{
									sender.sendMessage(ChatColor.DARK_RED+"There is a poll already in progress, please wait for that one to finish");
								}
							}else if(args[1].equalsIgnoreCase("ClearWeather")){
								if(PollActive == false){
									PollActive = true;
									yes = 0;
									no = 0;
									Voters.clear();
									Bukkit.broadcastMessage(ChatColor.GOLD + ""+sender.getName()+" has started a new poll to clear the weather! Do you agree with "+sender.getName()+"? Use /poll yes or /poll no to submit your answer!!! Hurry, poll only lasts 30 seconds xD ");
									Voters.add(sender.getName());
									yes++;
									plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
										public void run() {
											Bukkit.broadcastMessage(ChatColor.GOLD+"Poll Finished, Results are in.");
											Bukkit.broadcastMessage(ChatColor.GOLD+"Yes: "+yes+" points.");
											Bukkit.broadcastMessage(ChatColor.GOLD+"No: "+no+" points");
											if(yes > no){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"Clearing the weather!");	
												player.getWorld().setStorm(false);
											}else if(yes == no){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"It was a tie.. Clearing the weather!");
												player.getWorld().setStorm(false);
											}else if(no > yes){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"Weather will stay as it is.");
											}
											PollActive = false;
										}
									}, 600L);
								}else{
									sender.sendMessage(ChatColor.DARK_RED+"There is a poll already in progress, please wait for that one to finish");
								}
							}else if(args[1].equalsIgnoreCase("NightTime")){
								if(PollActive == false){
									PollActive = true;
									yes = 0;
									no = 0;
									Voters.clear();
									Bukkit.broadcastMessage(ChatColor.GOLD + ""+sender.getName()+" has started a new poll to set time to night! Do you agree with "+sender.getName()+"? Use /poll yes or /poll no to submit your awnser!!! Hurry, poll only lasts 30 seconds xD ");
									Voters.add(sender.getName());
									yes++;
									plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
										public void run() {
											Bukkit.broadcastMessage(ChatColor.GOLD+"Poll Finished, Results are in.");
											Bukkit.broadcastMessage(ChatColor.GOLD+"Yes: "+yes+" points.");
											Bukkit.broadcastMessage(ChatColor.GOLD+"No: "+no+" points");
											if(yes > no){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"Setting time to night!");	
												player.getWorld().setTime(14000);
											}else if(yes == no){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"It was a tie.. Setting time to night!");
												player.getWorld().setTime(14000);
											}else if(no > yes){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"Time will stay as it is.");
											}
											PollActive = false;
										}
									}, 600L);
								}else{
									sender.sendMessage(ChatColor.DARK_RED+"There is a poll already in progress, please wait for that one to finish");
								}
							}else if(args[1].equalsIgnoreCase("Storm")){
								if(PollActive == false){
									PollActive = true;
									yes = 0;
									no = 0;
									Voters.clear();
									Bukkit.broadcastMessage(ChatColor.GOLD + ""+sender.getName()+" has started a new poll to set time to start a storm! Do you agree with "+sender.getName()+"? Use /poll yes or /poll no to submit your awnser!!! Hurry, poll only lasts 30 seconds xD ");
									Voters.add(sender.getName());
									yes++;
									plugin.getServer().getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
										public void run() {
											Bukkit.broadcastMessage(ChatColor.GOLD+"Poll Finished, Results are in.");
											Bukkit.broadcastMessage(ChatColor.GOLD+"Yes: "+yes+" points.");
											Bukkit.broadcastMessage(ChatColor.GOLD+"No: "+no+" points");
											if(yes > no){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"Setting weather to stormy!");	
												player.getWorld().setStorm(true);
											}else if(yes == no){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"It was a tie.. Setting weather to stormy!");
												player.getWorld().setStorm(true);
											}else if(no > yes){
												Bukkit.broadcastMessage(" ");
												Bukkit.broadcastMessage(ChatColor.GOLD+"Weather will stay as it is.");
											}
											PollActive = false;
										}
									}, 600L);
								}else{
									sender.sendMessage(ChatColor.DARK_RED+"There is a poll already in progress, please wait for that one to finish");
								}
							}else{
								sender.sendMessage(ChatColor.DARK_RED+"Invalid PollType. Please use one of the following:");
								sender.sendMessage("DayTime, NightTime, ClearWeather, Storm");
							}
						}
					}else if(args.length == 1){
						if(args[0].equalsIgnoreCase("yes")){
							if(PollActive == true){
								if(!Voters.contains(player.getName())){
									yes++;
									Voters.add(player.getName());
									player.sendMessage(ChatColor.GREEN+"Vote Cast");
								}else{
									sender.sendMessage(ChatColor.DARK_RED+"You have already voted in this poll");
								}
							}else{
								sender.sendMessage(ChatColor.DARK_RED+"No poll is currently active");
							}
						}else if(args[0].equalsIgnoreCase("no")){
							if(PollActive == true){
								if(!Voters.contains(player.getName())){
									no++;
									Voters.add(player.getName());
									player.sendMessage(ChatColor.GREEN+"Vote Cast");
								}else{
									sender.sendMessage(ChatColor.DARK_RED+"You have already voted in this poll");
								}
							}else{
								sender.sendMessage(ChatColor.DARK_RED+"No poll is currently active");
							}
						}
					
					}else{
						sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
						sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version")+ " - By mike546378"+ChatColor.BLUE+"-----------");
						sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
						sender.sendMessage(ChatColor.GOLD+"Usage: "+ChatColor.WHITE+"/Poll create <PollType>");
						return true;
					}
				}else{sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to preform this action");return true;}
			}	
		return true;
		}
		return true;
	}
}