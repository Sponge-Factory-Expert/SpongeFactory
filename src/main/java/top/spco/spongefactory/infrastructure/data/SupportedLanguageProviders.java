/*
 * Copyright 2024 SpCo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package top.spco.spongefactory.infrastructure.data;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import top.spco.spongefactory.SpongeFactory;
import top.spco.spongefactory.infrastructure.*;
import top.spco.spongefactory.infrastructure.quest.QuestContent;
import top.spco.spongefactory.item.DustItem;
import top.spco.spongefactory.item.IngotItem;
import top.spco.spongefactory.quest.SFQuests;
import top.spco.spongefactory.registries.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Provides supported language providers for generating language files.
 * This class initializes separate language providers for {@link ChineseProvider Chinese} and {@link EnglishProvider English} .
 * Each provider generates language files for the respective language.
 *
 * @author SpCo
 * @version 0.1.0
 * @since 0.1.0
 */
public class SupportedLanguageProviders {
    public final LanguageProvider chinese;
    public final LanguageProvider english;
    private final Set<Translatable> translatableSet = new HashSet<>();
    public SupportedLanguageProviders(DataGenerator generator) {
        SFQuests.init();
        addMetalDerivatives(SFItems.SOURCE_STEEL_INGOT);
        translatableSet.add(translate("Infinity","无限","tooltip.infinity"));
        translatableSet.add(translate("Start Sponge Factory!","开始Sponge Factory！","spongefactory.advancements.main.root.title"));
        translatableSet.add(translate("Prepare for the next challenge","为接下来的挑战做好准备","spongefactory.advancements.main.root.description"));
        translatableSet.add(translate("Turn Treasure into Trash","变宝为废","spongefactory.advancements.main.sponge_storage_cell.title"));
        translatableSet.add(translate("Disassemble a Sponge Storage Cell into two sponges","把一个海绵存储元件拆卸成两块海绵","spongefactory.advancements.main.sponge_storage_cell.description"));
        chinese = new ChineseProvider(generator);
        english = new EnglishProvider(generator);
    }

    public class ChineseProvider extends LanguageProvider {
        public ChineseProvider(DataGenerator gen) {
            super(gen, SpongeFactory.MOD_ID, "zh_cn");
        }

        @Override
        protected void addTranslations() {
            for (Translatable translatable : translatableSet) {
                add(translatable.getTranslationKey(), translatable.getChineseName());
            }
            for (ItemMapping<?> item : SFItems.ITEMS) {
                if (item.isBlockItem()) {
                    continue;
                }
                add(item.getTranslationKey(), item.getChineseName());
                if (item.hasDerivative()) {
                    for (ItemDerivative derivative : item.getDerivatives()) {
                        add(derivative.getTranslationKey(), derivative.getChineseName());
                    }
                }
            }
            for (ItemMapping<DustItem> dustItem : SFItems.DUST_ITEM) {
                add(dustItem.getTranslationKey(), dustItem.getChineseName());
            }
            for (ItemMapping<IngotItem> item : SFItems.INGOT_ITEM) {
                add(item.getTranslationKey(), item.getChineseName());
            }
            for (BlockMapping<?> block : SFBlocks.BLOCKS) {
                add(block.getTranslationKey(), block.getChineseName());
            }
            for (CreativeModeTabMapping tabs : SFCreativeModTabs.TABS) {
                add(tabs.getTranslationKey(), tabs.getChineseName());
            }
            for (QuestContent questContents : SFQuests.QUESTS) {
                add(questContents.getTranslationKey(), questContents.getChineseName());
            }
            for (GasMapping gas : SFGases.GASES) {
                add(gas.getTranslationKey(), gas.getChineseName());
            }
            for (ContainerMapping<?> container : SFContainerTypes.CONTAINERS) {
                add(container.getTranslationKey(), container.getChineseName());
            }
            for (SFMachineDescription description : SFMachineDescription.DESCRIPTIONS) {
                add(description.getTranslationKey(), description.getChineseName());
            }
            for (FluidMapping fluid : SFFluids.FLUIDS) {
                add(fluid.getTranslationKey(), fluid.getChineseName());
            }
            for (InfuseTypeMapping infuseType : SFInfuseTypes.INFUSE_TYPES) {
                add(infuseType.getTranslationKey(), infuseType.getChineseName());
            }
        }
    }

    public class EnglishProvider extends LanguageProvider {
        public EnglishProvider(DataGenerator gen) {
            super(gen, SpongeFactory.MOD_ID, "en_us");
        }

        @Override
        protected void addTranslations() {
            for (Translatable translatable : translatableSet) {
                add(translatable.getTranslationKey(), translatable.getEnglishName());
            }
            for (ItemMapping<?> item : SFItems.ITEMS) {
                if (item.isBlockItem()) {
                    continue;
                }
                add(item.getTranslationKey(), item.getEnglishName());
                if (item.hasDerivative()) {
                    for (ItemDerivative derivative : item.getDerivatives()) {
                        add(derivative.getTranslationKey(), derivative.getEnglishName());
                    }
                }
            }
            for (ItemMapping<DustItem> dustItem : SFItems.DUST_ITEM) {
                add(dustItem.getTranslationKey(), dustItem.getEnglishName());
            }
            for (ItemMapping<IngotItem> item : SFItems.INGOT_ITEM) {
                add(item.getTranslationKey(), item.getEnglishName());
            }
            for (BlockMapping<?> block : SFBlocks.BLOCKS) {
                add(block.getTranslationKey(), block.getEnglishName());
            }
            for (CreativeModeTabMapping tab : SFCreativeModTabs.TABS) {
                add(tab.getTranslationKey(), tab.getEnglishName());
            }
            for (QuestContent questContent : SFQuests.QUESTS) {
                add(questContent.getTranslationKey(), questContent.getEnglishName());
            }
            for (GasMapping gas : SFGases.GASES) {
                add(gas.getTranslationKey(), gas.getEnglishName());
            }
            for (ContainerMapping<?> container : SFContainerTypes.CONTAINERS) {
                add(container.getTranslationKey(), container.getEnglishName());
            }
            for (SFMachineDescription description : SFMachineDescription.DESCRIPTIONS) {
                add(description.getTranslationKey(), description.getEnglishName());
            }
            for (FluidMapping fluid : SFFluids.FLUIDS) {
                add(fluid.getTranslationKey(), fluid.getEnglishName());
            }
            for (InfuseTypeMapping infuseType : SFInfuseTypes.INFUSE_TYPES) {
                add(infuseType.getTranslationKey(), infuseType.getEnglishName());
            }
        }
    }

    private static void addMetalDerivatives(ItemMapping<?> base) {
        base.addDerivative(new ItemDerivative("Source Steel Plate", "魔源钢板", "item.spongefactory.source_steel" + "_plate"));
        base.addDerivative(new ItemDerivative("Source Steel Dust", "魔源钢粉", "item.spongefactory.source_steel" + "_dust"));
        base.addDerivative(new ItemDerivative("Source Steel Coin", "魔源钢币", "item.spongefactory.source_steel" + "_coin"));
        base.addDerivative(new ItemDerivative("Source Steel Gear", "魔源钢齿轮", "item.spongefactory.source_steel" + "_gear"));
    }

    private static Translatable translate(String englishName, String chineseName, String key) {
        return new Translatable(englishName, chineseName, key) {
        };
    }
}