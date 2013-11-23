package com.gmail.mike546378.FTBHelper;

import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;

import Update.Updater;
import FTBRestrict.onClickWithBannedItem;
import commands.DenyLogin;
import commands.Halt;
import commands.DenyLoginListener;


public class FTBHelper extends JavaPlugin {

private DenyLoginListener DenyLoginListener = new DenyLoginListener(this);
private commands.HaltListener HaltListener = new commands.HaltListener(this);
private FTBRestrict.CraftListener CraftListener = new FTBRestrict.CraftListener(this);
private FTBRestrict.ItemPickupListener ItemPickupListener = new FTBRestrict.ItemPickupListener(this);
private FTBRestrict.onClickWithBannedItem onClickWithBannedItem = new onClickWithBannedItem(this);
private FTBRestrict.InventoryListener InventoryListener = new FTBRestrict.InventoryListener(this);
private FTBRestrict.DropListener DropListener = new FTBRestrict.DropListener(this);
private commands.IdFinderListener IdFinderListener = new commands.IdFinderListener(this);
private ToggleSpawn.SpawnListener SpawnListener = new ToggleSpawn.SpawnListener(this);
private ItemLimiter.BlockPlaceListener LimiterBlockPlaceListener = new ItemLimiter.BlockPlaceListener(this);
private FTBRestrict.onInteract InteractListener = new FTBRestrict.onInteract(this);
private Update.LoginListener UpdateChecker = new Update.LoginListener(this);

//When the plugin loads
	@Override
	public void onEnable() {
		getLogger().info("Thank you for deciding to use " + getName() + " with your server, have fun ^_^");
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(this.DenyLoginListener, this);
		pm.registerEvents(this.HaltListener, this);
		pm.registerEvents(this.CraftListener, this);
		pm.registerEvents(this.ItemPickupListener, this);
		pm.registerEvents(this.onClickWithBannedItem, this);
		pm.registerEvents(this.InventoryListener, this);
		pm.registerEvents(this.DropListener, this);
		pm.registerEvents(this.IdFinderListener, this);
		pm.registerEvents(this.SpawnListener, this);
		pm.registerEvents(this.LimiterBlockPlaceListener, this);
		pm.registerEvents(this.InteractListener, this);
		pm.registerEvents(this.UpdateChecker, this);
		ToggleSpawn.dissableSpawnCmd.dissableSpawn = false;
		Updater updater = new Updater(this, 62312, this.getFile(), Updater.UpdateType.DEFAULT, false);
		new AutoSave.autosave(this).saveall();
		new Halt(this);
		new DenyLogin(this);
		this.getConfig().options().copyDefaults(true);
		this.saveConfig();
		commandhandler();
		this.getConfig().set("version", "1.5.0");
		this.saveConfig();
	}
	
//When the plugin unloads
	@Override
	public void onDisable() {
		getLogger().info("Farewell, hope to see you again soon ;)");
		
	}
	
	public void setExecutor(String command, CommandExecutor ce){
		Bukkit.getPluginCommand(command).setExecutor(ce);
	}
	public void commandhandler(){
		setExecutor("halt", new commands.Halt(this));
		setExecutor("unhalt", new commands.Halt(this));
		setExecutor("haltlist", new commands.Halt(this));
		setExecutor("denyloginlist", new commands.DenyLogin(this));
		setExecutor("denylogin", new commands.DenyLogin(this));
		setExecutor("allowlogin", new commands.DenyLogin(this));
		setExecutor("FTBHelper", new commands.FTBHelperCmd(this));
		setExecutor("Vote", new commands.Vote(this));
		setExecutor("BannedItems", new commands.BannedItems(this));
		setExecutor("Poll", new commands.Poll(this));
		setExecutor("IdFinder", new commands.IdFinder(this));
		setExecutor("ToggleSpawn", new ToggleSpawn.dissableSpawnCmd(this));
		setExecutor("FindEntities", new entityTracker.entityTracker(this));
		setExecutor("Debug", new commands.DebugCommand(this));
	}
}