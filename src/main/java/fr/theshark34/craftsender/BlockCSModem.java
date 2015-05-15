package fr.theshark34.craftsender;

import fr.theshark34.craftsender.client.TileEntityCSModem;
import net.minecraft.block.Block;
import net.minecraft.block.BlockChest;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockCSModem extends Block {

    public BlockCSModem(Material material) {
        super(material);
    }

    @Override
    public boolean canPlaceBlockAt(World world, int x, int y, int z) {
        return world.getBlock(x - 1, y, z) instanceof BlockChest ||
               world.getBlock(x + 1, y, z) instanceof BlockChest ||
               world.getBlock(x, y, z - 1) instanceof BlockChest ||
               world.getBlock(x, y, z + 1) instanceof BlockChest;
    }

    @Override
    public int onBlockPlaced(World world, int x, int y, int z, int p_149660_5_, float p_149660_6_, float p_149660_7_, float p_149660_8_, int p_149660_9_) {
        int j1 = p_149660_9_;

        if(p_149660_5_ == 2 && world.getBlock(x, y, z + 1) instanceof BlockChest)
            j1 = 3;
        if(p_149660_5_ == 3 && world.getBlock(x, y, z - 1) instanceof BlockChest)
            j1 = 2;
        if(p_149660_5_ == 4 && world.getBlock(x + 1, y, z) instanceof BlockChest)
            j1 = 1;
        if(p_149660_5_ == 5 && world.getBlock(x - 1, y, z) instanceof BlockChest)
            j1 = 0;

        if(j1 == 0)
            if(world.getBlock(x, y, z + 1) instanceof BlockChest)
                j1 = 3;
            else if(world.getBlock(x, y, z - 1) instanceof BlockChest)
                j1 = 2;
            else if(world.getBlock(x + 1, y, z) instanceof BlockChest)
                j1 = 1;
            else if(world.getBlock(x - 1, y, z) instanceof BlockChest)
                j1 = 0;

        return j1;
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        this.checkForDestroy(world, x, y, z);
    }

    @Override
    public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
        if(this.checkForDestroy(world, x, y, z)) {
            int l = world.getBlockMetadata(x, y, z);
            boolean flag = false;

            if(!(world.getBlock(x - 1, y, z) instanceof BlockChest) && l == 0)
                flag = true;
            if(!(world.getBlock(x + 1, y, z) instanceof BlockChest) && l == 1)
                flag = true;
            if(!(world.getBlock(x, y, z - 1) instanceof BlockChest) && l == 2)
                flag = true;
            if(!(world.getBlock(x, y, z + 1) instanceof BlockChest) && l == 3)
                flag = true;

            if(flag) {
                this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                world.setBlockToAir(x, y, z);
            }
        }
    }

    protected boolean checkForDestroy(World world, int x, int y, int z) {
        if(!this.canPlaceBlockAt(world, x, y, z)) {
            if(world.getBlock(x, y, z) == this) {
                this.dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
                world.setBlockToAir(x, y, z);
            }

            return false;
        } else
            return true;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public boolean renderAsNormalBlock() {
        return false;
    }

    @Override
    public int getRenderType() {
        return -1;
    }

    @Override
    public boolean hasTileEntity(int metadata) {
        return true;
    }

    @Override
    public TileEntity createTileEntity(World world, int metadata) {
        return new TileEntityCSModem();
    }

}
