package io.github.redstoneparadox.stickyredstone.client.render;

import io.github.redstoneparadox.stickyredstone.block.entity.StickyRedstoneWireBlockEntity;
import net.fabricmc.fabric.api.renderer.v1.mesh.QuadEmitter;
import net.fabricmc.fabric.api.renderer.v1.model.FabricBakedModel;
import net.fabricmc.fabric.api.renderer.v1.render.RenderContext;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.texture.Sprite;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.random.RandomGenerator;
import net.minecraft.world.BlockRenderView;
import org.jetbrains.annotations.Nullable;
import org.joml.Vector3f;

import java.util.List;
import java.util.function.Supplier;

public class StickyRedstoneWireBakedModel implements BakedModel, FabricBakedModel {
	@Override
	public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction face, RandomGenerator random) {
		return null;
	}

	@Override
	public boolean useAmbientOcclusion() {
		return false;
	}

	@Override
	public boolean hasDepth() {
		return false;
	}

	@Override
	public boolean isSideLit() {
		return false;
	}

	@Override
	public boolean isBuiltin() {
		return false;
	}

	@Override
	public Sprite getParticleSprite() {
		return null;
	}

	@Override
	public ModelTransformation getTransformation() {
		return null;
	}

	@Override
	public ModelOverrideList getOverrides() {
		return null;
	}

	@Override
	public boolean isVanillaAdapter() {
		return false;
	}

	@Override
	public void emitBlockQuads(BlockRenderView blockView, BlockState state, BlockPos pos, Supplier<RandomGenerator> randomSupplier, RenderContext context) {
		StickyRedstoneWireBlockEntity blockEntity;
		QuadEmitter emitter = context.getEmitter();

		if (blockView.getBlockEntity(pos) instanceof StickyRedstoneWireBlockEntity) blockEntity = (StickyRedstoneWireBlockEntity) blockView.getBlockEntity(pos);
		else return;

		generateFace(
			blockEntity,
			emitter,
			0,
			new Vector3f[]{
				new Vector3f(0, 0, 0),
				new Vector3f(1, 0, 0),
				new Vector3f(1, 0, 1),
				new Vector3f(0, 0, 1)
			},
			Direction.SOUTH
		);
		generateFace(
			blockEntity,
			emitter,
			4,
			new Vector3f[]{
				new Vector3f(0, 0, 0),
				new Vector3f(1, 0, 0),
				new Vector3f(1, 0, 1),
				new Vector3f(0, 0, 1)
			},
			Direction.WEST
		);
	}

	private void generateFace(StickyRedstoneWireBlockEntity blockEntity, QuadEmitter emitter, int startVertex, Vector3f[] coordinates, Direction normalDirection) {
		for (int index = 0; index < 4; index++) {
			emitter.pos(startVertex + index, coordinates[index]);
			emitter.normal(startVertex + index, normalDirection.getUnitVector());
		}
	}

	@Override
	public void emitItemQuads(ItemStack stack, Supplier<RandomGenerator> randomSupplier, RenderContext context) {

	}
}
