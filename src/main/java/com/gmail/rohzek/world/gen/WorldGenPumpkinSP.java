package com.gmail.rohzek.world.gen;

import java.util.Random;

import com.gmail.rohzek.blocks.SPBlocks;
import com.gmail.rohzek.blocks.SPPumpkin;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenPumpkin;

public class WorldGenPumpkinSP extends WorldGenPumpkin
{
	@Override
	public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 64; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS && SPBlocks.PUMPKIN_SP.canPlaceBlockAt(worldIn, blockpos))
            {
                worldIn.setBlockState(blockpos, SPBlocks.PUMPKIN_SP.getDefaultState().withProperty(SPPumpkin.FACING, EnumFacing.Plane.HORIZONTAL.random(rand)), 2);
            }
        }

        return true;
    }
}
