package com.ccxia.firstmod.creativetab;
import com.ccxia.firstmod.item.ItemLoader;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
public class CreativeTabsRedo extends CreativeTabs
{
    public static CreativeTabsRedo tabRedo = new CreativeTabsRedo();
    public CreativeTabsRedo()
    {
        super("redo");
    }
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemLoader.items[0]);
    }
}
