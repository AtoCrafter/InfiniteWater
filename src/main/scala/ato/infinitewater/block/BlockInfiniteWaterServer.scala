package ato.infinitewater.block

import ato.infinitewater.tileentity.TileEntityInfiniteWaterServer
import net.minecraft.block.BlockContainer
import net.minecraft.block.material.Material
import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.tileentity.TileEntity
import net.minecraft.world.World
import net.minecraftforge.fluids.{FluidContainerRegistry, FluidRegistry, FluidStack}

class BlockInfiniteWaterServer extends BlockContainer(Material.glass) {

  setBlockName("InfiniteWaterServer")
  setCreativeTab(CreativeTabs.tabBlock)
  setBlockTextureName("water_still")

  override def onBlockActivated(world: World, x: Int, y: Int, z: Int, player: EntityPlayer, meta: Int, fx: Float, fy: Float, fz: Float): Boolean = {
    val itemstack = player.getCurrentEquippedItem
    if (FluidContainerRegistry.isContainer(itemstack)) {
      val fluid = FluidContainerRegistry.getFluidForFilledItem(itemstack)
      if (fluid == null || fluid.getFluid == FluidRegistry.WATER) {
        val filled = FluidContainerRegistry.fillFluidContainer(new FluidStack(FluidRegistry.WATER, 1000), itemstack)
        itemstack.stackSize -= 1
        if (itemstack.stackSize <= 0) {
          player.inventory.setInventorySlotContents(player.inventory.currentItem, null)
        }
        if (!player.inventory.addItemStackToInventory(filled.copy)) {
          player.entityDropItem(filled.copy, 1)
        }
        player.inventory.markDirty()
        return true
      }
    }
    false
  }

  override def createNewTileEntity(world: World, meta: Int): TileEntity =
    new TileEntityInfiniteWaterServer()
}
