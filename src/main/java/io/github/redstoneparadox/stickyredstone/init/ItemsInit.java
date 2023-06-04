package io.github.redstoneparadox.stickyredstone.init;

import io.github.redstoneparadox.stickyredstone.StickyRedstone;
import io.github.redstoneparadox.stickyredstone.item.StickyRedstoneWireItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class ItemsInit {
	public static final Item STICKY_REDSTONE_WIRE = register(
		"sticky_redstone_wire",
		new StickyRedstoneWireItem(
			BlocksInit.STICKY_REDSTONE_WIRE,
			new Item.Settings()
		)
	);

	private static Item register(String path, Item item) {
		Registry.register(Registries.ITEM, StickyRedstone.id(path), item);
		return item;
	}
}
