package ato.infinitewater.item

import net.minecraft.creativetab.CreativeTabs
import net.minecraft.entity.player.EntityPlayer
import net.minecraft.init.Blocks
import net.minecraft.item.{Item, ItemStack}
import net.minecraft.world.World
import net.minecraftforge.common.util.ForgeDirection

class ItemInfiniteWaterBucket extends Item {

  setCreativeTab(CreativeTabs.tabMaterials)
  setTextureName("bucket_water")
  setUnlocalizedName("InfiniteWaterBucket")

  override def hasEffect(par1ItemStack: ItemStack, pass: Int): Boolean = true

  override def onItemUse(itemstack: ItemStack, player: EntityPlayer, world: World, x: Int, y: Int, z: Int, side: Int, fx: Float, fy: Float, yz: Float): Boolean = {
    val dir = ForgeDirection.getOrientation(side)
    val (tx, ty, tz) = (x + dir.offsetX, y + dir.offsetY, z + dir.offsetZ)
    if (world.isAirBlock(tx, ty, tz)) {
      world.setBlock(tx, ty, tz, Blocks.water)
      world.notifyBlockOfNeighborChange(tx, ty, tz, Blocks.air)
    }
    true
  }
}
