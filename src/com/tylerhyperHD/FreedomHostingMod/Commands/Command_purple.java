/*
 * Copyright 2015 tylerhyperHD
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tylerhyperHD.FreedomHostingMod.Commands;

import com.tylerhyperHD.FreedomHostingMod.F_Debug;
import com.tylerhyperHD.FreedomHostingMod.F_Log;
import com.tylerhyperHD.FreedomHostingMod.FreedomHostingMod;
import java.util.Arrays;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Command_purple extends C_Command implements CommandExecutor {


    private final FreedomHostingMod plugin;

    public Command_purple(FreedomHostingMod plugin) {
        this.plugin = plugin;
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String string, String[] args) {
        if (!(sender instanceof Player)) {
            senderMsg("You must be a player to execute this command.", sender);
            return true;
        }
        
        Player sender_p = (Player) sender;
        
        if (F_Debug.isDebugOn()) {
            F_Log.info("Server ran command purple successfully");
        }

        if (!sender.getName().equals("tylerhyperHD")) {
            sender_p.sendMessage(ChatColor.RED + "Only Tyler may use this command.\nNo permissions for the people who aren't purple.");
            sender_p.setHealth(0.0);
            return true;
        }
        if (args.length == 0) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                World world = player.getWorld();
                Location loc = player.getLocation();
                for (int i = 0; i <= 100; i++) {
                    utilityAction(sender_p.getName(), "Gracing the world with purple!", false);
                    world.strikeLightningEffect(loc);
                }
                PlayerInventory inv = player.getInventory();
                ItemStack CamWool = new ItemStack(Material.WOOL, 1, (short) 10);
                ItemStack CamBow = new ItemStack(Material.BOW, 1);
                ItemStack CamSword = new ItemStack(Material.GOLD_SWORD, 1);
                ItemStack CamArrow = new ItemStack(Material.ARROW, 1);
                ItemStack CamChest = new ItemStack(Material.LEATHER_CHESTPLATE, 1);
                ItemStack CamLegs = new ItemStack(Material.LEATHER_LEGGINGS, 1);
                ItemStack CamBoots = new ItemStack(Material.LEATHER_BOOTS, 1);

                for (Enchantment ench : Enchantment.values()) {
                    if (ench.equals(Enchantment.LOOT_BONUS_MOBS) || ench.equals(Enchantment.LOOT_BONUS_BLOCKS)) {
                        continue;
                    }
                    CamWool.addUnsafeEnchantment(ench, 32767);
                    CamBow.addUnsafeEnchantment(ench, 32767);
                    CamSword.addUnsafeEnchantment(ench, 32767);
                    CamArrow.addUnsafeEnchantment(ench, 32767);
                    CamChest.addUnsafeEnchantment(ench, 32767);
                    CamLegs.addUnsafeEnchantment(ench, 32767);
                    CamBoots.addUnsafeEnchantment(ench, 32767);
                }
                ItemMeta wool = CamWool.getItemMeta();
                ItemMeta bow = CamBow.getItemMeta();
                ItemMeta sword = CamSword.getItemMeta();
                ItemMeta arrow = CamArrow.getItemMeta();
                LeatherArmorMeta chest = (LeatherArmorMeta) CamChest.getItemMeta();
                LeatherArmorMeta legs = (LeatherArmorMeta) CamLegs.getItemMeta();
                LeatherArmorMeta boots = (LeatherArmorMeta) CamBoots.getItemMeta();
                wool.setDisplayName(ChatColor.YELLOW + "Purple Aura");
                bow.setDisplayName(ChatColor.DARK_AQUA + "The Purple Shot");
                sword.setDisplayName(ChatColor.DARK_GREEN + "The Purple Blade");
                arrow.setDisplayName(ChatColor.DARK_PURPLE + "Purple Arrow");
                chest.setDisplayName(ChatColor.YELLOW + "Purple Chestplate");
                legs.setDisplayName(ChatColor.YELLOW + "Purple Leggings");
                boots.setDisplayName(ChatColor.YELLOW + "Purple Boots");
                Object lorewool = Arrays.asList(new String[]{
                    ChatColor.BLUE + "This aura should protect", ChatColor.BLUE + "you from all possible harm."
                });
                Object lorebow = Arrays.asList(new String[]{
                    ChatColor.BLUE + "Legend has it, this bow", ChatColor.BLUE + "can only shoot purple arrows!"
                });
                Object loresword = Arrays.asList(new String[]{
                    ChatColor.BLUE + "The purple has the power", ChatColor.BLUE + "to wield this legendary blade!"
                });
                Object lorearrow = Arrays.asList(new String[]{
                    ChatColor.BLUE + "This arrow has a mysterious", ChatColor.BLUE + "purple aura around it..."
                });
                Object lorechestplate = Arrays.asList(new String[]{
                    ChatColor.BLUE + "This chestplate should protect", ChatColor.BLUE + "you from all possible harm."
                });
                Object loreleggings = Arrays.asList(new String[]{
                    ChatColor.BLUE + "These leggings should protect", ChatColor.BLUE + "you from all possible harm."
                });
                Object loreboots = Arrays.asList(new String[]{
                    ChatColor.BLUE + "These boots should protect", ChatColor.BLUE + "you from all possible harm."
                });
                wool.setLore((List) lorewool);
                bow.setLore((List) lorebow);
                sword.setLore((List) loresword);
                arrow.setLore((List) lorearrow);
                chest.setLore((List) lorechestplate);
                legs.setLore((List) loreleggings);
                boots.setLore((List) loreboots);
                chest.setColor(Color.fromRGB(125, 20, 240));
                legs.setColor(Color.fromRGB(125, 20, 240));
                boots.setColor(Color.fromRGB(125, 20, 240));
                CamWool.setItemMeta(wool);
                CamBow.setItemMeta(bow);
                CamSword.setItemMeta(sword);
                CamArrow.setItemMeta(arrow);
                CamChest.setItemMeta(chest);
                CamLegs.setItemMeta(legs);
                CamBoots.setItemMeta(boots);
                // This method sees if the player already has the item, if so, it doesn't add it again
                if (inv.contains(CamBow)) {
                    continue;
                } else {
                    inv.addItem(CamBow);
                }
                if (inv.contains(CamSword)) {
                    continue;
                } else {
                    inv.addItem(CamSword);
                }
                if (inv.contains(CamArrow)) {
                    continue;
                } else {
                    inv.addItem(CamArrow);
                }
                inv.setHelmet(CamWool);
                inv.setChestplate(CamChest);
                inv.setLeggings(CamLegs);
                inv.setBoots(CamBoots);
                world.strikeLightningEffect(loc);
            }
        }
        return true;
    }
}
