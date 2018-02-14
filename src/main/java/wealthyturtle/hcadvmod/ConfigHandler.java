package wealthyturtle.hcadvmod;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
	
	public static Configuration config;

	// Categories
	public static String addedHeads = "Custom Added Heads";
	public static String mapTooltips = "Custom Mapped Tooltips";
	
	// Defaults
	private static String[] default_addedHeads = {
			"Wealthyturtle",
			"WanionCane",
			"RCXCrafter"
	};
	private static String[] default_mapTooltips = {
			"Wealthyturtle#Author of Universal: Interdimensional Escape",
			"Wanioncane#Singularity Team Member",
			"RCXCrafter#Singularity Team Member"
	};
	
	// Extracted
	public static String[] extracted_addedHeads;
	public static String[] extracted_mapTooltips;
	
	// Config Generation
	public static void init(File file) {
		config = new Configuration(file);
		syncConfig();
	}
	
	public static void syncConfig() {
		config.setCategoryComment(addedHeads, "Fill in this Section of the Config First with Usernames to be Added into the Game as Headcrumb Heads. \nExamples have Already been Provided Below.");
		extracted_addedHeads = config.getStringList("extracted_addedHeads", addedHeads, default_addedHeads, "Syntax: <Username>");
		config.setCategoryComment(mapTooltips, "Fill in this Section of the Config After Filling in the addedHeads Section with Usernames and their Respective Tooltips that are to be Added into the Game as Headcrumb Heads. \nExamples have Already been Provided Below.");
		extracted_mapTooltips = config.getStringList("extracted_mapTooltips", mapTooltips, default_mapTooltips, "Syntax: <Username>#<Tooltip>");
		if(config.hasChanged()){
			config.save();
		}
	}
}
