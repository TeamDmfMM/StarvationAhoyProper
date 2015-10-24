package dmfmm.StarvationAhoy.Core;

import cpw.mods.fml.common.registry.GameRegistry;
import dmfmm.StarvationAhoy.Core.items.ItemLoad;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

/**
 * Created by David on 2015-08-03.
 */
public class CoreRecipies {

    public static void registerRecipies(){
        GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoad.stat_helm, new Object[] {"   ", "ihi", "rgr", 'i', "ingotIron", 'h', new ItemStack(Items.iron_helmet), 'r', "dustRedstone", 'g', "paneGlass"}));
        GameRegistry.addRecipe(new ShapedOreRecipe(ItemLoad.stat_chest, new Object[]{"bnb", "lcl", "lel", 'b', new ItemStack(Items.blaze_rod), 'n', "ingotBrickNether", 'l', new ItemStack(Items.leather), 'c', new ItemStack(Items.iron_chestplate), 'e', new ItemStack(Items.ender_eye)}));

    }


}