/*
 * Copyright 2015 TheShark34
 *
 * This file is part of CraftSender.
 * CraftSender is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * CraftSender is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with CraftSender.  If not, see <http://www.gnu.org/licenses/>.
 */
package fr.theshark34.craftsender.client;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class CSModemSpecialRenderer extends TileEntitySpecialRenderer {

    private final ModelCSModem model;

    public CSModemSpecialRenderer() {
        this.model = new ModelCSModem();
    }

    Tessellator tes = Tessellator.instance;

    @Override
    public void renderTileEntityAt(TileEntity te, double x, double y, double z, float scale) {
        GL11.glPushMatrix(); {
            GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);

            ResourceLocation textures = new ResourceLocation("craftsender", "textures/model/cs_modem.png");
            Minecraft.getMinecraft().renderEngine.bindTexture(textures);

            GL11.glPushMatrix(); {
                GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);

                int meta = te.getBlockMetadata();
                switch(meta) {
                    case 0:
                        GL11.glRotatef(90F, 0.0F, 1.0F, 0.0F);
                        break;
                    case 1:
                        GL11.glRotatef(-90F, 0.0F, 1.0F, 0.0F);
                        break;
                    case 2:
                        GL11.glRotatef(180F, 0.0F, 1.0F, 0.0F);
                        break;
                }

                GL11.glTranslatef(0.0F, 0.0F, 0.20F);
                this.model.render(null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
            } GL11.glPopMatrix();
        } GL11.glPopMatrix();
    }

}
