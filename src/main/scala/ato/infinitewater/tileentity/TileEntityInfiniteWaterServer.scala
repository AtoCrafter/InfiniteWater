package ato.infinitewater.tileentity

import net.minecraft.tileentity.TileEntity
import net.minecraftforge.fluids._

class TileEntityInfiniteWaterServer extends TileEntity with IFluidTank {

  val amount = 16000
  val infiniteWater = new FluidStack(FluidRegistry.WATER, amount)

  override def getFluid: FluidStack = infiniteWater

  override def drain(maxDrain: Int, doDrain: Boolean): FluidStack =
    new FluidStack(FluidRegistry.WATER, maxDrain)

  override def getFluidAmount: Int = amount

  override def getInfo: FluidTankInfo = new FluidTankInfo(infiniteWater, amount)

  override def getCapacity: Int = amount

  override def fill(resource: FluidStack, doFill: Boolean): Int = 0
}
