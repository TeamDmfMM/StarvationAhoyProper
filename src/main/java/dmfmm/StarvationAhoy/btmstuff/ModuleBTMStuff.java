package dmfmm.StarvationAhoy.btmstuff;

import dmfmm.StarvationAhoy.btmstuff.blocks.AutomaticRoaster;
import dmfmm.StarvationAhoy.btmstuff.blocks.SignBlock;
import dmfmm.StarvationAhoy.btmstuff.te.AutoRoasterTE;
import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.fml.common.registry.GameRegistry;

/**
 * Created by TeamDMFMM on 7/22/2016. Code originally written
 * for Starvatione Ahoy. Do not copy without permission,
 * because that is just mean. Code is VISIBLE SOURCE, therfore
 * credit us, just don't steal large portions of this.
 */
public class ModuleBTMStuff {

    static public ModuleBTMStuff instance = new ModuleBTMStuff();
    public static Block AutomaticRoaster;

    Block signblock;

    public void preinit() {
        signblock = new SignBlock();
        signblock.setRegistryName("starvationahoy", "signblock");

        AutomaticRoaster = new AutomaticRoaster();
    }

    public void init() {
        GameRegistry.register(signblock);
        GameRegistry.register(new ItemBlock(signblock).setRegistryName(signblock.getRegistryName()));

        GameRegistry.registerTileEntity(AutoRoasterTE.class, "ARTE");
    }

}
