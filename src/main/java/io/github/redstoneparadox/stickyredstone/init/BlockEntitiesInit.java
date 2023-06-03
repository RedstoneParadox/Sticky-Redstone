package io.github.redstoneparadox.stickyredstone.init;

import io.github.redstoneparadox.stickyredstone.StickyRedstone;
import io.github.redstoneparadox.stickyredstone.block.entity.StickyRedstoneWireBlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.quiltmc.qsl.block.entity.api.QuiltBlockEntityTypeBuilder;

public class BlockEntitiesInit {
	public static final BlockEntityType<StickyRedstoneWireBlockEntity> STICKY_REDSTONE_WIRE = Registry.register(
		Registries.BLOCK_ENTITY_TYPE,
		StickyRedstone.id("sticky_redstone"),
		QuiltBlockEntityTypeBuilder.create(StickyRedstoneWireBlockEntity::new, BlocksInit.STICKY_REDSTONE_WIRE).build()
	);
}
