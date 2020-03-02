package studio.trc.bukkit.crazyauctionsplus.utils;

import studio.trc.bukkit.crazyauctionsplus.utils.enums.ShopType;
import studio.trc.bukkit.crazyauctionsplus.utils.FileManager.*;
import studio.trc.bukkit.crazyauctionsplus.database.GlobalMarket;

import org.bukkit.entity.Player;

import java.util.ArrayList;

public class CrazyAuctions {
    
    private static final CrazyAuctions instance = new CrazyAuctions();
    
    public static CrazyAuctions getInstance() {
        return instance;
    }
    
    public Boolean isSellingEnabled() {
        return Files.CONFIG.getFile().getBoolean("Settings.Feature-Toggle.Selling");
    }
    
    public Boolean isBiddingEnabled() {
        return Files.CONFIG.getFile().getBoolean("Settings.Feature-Toggle.Bidding");
    }
    
    public Boolean isBuyingEnabled() {
        return Files.CONFIG.getFile().getBoolean("Settings.Feature-Toggle.Buying");
    }
    
    public int getNumberOfPlayerItems(Player player, ShopType type) {
        int number = 0;
        GlobalMarket market = GlobalMarket.getMarket();
        if (market.getItems().isEmpty()) return number;
        switch (type) {
            case SELL: {
                for (MarketGoods mg : market.getItems()) {
                    if (mg.getItemOwner().getUUID().equals(player.getUniqueId())) {
                        if (mg.getShopType().equals(ShopType.SELL)) {
                            number++;
                        }
                    }
                }
                return number;
            }
            case BUY: {
                for (MarketGoods mg : market.getItems()) {
                    if (mg.getItemOwner().getUUID().equals(player.getUniqueId())) {
                        if (mg.getShopType().equals(ShopType.BUY)) {
                            number++;
                        }
                    }
                }
                return number;
            }
            case BID: {
                for (MarketGoods mg : market.getItems()) {
                    if (mg.getItemOwner().getUUID().equals(player.getUniqueId())) {
                        if (mg.getShopType().equals(ShopType.BID)) {
                            number++;
                        }
                    }
                }
                return number;
            }
        }
        return number;
    }
    
    public ArrayList<MarketGoods> getMarketItems(Player player) {
//        ProtectedConfiguration data = Files.DATA.getFile();
        ArrayList<MarketGoods> items = new ArrayList();
        GlobalMarket market = GlobalMarket.getMarket();
        if (!market.getItems().isEmpty()) {
            for (MarketGoods mg : market.getItems()) {
                if (mg.getItemOwner().getUUID().equals(player.getUniqueId())) {
                    items.add(mg);
                }
            }
        }
//        if (data.contains("Items")) {
//            for (String i : data.getConfigurationSection("Items").getKeys(false)) {
//                if (data.get("Items." + i + ".Owner") != null ? data.getString("Items." + i + ".Owner").endsWith(player.getUniqueId().toString()) : false) {
//                    items.add(data.getItemStack("Items." + i + ".Item").clone());
//                } else if (data.get("Items." + i + ".Owner") != null ? data.getString("Items." + i + ".Owner").equalsIgnoreCase(player.getName()) : false) {
//                    items.add(data.getItemStack("Items." + i + ".Item").clone());
//                }
//            }
//        }
        return items;
    }
    
//    public ArrayList<ItemStack> getItems(Player player, ShopType type) {
//        ProtectedConfiguration data = Files.DATA.getFile();
//        ArrayList<ItemStack> items = new ArrayList();
//        if (data.contains("Items")) {
//            for (String i : data.getConfigurationSection("Items").getKeys(false)) {
//                if (data.get("Items." + i + ".Owner") != null ? data.getString("Items." + i + ".Owner").endsWith(player.getUniqueId().toString()) : false) {
//                    if (data.getBoolean("Items." + i + ".Biddable")) {
//                        if (type == ShopType.BID) {
//                            items.add(data.getItemStack("Items." + i + ".Item").clone());
//                        }
//                    } else if (data.getBoolean("Items." + i + ".Buy")) {
//                        if (type == ShopType.BUY || type.equals(ShopType.SELLANDBUY)) {
//                            items.add(data.getItemStack("Items." + i + ".Item").clone());
//                        }
//                    } else {
//                        if (type == ShopType.SELL || type.equals(ShopType.SELLANDBUY)) {
//                            items.add(data.getItemStack("Items." + i + ".Item").clone());
//                        }
//                    }
//                } else if (data.get("Items." + i + ".Owner") != null ? data.getString("Items." + i + ".Owner").equalsIgnoreCase(player.getName()) : false) {
//                    if (data.getBoolean("Items." + i + ".Biddable")) {
//                        if (type == ShopType.BID) {
//                            items.add(data.getItemStack("Items." + i + ".Item").clone());
//                        }
//                    } else if (data.getBoolean("Items." + i + ".Buy")) {
//                        if (type == ShopType.BUY || type.equals(ShopType.SELLANDBUY)) {
//                            items.add(data.getItemStack("Items." + i + ".Item").clone());
//                        }
//                    } else {
//                        if (type == ShopType.SELL || type.equals(ShopType.SELLANDBUY)) {
//                            items.add(data.getItemStack("Items." + i + ".Item").clone());
//                        }
//                    }
//                }
//            }
//        }
//        return items;
//    }
}