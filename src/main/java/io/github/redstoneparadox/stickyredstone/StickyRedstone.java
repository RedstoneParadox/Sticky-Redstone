package io.github.redstoneparadox.stickyredstone;

import net.minecraft.util.Identifier;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;

public class StickyRedstone implements ModInitializer {
	@Override
	public void onInitialize(ModContainer mod) {
		System.out.println("Hello world!");
	}

	public static Identifier id(String path) {
		return new Identifier("sticky_redstone", path);
	}
}
