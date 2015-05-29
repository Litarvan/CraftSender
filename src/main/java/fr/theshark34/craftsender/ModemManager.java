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
package fr.theshark34.craftsender;

import fr.theshark34.craftsender.client.TileEntityCSModem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.ArrayList;

public class ModemManager {

    private static ArrayList<Location> modems = new ArrayList<Location>();

    public static void addModem(TileEntityCSModem modem) {
        modems.add(new Location(modem.xCoord, modem.yCoord, modem.zCoord));
    }

    public static TileEntityCSModem getModem(World world, int x, int y, int z) {
        for(int i = 0; i < modems.size(); i++) {
            Location loc = modems.get(i);
            if (loc.getX() == x && loc.getY() == y && loc.getZ() == z) {
                Location modem = modems.get(i);
                TileEntity te = world.getTileEntity(modem.getX(), modem.getY(), modem.getZ());

                if(te instanceof TileEntityCSModem)
                    return (TileEntityCSModem) te;
                else
                    return null;
            }
        }

        return null;
    }

    public static void deleteModem(TileEntityCSModem modem) {
        for(int i = 0; i < modems.size(); i++) {
            Location loc = modems.get(i);
            if (loc.getX() == modem.xCoord && loc.getY() == modem.yCoord && loc.getZ() == modem.zCoord)
                modems.remove(i);
        }

    }

}
