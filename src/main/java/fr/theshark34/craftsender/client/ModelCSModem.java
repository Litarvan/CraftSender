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

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelCSModem extends ModelBase {

    private ModelRenderer pipe;
    private ModelRenderer Shape1;
    private ModelRenderer Shape2;

    public ModelCSModem() {
        textureWidth = 32;
        textureHeight = 32;

        pipe = new ModelRenderer(this, 0, 16);
        pipe.addBox(-1F, 0F, -1F, 2, 6, 2);
        pipe.setRotationPoint(0F, 11F, -1F);
        pipe.setTextureSize(32, 32);
        pipe.mirror = true;
        setRotation(pipe, 0.148353F, 0F, 0F);
        Shape1 = new ModelRenderer(this, 0, 0);
        Shape1.addBox(0F, 0F, 0F, 4, 4, 2);
        Shape1.setRotationPoint(-2F, 14F, 4F);
        Shape1.setTextureSize(32, 32);
        Shape1.mirror = true;
        setRotation(Shape1, 0F, 0F, 0F);
        Shape2 = new ModelRenderer(this, 0, 7);
        Shape2.addBox(0F, 0F, 0F, 2, 2, 6);
        Shape2.setRotationPoint(-1F, 15F, -1F);
        Shape2.setTextureSize(32, 32);
        Shape2.mirror = true;
        setRotation(Shape2, 0F, 0F, 0F);
    }

    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
        super.render(entity, f, f1, f2, f3, f4, f5);
        setRotationAngles(f, f1, f2, f3, f4, f5, entity);
        pipe.render(f5);
        Shape1.render(f5);
        Shape2.render(f5);
    }

    private void setRotation(ModelRenderer model, float x, float y, float z) {
        model.rotateAngleX = x;
        model.rotateAngleY = y;
        model.rotateAngleZ = z;
    }

    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {
        super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    }


}