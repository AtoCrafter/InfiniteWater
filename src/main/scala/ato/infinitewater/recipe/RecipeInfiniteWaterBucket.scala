package ato.infinitewater.recipe

import ato.infinitewater.InfiniteWater
import net.minecraft.enchantment.{Enchantment, EnchantmentHelper}
import net.minecraft.init.Items
import net.minecraft.inventory.InventoryCrafting
import net.minecraft.item.crafting.IRecipe
import net.minecraft.item.{ItemEnchantedBook, ItemStack}
import net.minecraft.world.World

class RecipeInfiniteWaterBucket extends IRecipe {

  val output = new ItemStack(InfiniteWater.itemInfiniteBucket)
  val infinity = new ItemStack(Items.book)
  infinity.addEnchantment(Enchantment.infinity, 1)

  override def matches(crafting: InventoryCrafting, world: World): Boolean = {
    var craftingList: List[ItemStack] = Nil
    for (i <- 0 to crafting.getSizeInventory - 1) {
      val item = crafting.getStackInSlot(i)
      if (item != null) {
        craftingList ::= item
      }
    }
    val list = craftingList
    if (list.size != 2) return false
    val test = list.map(EnchantmentHelper.getEnchantmentLevel(Enchantment.infinity.effectId, _))
    if (!list.exists((i: ItemStack) => i.getItem == Items.water_bucket)) return false
    if (!list.exists(isInfinityBook(_))) return false
    return true
  }

  override def getRecipeOutput: ItemStack = output

  override def getRecipeSize: Int = 2

  override def getCraftingResult(crafting: InventoryCrafting): ItemStack = output.copy()

  private def isInfinityBook(itemstack: ItemStack): Boolean = {
    if (itemstack.getItem != Items.enchanted_book) return false
    val book = itemstack.getItem.asInstanceOf[ItemEnchantedBook]
    val stored = book.func_92110_g(itemstack)
    for (i <- 0 to stored.tagCount() - 1) {
      val tag = stored.getCompoundTagAt(i)
      if (tag.getShort("id") == Enchantment.infinity.effectId && tag.getShort("lvl") > 0) return true
    }
    false
  }
}
