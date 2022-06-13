package net.bells.eldencraft.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.Mth;
import net.minecraft.world.level.block.entity.StructureBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(StructureBlockEntity.class)
public class StructureBlockBypass {

    @Inject(at = @At(value = "HEAD"), method = "load")
    protected void load(CompoundTag pPTag, CallbackInfo info) {
        int i = Mth.clamp(pPTag.getInt("posX"), -480, 1000);
        int j = Mth.clamp(pPTag.getInt("posY"), -480, 1000);
        int k = Mth.clamp(pPTag.getInt("posZ"), -480, 1000);
        
        int l = Mth.clamp(pPTag.getInt("sizeX"), 0, 1000);
        int i1 = Mth.clamp(pPTag.getInt("sizeY"), 0, 1000);
        int j1 = Mth.clamp(pPTag.getInt("sizeZ"), 0, 1000);
    }
}
