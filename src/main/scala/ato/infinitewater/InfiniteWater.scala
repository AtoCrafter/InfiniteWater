package ato.infinitewater

import ato.infinitewater.proxy.ProxyCommon
import cpw.mods.fml.common.Mod.EventHandler
import cpw.mods.fml.common.event.FMLPreInitializationEvent
import cpw.mods.fml.common.{Mod, SidedProxy}

@Mod(modid = "InfiniteWater", modLanguage = "scala")
object InfiniteWater {

  @SidedProxy(
    clientSide = "ato.infinitewater.proxy.ProxyClient",
    serverSide = "ato.infinitewater.proxy.ProxyCommon"
  )
  var proxy: ProxyCommon = _

  @EventHandler
  def preInit(event: FMLPreInitializationEvent) {
  }
}
