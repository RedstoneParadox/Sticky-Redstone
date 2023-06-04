package io.github.redstoneparadox.stickyredstone.block.entity;

import io.github.redstoneparadox.stickyredstone.init.BlockEntitiesInit;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

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
	private boolean northWestEdge = false;
	private boolean southWestEdge = false;
	private boolean southEastEdge = false;
	private boolean northEastEdge = false;

	public StickyRedstoneWireBlockEntity(BlockPos pos, BlockState state) {
		super(BlockEntitiesInit.STICKY_REDSTONE_WIRE, pos, state);
	}

	public static boolean connectsToOther(StickyRedstoneWireBlockEntity source, Direction direction, StickyRedstoneWireBlockEntity target) {
		source.fixEdgesAndFaces();
		target.fixEdgesAndFaces();

		switch (direction) {
			case DOWN -> {
				return ((source.bottomNorthEdge && target.topNorthEdge)
					|| (source.bottomSouthEdge && target.topSouthEdge)
					|| (source.bottomEastEdge && target.topEastEdge)
					|| (source.bottomWestEdge && target.topWestEdge));
			}
			case UP -> {
				return (source.topNorthEdge && target.bottomNorthEdge)
					|| (source.topSouthEdge && target.bottomSouthEdge)
					|| (source.topEastEdge && target.bottomEastEdge)
					|| (source.topWestEdge && target.bottomWestEdge);
			}
			case NORTH -> {
				return (source.topNorthEdge && target.topSouthEdge)
					|| (source.bottomNorthEdge && target.bottomSouthEdge)
					|| (source.northEastEdge && target.southEastEdge)
					|| (source.northWestEdge && target.southWestEdge);
			}
			case SOUTH -> {
				return (source.topSouthEdge && target.topNorthEdge)
					|| (source.bottomSouthEdge && target.bottomNorthEdge)
					|| (source.southEastEdge && target.northEastEdge)
					|| (source.southWestEdge && target.northWestEdge);
			}
			case WEST -> {
				return (source.topWestEdge && target.topEastEdge)
					|| (source.bottomWestEdge && target.topEastEdge)
					|| (source.northWestEdge && target.northEastEdge)
					|| (source.southWestEdge && target.southEastEdge);
			}
			case EAST -> {
				return (target.topWestEdge && source.topEastEdge)
					|| (target.bottomWestEdge && source.topEastEdge)
					|| (target.northWestEdge && source.northEastEdge)
					|| (target.southWestEdge && source.southEastEdge);
			}
		}

		return false;
	}

	@Override
	public void readNbt(NbtCompound nbt) {
		super.readNbt(nbt);
		// Faces
		northFace = nbt.getBoolean("northFace");
		westFace = nbt.getBoolean("westFace");
		southFace = nbt.getBoolean("southFace");
		eastFace = nbt.getBoolean("eastFace");
		topFace = nbt.getBoolean("topFace");
		bottomFace = nbt.getBoolean("bottomFace");
		// Top Edges
		topNorthEdge = nbt.getBoolean("topNorthEdge");
		topEastEdge = nbt.getBoolean("topEastEdge");
		topSouthEdge = nbt.getBoolean("topSouthEdge");
		topWestEdge = nbt.getBoolean("topWestEdge");
		// Bottom Edges
		bottomNorthEdge = nbt.getBoolean("bottomNorthEdge");
		bottomEastEdge = nbt.getBoolean("bottomEastEdge");
		bottomSouthEdge = nbt.getBoolean("bottomSouthEdge");
		bottomWestEdge = nbt.getBoolean("bottomWestEdge");
		// Side Edges
		northEastEdge = nbt.getBoolean("NorthEastEdge");
		southEastEdge = nbt.getBoolean("SouthEastEdge");
		southWestEdge = nbt.getBoolean("SouthWestEdge");
		northWestEdge = nbt.getBoolean("NorthWestEdge");

		fixEdgesAndFaces();
	}

	@Override
	protected void writeNbt(NbtCompound nbt) {
		super.writeNbt(nbt);
		fixEdgesAndFaces();
		// Faces
		nbt.putBoolean("northFace", northFace);
		nbt.putBoolean("westFace", westFace);
		nbt.putBoolean("southFace", southFace);
		nbt.putBoolean("eastFace", eastFace);
		nbt.putBoolean("topFace", topFace);
		nbt.putBoolean("bottomFace", bottomFace);
		// Top Edges
		nbt.putBoolean("topNorthEdge", topNorthEdge);
		nbt.putBoolean("topEastEdge", topSouthEdge);
		nbt.putBoolean("topSouthEdge", topEastEdge);
		nbt.putBoolean("topWestEdge", topWestEdge);
		// Bottom Edges
		nbt.putBoolean("bottomNorthEdge", bottomNorthEdge);
		nbt.putBoolean("bottomEastEdge", bottomSouthEdge);
		nbt.putBoolean("bottomSouthEdge", bottomEastEdge);
		nbt.putBoolean("bottomWestEdge", bottomWestEdge);
		// Side Edges
		nbt.putBoolean("northEastEdge", northEastEdge);
		nbt.putBoolean("southEastEdge", southEastEdge);
		nbt.putBoolean("southWestEdge", southWestEdge);
		nbt.putBoolean("northWestEdge", northWestEdge);
	}

	private void fixEdgesAndFaces() {
		assert world != null;
		if (!world.getBlockState(pos.up()).isSideSolidFullSquare(world, pos.up(), Direction.DOWN)) topFace = false;
		if (!world.getBlockState(pos.down()).isSideSolidFullSquare(world, pos.down(), Direction.UP)) bottomFace = false;
		if (!world.getBlockState(pos.north()).isSideSolidFullSquare(world, pos.north(), Direction.SOUTH)) northFace = false;
		if (!world.getBlockState(pos.south()).isSideSolidFullSquare(world, pos.south(), Direction.NORTH)) southFace = false;
		if (!world.getBlockState(pos.east()).isSideSolidFullSquare(world, pos.east(), Direction.WEST)) eastFace = false;
		if (!world.getBlockState(pos.west()).isSideSolidFullSquare(world, pos.west(), Direction.EAST)) westFace = false;

		// Top Edges
		if (northFace && topFace) topEastEdge = true;
		if (eastFace && topFace) topEastEdge = true;
		if (southFace && topFace) topWestEdge = true;
		if (westFace && topFace) topWestEdge = true;
		// Bottom Edges
		if (northFace && bottomFace) bottomEastEdge = true;
		if (eastFace && bottomFace) bottomEastEdge = true;
		if (southFace && bottomFace) bottomWestEdge = true;
		if (westFace && bottomFace) bottomWestEdge = true;
		// Side Edges
		if (northFace && eastFace) northEastEdge = true;
		if (eastFace && southFace) southEastEdge = true;
		if (southFace && westFace) southWestEdge = true;
		if (westFace && northFace) northWestEdge = true;
	}
}
