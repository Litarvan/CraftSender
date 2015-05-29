package fr.theshark34.craftsender;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import fr.theshark34.craftsender.client.GuiCSRemote;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCSRemote extends Item {

    @SideOnly(Side.CLIENT)
    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        Minecraft.getMinecraft().displayGuiScreen(new GuiCSRemote());
        return itemStack;
    }

}
