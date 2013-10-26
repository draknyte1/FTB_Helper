package entityTracker;

import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.gmail.mike546378.FTBHelper.FTBHelper;

public class entityTracker implements CommandExecutor{
		 
	private FTBHelper plugin;
	public entityTracker(FTBHelper plugin){
		this.plugin = plugin;
	}
	
	public static void bubble_srt( int a[], int n, String a2[]){
		int i, j,t=0;
		String p;
			for(i = 0; i < n; i++){
				for(j = 1; j < (n-i); j++){
					if(a[j-1] < a[j]){
						t = a[j-1];
						a[j-1]=a[j];
						a[j]=t;
						p = a2[j-1];
						a2[j-1]=a2[j];
						a2[j]=p;
					}
				}
			}
	  }
	String[] ChunkInfo;
	int[] EntityCount;
	int tempCount;
	int tempCount2;
	String tempData;
	String tempData2;
	//On use of the command
		public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
			if(cmd.getName().equalsIgnoreCase("FindEntities")) {
				if(sender.hasPermission("FTBHelper.findentities")){
					Player player = (Player)sender;
					Chunk[] Chunks = player.getWorld().getLoadedChunks();
					EntityCount = new int[Chunks.length];
					ChunkInfo = new String[Chunks.length];
					for(int x = 0;x < Chunks.length; x++){
						ChunkInfo[x] = "X:"+Chunks[x].getX() * 16+", Z:"+Chunks[x].getZ() * 16+" Entities:"+Chunks[x].getEntities().length;
						EntityCount[x] = Chunks[x].getEntities().length;
					}
					bubble_srt(EntityCount, EntityCount.length, ChunkInfo);
					sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
					sender.sendMessage(ChatColor.BLUE+"-----------"+ChatColor.AQUA+ "FTBHelper " + plugin.getConfig().getString("version") + " - By mike546378"+ChatColor.BLUE+"-----------");
					sender.sendMessage(ChatColor.BLUE+"-------------------------------------------------");
					sender.sendMessage(ChatColor.GREEN+"Top "+plugin.getConfig().getInt("No_Results-FindEntities")+" chunks with the most entities:");
					for(int x = 0;x <= plugin.getConfig().getInt("No_Results-FindEntities") -1;x++){
						sender.sendMessage(ChatColor.WHITE+""+(x+1)+". "+ChatColor.RED+""+ChunkInfo[x]);
					}
				}else{sender.sendMessage(ChatColor.DARK_RED+"You do not have sufficent permissions to perform this action.");}
			}
			return true;
		}
}
