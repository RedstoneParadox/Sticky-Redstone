package io.github.redstoneparadox.stickyredstone.block.entity;

import io.github.redstoneparadox.stickyredstone.init.BlockEntitiesInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.util.math.BlockPos;

public class StickyRedstoneWireBlockEntity extends BlockEntity {
	// Faces
	private boolean northFace = false;
	private boolean westFace = false;
	private boolean southFace = false;
	private boolean eastFace = false;
	private boolean topFace = false;
	private boolean bottomFace = false;
	// Edges
	private boolean topNorthEdge = false;
	private boolean topWestEdge = false;
	private boolean topSouthEdge = false;
	private boolean topEastEdge = false;
	private boolean bottomNorthEdge = false;
	private boolean bottomWestEdge = false;
	private boolean bottomSouthEdge = false;
	private boolean bottomEastEdge = false;
	private boolean NorthWestEdge = false;
	private boolean SouthWestEdge = false;
	private boolean SouthEastEdge = false;
	private boolean NorthEastEdge = false;

	public StickyRedstoneWireBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntitiesInit.STICKY_REDSTONE_WIRE, pos, state);
	}
}
