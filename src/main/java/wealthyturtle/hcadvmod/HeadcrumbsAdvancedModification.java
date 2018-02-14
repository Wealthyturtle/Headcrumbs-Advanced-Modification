package wealthyturtle.hcadvmod;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import wealthyturtle.hcadvmod.proxy.ClientProxy;
import wealthyturtle.hcadvmod.proxy.CommonProxy;

@Mod(modid = HeadcrumbsAdvancedModification.modid, version = HeadcrumbsAdvancedModification.version, dependencies = HeadcrumbsAdvancedModification.dependencies)
public class HeadcrumbsAdvancedModification {
	
	public static final String modid = "HeadcrumbsAdvancedModification";
	public static final String version = "1.0";
	public static final String dependencies = "required-before:headcrumbs;required-after:wanionlib";
	
	public static CommonProxy proxy;
	
	@Instance(modid)
	public static HeadcrumbsAdvancedModification instance;
	
	@EventHandler
	public void PreInit(FMLPreInitializationEvent preEvent) {
		ConfigHandler.init(preEvent.getSuggestedConfigurationFile());
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		HeadcrumbsHandler.addHeads(ConfigHandler.extracted_addedHeads);
		HeadcrumbsHandler.addTooltips(ConfigHandler.extracted_mapTooltips);
	}
	
	@EventHandler
	public void PostInit(FMLPostInitializationEvent postEvent) {
		
	}
}
