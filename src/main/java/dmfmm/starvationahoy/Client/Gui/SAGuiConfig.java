package dmfmm.starvationahoy.Client.Gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.fml.client.config.GuiConfig;
import dmfmm.starvationahoy.Core.lib.ModInfo;
import dmfmm.starvationahoy.Core.util.ConfigHandler;



public class SAGuiConfig extends GuiConfig{
	public SAGuiConfig(GuiScreen guiscreen){
		super(guiscreen, new ConfigElement(ConfigHandler.config.getCategory("starvationahoy")).getChildElements(), ModInfo.MOD_ID, false, true, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}
}