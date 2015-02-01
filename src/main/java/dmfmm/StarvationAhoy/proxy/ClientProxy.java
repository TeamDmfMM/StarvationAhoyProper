package dmfmm.StarvationAhoy.proxy;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.client.registry.ClientRegistry;
import dmfmm.StarvationAhoy.Client.Renderer.HoldingStickRenderer;
import dmfmm.StarvationAhoy.Client.Renderer.MeatHangerRenderer;
import dmfmm.StarvationAhoy.Client.Renderer.ModelChickenSA;
import dmfmm.StarvationAhoy.Client.Renderer.ModelCowSA;
import dmfmm.StarvationAhoy.Client.Renderer.ModelPigSA;
import dmfmm.StarvationAhoy.Client.Renderer.PigItemRenderer;
import dmfmm.StarvationAhoy.Meat.MeatType;
import dmfmm.StarvationAhoy.Meat.ModuleMeat;
import dmfmm.StarvationAhoy.Meat.Block.tileentity.HoldingStickTileEntity;
import dmfmm.StarvationAhoy.Meat.Block.tileentity.MeatHangerTileEntity;
import dmfmm.StarvationAhoy.Meat.item.MItemLoader;


public class ClientProxy extends CommonProxy{

	@Override
	public void registerKeyBindings() {
		
	}
	public void registerRenderers(){
		ClientRegistry.bindTileEntitySpecialRenderer(MeatHangerTileEntity.class, new MeatHangerRenderer());
		MinecraftForgeClient.registerItemRenderer(MItemLoader.deadPig, new PigItemRenderer());
		ClientRegistry.bindTileEntitySpecialRenderer(HoldingStickTileEntity.class, new HoldingStickRenderer());
		
		MeatType mt = new MeatType(1);
		mt.doMeatType(new ModelCowSA(), "minecraft:textures/entity/cow/cow.png", "starvationahoy:textures/entity/skinnedCow.png", "starvationahoy:textures/entity/rottenCow.png");
		ModuleMeat.registry.addMeatType(mt);
		mt = new MeatType(2);
		mt.doMeatType(new ModelPigSA(), "minecraft:textures/entity/pig/pig.png", "starvationahoy:textures/entity/skinnedPig.png", "starvationahoy:textures/entity/rottenPig.png");
		ModuleMeat.registry.addMeatType(mt);
		mt = new MeatType(3);
		mt.doMeatType(new ModelChickenSA(), "minecraft:textures/entity/chicken.png", "starvationahoy:textures/entity/skinnedChicken.png", "starvationahoy:textures/entity/rottenChicken.png");
		ModuleMeat.registry.addMeatType(mt);
	}


}
