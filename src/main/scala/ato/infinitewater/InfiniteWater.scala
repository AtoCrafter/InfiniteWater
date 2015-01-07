package ato.infinitewater

import ato.infinitewater.block.BlockInfiniteWaterServer
import ato.infinitewater.item.ItemInfiniteWaterBucket
import ato.infinitewater.proxy.ProxyCommon
import ato.infinitewater.tileentity.TileEntityInfiniteWaterServer
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.registry.GameRegistry
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = "InfiniteWater", modLanguage = "scala")
object InfiniteWater {

  @SidedProxy(
    clientSide = "ato.infinitewater.proxy.ProxyClient",
    serverSide = "ato.infinitewater.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  val itemInfiniteBucket = new ItemInfiniteWaterBucket()

  val blockInfiniteWaterServer = new BlockInfiniteWaterServer()

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
    GameRegistry.registerItem(itemInfiniteBucket, "InfiniteWaterBucket")

    GameRegistry.registerBlock(blockInfiniteWaterServer, "InfiniteWaterServer")

    GameRegistry.registerTileEntity(classOf[TileEntityInfiniteWaterServer], "InfiniteWaterServer")
  }
}
