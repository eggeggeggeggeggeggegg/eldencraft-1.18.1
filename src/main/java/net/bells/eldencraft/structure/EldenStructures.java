package net.bells.eldencraft.structure;

import com.mojang.serialization.Codec;
import com.sun.jna.Structure;
import net.bells.eldencraft.EldenCraft;
import net.minecraft.world.level.levelgen.feature.StructureFeature;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class EldenStructures {

    public static final DeferredRegister<StructureFeature<?>> DEFERRED_REGISTRY_STRUCTURE =
            DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, EldenCraft.MOD_ID);

    public static final RegistryObject<StructureFeature<?>> DIVINE_TOWER =
            DEFERRED_REGISTRY_STRUCTURE.register("divine_tower", TowerStructure::new);


    public static void register(IEventBus eventBus) {
        DEFERRED_REGISTRY_STRUCTURE.register(eventBus);
    }
}