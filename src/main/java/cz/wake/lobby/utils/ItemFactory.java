package cz.wake.lobby.utils;

import net.minecraft.server.v1_11_R1.NBTTagCompound;
import net.minecraft.server.v1_11_R1.NBTTagList;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_11_R1.inventory.CraftItemStack;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ItemFactory {

    static final Logger log = LoggerFactory.getLogger(ItemFactory.class);

    public static ItemStack create(Material material, byte data, String displayName, String... lore) {
        try {
            ItemStack itemStack = new MaterialData(material, data).toItemStack(1);
            ItemMeta itemMeta = itemStack.getItemMeta();
            itemMeta.setDisplayName(displayName);
            if (lore != null) {
                List<String> finalLore = new ArrayList();
                for (String s : lore)
                    finalLore.add(s);
                itemMeta.setLore(finalLore);
            }
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            itemStack.setItemMeta(itemMeta);
            return itemStack;
        } catch (Exception e){
            log.error("", e);
        }
        return null;
    }

    public static ItemStack create(Material material, byte data, String displayName) {
        return create(material, data, displayName, null);
    }

    public static org.bukkit.inventory.ItemStack createHead(String name, String uuid, String textureData) {
        try {
            net.minecraft.server.v1_11_R1.ItemStack sHead = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.SKULL_ITEM, 1, (short) 3));

            NBTTagCompound tag = new NBTTagCompound();
            NBTTagCompound skullOwnerTag = new NBTTagCompound();
            NBTTagCompound displayTag = new NBTTagCompound();
            NBTTagCompound propertiesTag = new NBTTagCompound();

            NBTTagList tagList = new NBTTagList();

            NBTTagCompound valueTag = new NBTTagCompound();
            valueTag.setString("Value", textureData);

            tagList.add(valueTag);

            propertiesTag.set("textures", tagList);

            skullOwnerTag.setString("Id", uuid);
            skullOwnerTag.setString("Name", name);

            skullOwnerTag.set("Properties", propertiesTag);

            displayTag.setString("Name", name);

            tag.set("SkullOwner", skullOwnerTag);

            tag.set("display", displayTag);

            sHead.setTag(tag);
            return CraftItemStack.asBukkitCopy(sHead);
        } catch (Exception e){
            log.error("", e);
        }
        return null;
    }

    public static org.bukkit.inventory.ItemStack createHead(String name, String uuid, String textureData, String displayName, String... lore) {
        try {
            net.minecraft.server.v1_11_R1.ItemStack sHead = CraftItemStack.asNMSCopy(new org.bukkit.inventory.ItemStack(Material.SKULL_ITEM, 1, (short) 3));

            NBTTagCompound tag = new NBTTagCompound();
            NBTTagCompound skullOwnerTag = new NBTTagCompound();
            NBTTagCompound displayTag = new NBTTagCompound();
            NBTTagCompound propertiesTag = new NBTTagCompound();

            NBTTagList tagList = new NBTTagList();

            NBTTagCompound valueTag = new NBTTagCompound();
            valueTag.setString("Value", textureData);

            tagList.add(valueTag);

            propertiesTag.set("textures", tagList);

            skullOwnerTag.setString("Id", uuid);
            skullOwnerTag.setString("Name", name);

            skullOwnerTag.set("Properties", propertiesTag);

            displayTag.setString("Name", name);

            tag.set("SkullOwner", skullOwnerTag);

            tag.set("display", displayTag);

            sHead.setTag(tag);

            ItemStack item = CraftItemStack.asBukkitCopy(sHead);

            ItemMeta itemMeta = item.getItemMeta();
            itemMeta.setDisplayName(displayName);
            if (lore != null) {
                List<String> finalLore = new ArrayList();
                for (String s : lore)
                    finalLore.add(s);
                itemMeta.setLore(finalLore);
            }
            itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
            item.setItemMeta(itemMeta);

            return item;
        } catch (Exception e){
            log.error("", e);
        }
        return null;
    }

    public static ItemStack createColouredLeather(Material armourPart, int red, int green, int blue) {
        ItemStack itemStack = new ItemStack(armourPart);
        LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        leatherArmorMeta.setColor(Color.fromRGB(red, green, blue));
        itemStack.setItemMeta(leatherArmorMeta);
        return itemStack;
    }

    public static ItemStack addGlow(ItemStack item) {
        net.minecraft.server.v1_11_R1.ItemStack nmsStack = CraftItemStack.asNMSCopy(item);
        NBTTagCompound tag = null;
        if (!nmsStack.hasTag()) {
            tag = new NBTTagCompound();
            nmsStack.setTag(tag);
        }
        if (tag == null) tag = nmsStack.getTag();
        NBTTagList ench = new NBTTagList();
        tag.set("ench", ench);
        nmsStack.setTag(tag);
        return CraftItemStack.asCraftMirror(nmsStack);
    }
}