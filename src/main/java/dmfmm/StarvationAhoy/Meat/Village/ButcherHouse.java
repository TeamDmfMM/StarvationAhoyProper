package dmfmm.StarvationAhoy.Meat.Village;

import java.util.List;
import java.util.Random;

import dmfmm.StarvationAhoy.Core.util.SALog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieces;
import net.minecraft.world.gen.structure.StructureVillagePieces.Start;

public class ButcherHouse extends StructureVillagePieces.Village {
    
	private int grdlvl =-1;
    
	public ButcherHouse(){}
	
	public ButcherHouse(Start villagePiece, int par2, Random par3Random, StructureBoundingBox sbb, int coordBaseMode) { 
         super(); 
         this.coordBaseMode = coordBaseMode; 
         this.boundingBox = sbb; 
     } 

	 public static ButcherHouse buildComponent(Start villagePiece, List pieces, Random random, int x, int y, int z, int coordBaseMode, int p5) { 
		         StructureBoundingBox box = StructureBoundingBox.getComponentToAddBoundingBox(x, y, z, 0, 0, 0, 10, 7, 12, coordBaseMode); 
		          return canVillageGoDeeper(box) && StructureComponent.findIntersecting(pieces, box) == null ? new ButcherHouse(villagePiece, p5, random, box, coordBaseMode) : null; 
		      } 

	
	@Override
	public boolean addComponentParts(World world, Random rand, StructureBoundingBox sbb) {
        if (this.grdlvl < 0) {
            this.grdlvl = this.getAverageGroundLevel(world, sbb);

            if (this.grdlvl < 0)
                return true;

            this.boundingBox.offset(0, this.grdlvl - this.boundingBox.maxY + 4, 0);//6
        }
       // int x = this.boundingBox.minX;
       // int y = this.boundingBox.minY;
       // int z = this.boundingBox.minZ;
        
        //Clear Everything
		fillWithBlocks(world, sbb, 0, 0, 0, 9, 7, 11, Blocks.air, Blocks.air, false); 
		
		//Place Floor
		fillWithBlocks(world, sbb, 0, 0, 7, 8, 0, 11, Blocks.grass, Blocks.grass, false);
		fillWithBlocks(world, sbb, 0, 0, 0, 8, 0, 6, Blocks.cobblestone, Blocks.cobblestone, false);
		
		//Fence & Torches
		fillWithBlocks(world, sbb, 0, 1, 7, 0, 1, 11, Blocks.fence, Blocks.fence, false);
		this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 0, 2, 11, sbb);
		fillWithBlocks(world, sbb, 8, 1, 7, 8, 1, 11, Blocks.fence, Blocks.fence, false);
		this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 8, 2, 11, sbb);
		fillWithBlocks(world, sbb, 1, 1, 11, 7, 1, 11, Blocks.fence, Blocks.fence, false);
			//Middle Torch/Fence
		fillWithBlocks(world,sbb, 4, 1, 7, 4, 1, 11, Blocks.fence, Blocks.fence, false);
		this.placeBlockAtCurrentPosition(world, Blocks.torch, 0, 4, 2, 11, sbb);
		
		//Wall @ Pen
		fillWithBlocks(world, sbb, 1, 1, 6, 2, 3, 6, Blocks.cobblestone, Blocks.cobblestone, false);
		fillWithBlocks(world, sbb, 6, 1, 6, 7, 3, 6, Blocks.cobblestone, Blocks.cobblestone, false);
		fillWithBlocks(world, sbb, 4, 1, 6, 4, 3, 6, Blocks.cobblestone, Blocks.cobblestone, false);
		this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 3, 3, 6, sbb);
		this.placeBlockAtCurrentPosition(world, Blocks.cobblestone, 0, 5, 3, 6, sbb);
		this.placeDoorAtCurrentPosition(world, sbb, rand, 5, 1, 6, 0);
		this.placeDoorAtCurrentPosition(world, sbb, rand, 3, 1, 6, 0);
		
		//Wooden Log Corners
		fillWithBlocks(world, sbb, 0, 1, 6, 0, 3, 6, Blocks.log, Blocks.log, false);
		fillWithBlocks(world, sbb, 8, 1, 6, 8, 3, 6, Blocks.log, Blocks.log, false);
		fillWithBlocks(world, sbb, 0, 1, 0, 0, 3, 0, Blocks.log, Blocks.log, false);
		fillWithBlocks(world, sbb, 8, 1, 0, 8, 3, 0, Blocks.log, Blocks.log, false);
		
		//Solid Walls
		fillWithBlocks(world, sbb, 0, 1, 1, 0, 3, 5, Blocks.brick_block, Blocks.brick_block, false);
		fillWithBlocks(world, sbb, 1, 1, 0, 7, 3, 0, Blocks.brick_block, Blocks.brick_block, false);
		
		//Exit/Entrance Wall
		fillWithBlocks(world, sbb, 8, 1, 1, 8, 3, 2, Blocks.brick_block, Blocks.brick_block, false);
		fillWithBlocks(world, sbb, 8, 1, 4, 8, 3, 5, Blocks.brick_block, Blocks.brick_block, false);
		this.placeBlockAtCurrentPosition(world, Blocks.brick_block, 0, 8, 3, 3, sbb);
		int entryStair = getMetadataWithOffset(Blocks.stone_stairs, 1);
		this.placeBlockAtCurrentPosition(world, Blocks.stone_stairs, entryStair, 9, 0, 3, sbb);
		this.placeDoorAtCurrentPosition(world, sbb, rand, 8, 1, 3, 0);
		
		//ROOF
		fillWithBlocks(world, sbb, 0, 6, 3, 8, 6, 3, Blocks.planks, Blocks.planks, false);
		int FSS = getMetadataWithOffset(Blocks.stone_stairs, 2);
		int SSS = getMetadataWithOffset(Blocks.stone_stairs, 3);
		for (int i = 0; i <= 8; i++){
			//To Pen
			this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, FSS, i, 6, 4, sbb);
			this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, FSS, i, 5, 5, sbb);
			this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, FSS, i, 4, 6, sbb);
			//Out Side
			this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, SSS, i, 6, 2, sbb);
			this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, SSS, i, 5, 1, sbb);
			this.placeBlockAtCurrentPosition(world, Blocks.oak_stairs, SSS, i, 4, 0, sbb);
			
		}
		fillWithBlocks(world, sbb, 0, 4, 1, 0, 4, 5, Blocks.planks, Blocks.planks, false);
		fillWithBlocks(world, sbb, 8, 4, 1, 8, 4, 5, Blocks.planks, Blocks.planks, false);
		this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 0, 5, 2, sbb);
		this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 0, 5, 3, sbb);
		this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 0, 5, 4, sbb);
		
		this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 8, 5, 2, sbb);
		this.placeBlockAtCurrentPosition(world, Blocks.glass_pane, 0, 8, 5, 3, sbb);
		this.placeBlockAtCurrentPosition(world, Blocks.planks, 0, 8, 5, 4, sbb);
		
		
		//Animals
		Random randss = new Random();
		int randomNum = randss.nextInt((3 - 1) + 1) + 1;
		int randomNum1 = randss.nextInt((3 - 1) + 1) + 1;
		
		 int j1 = this.getXWithOffset(2 + 1, 9);
         int k1 = this.getYWithOffset(1);
         int l1 = this.getZWithOffset(2 + 1, 9);
         int j2 = this.getXWithOffset(2 + 1, 6);
         int l2 = this.getZWithOffset(2 + 1, 6);
		SALog.error(randomNum);
		if(randomNum == 1){
			Entity cow = new EntityCow(world);
			cow.setPosition(j1, k1, l1);
			world.spawnEntityInWorld(cow);
		} else if(randomNum == 2){
			Entity pig = new EntityPig(world);
			pig.setPosition(j1, k1, l1);
			world.spawnEntityInWorld(pig);
		} else if(randomNum == 3){
			Entity chicken = new EntityChicken(world);
			chicken.setPosition(j1, k1, l1);
			world.spawnEntityInWorld(chicken);
		}
		if(randomNum1 == 1){
			Entity cow = new EntityCow(world);
			cow.setPosition(j2, k1, l2);
			world.spawnEntityInWorld(cow);
		} else if(randomNum1 == 2){
			Entity pig = new EntityPig(world);
			pig.setPosition(j2, k1, l2);
			world.spawnEntityInWorld(pig);
		} else if(randomNum1 == 3){
			Entity chicken = new EntityChicken(world);
			chicken.setPosition(j2, k1, l2);
			world.spawnEntityInWorld(chicken);
		}
		return true;
	}
	
}
