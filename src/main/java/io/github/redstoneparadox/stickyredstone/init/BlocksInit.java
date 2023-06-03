package io.github.redstoneparadox.stickyredstone.init;

import io.github.redstoneparadox.stickyredstone.StickyRedstone;
import io.github.redstoneparadox.stickyredstone.block.StickyRedstoneWireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.quiltmc.qsl.block.extensions.api.QuiltBlockSettings;

public class BlocksInit {
	public static final Block STICKY_REDSTONE_WIRE = register(
		"sticky_redstone",
		new StickyRedstoneWireBlock(QuiltBlockSettings.copyOf(Blocks.REDSTONE_WIRE))
	);

	public static Block register(String path, Block block) {
		Registry.register(Registries.BLOCK, StickyRedstone.id(path), block);
		return block;
	}
}
