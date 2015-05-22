package dmfmm.StarvationAhoy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.Map;

/**
 * Made by mincrmatt12. Do not copy or you will have to face
 * our legal team (dmf444)
 */
public class GenericItemLoader {


    public Map<String, Item> items;

    public void addItem(String name, Class<? extends Item> item){
        try {
            items.put(name, item.newInstance());
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public void load(){


        for (String s : items.keySet()) {
            GameRegistry.registerItem(items.get(s), s);
        }

    }


}
