package net.frostytrix.tutorialmod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.frostytrix.tutorialmod.TutorialModTest;
import net.frostytrix.tutorialmod.item.ModItems;
import net.frostytrix.tutorialmod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = TutorialModTest.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.MALICIEUX.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

            // Level 1
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 16),
                    new ItemStack(ModItems.FOUR_LEAVES_CLOVER.get(), 2),
                    new ItemStack(ModItems.GUINNESS_SEEDS.get(), 1),
                    10, 8, 0.02f));
        }
    }
}
