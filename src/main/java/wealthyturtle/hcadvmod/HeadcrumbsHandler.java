package wealthyturtle.hcadvmod;

import java.util.Map;

import ganymedes01.headcrumbs.Headcrumbs;
import wanion.lib.common.Util;

public class HeadcrumbsHandler {

	public static Class HeadcrumbsMap = ganymedes01.headcrumbs.libs.CelebrityMap.class;
	public static String HeadcrumbsMapField = "map";
	
	//Format for Each String Index: <Username>#<Tooltip>
	public static void addTooltips(String[] UsernamesAndTooltips){
		Map<String, String> HeadcrumbsExtractedMap = Util.getField(HeadcrumbsMap, HeadcrumbsMapField, null, Map.class); //WanionLib Reflection
		for(int i = 0; i < UsernamesAndTooltips.length; i++){
			int IndexOfHash = UsernamesAndTooltips[i].indexOf("#");
			String Username = UsernamesAndTooltips[i].substring(0, IndexOfHash);
			String Tooltip = UsernamesAndTooltips[i].substring(IndexOfHash+1, UsernamesAndTooltips[i].length());
			HeadcrumbsExtractedMap.put(Username, Tooltip);
			System.out.println("Inserted Username{\"" + Username + "\"} with Tooltip{\"" + Tooltip + "\"}!");
		}
	}
	
	//Format for Each String Index: <Username>
	public static void addHeads(String[] Usernames){
		for(int i = 0; i < Usernames.length; i++){
			Headcrumbs.modsent.add(Usernames[i]);
			System.out.println("Added Username{\"" + Usernames[i] + "\"}!");
		}
	}
}
