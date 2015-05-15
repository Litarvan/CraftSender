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

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCSModem extends TileEntity {

    private int channel;
    private String name;

    @Override
    public void writeToNBT(NBTTagCompound par1) {
        super.writeToNBT(par1);

        par1.setInteger("channel", channel);
        par1.setString("name", name);
    }

    @Override
    public void readFromNBT(NBTTagCompound par1) {
        super.readFromNBT(par1);

        channel = par1.getInteger("channel");
        name = par1.getString("name");
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChannel() {
        return this.channel;
    }

    public String getName() {
        return this.name;
    }

}
