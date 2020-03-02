package studio.trc.bukkit.crazyauctionsplus.utils;

import studio.trc.bukkit.crazyauctionsplus.utils.FileManager.Files;
import studio.trc.bukkit.crazyauctionsplus.utils.FileManager.ProtectedConfiguration;

public class MarketGroup
{
    private final String groupname;
    private final boolean exist;
    private final int sellLimit;
    private final int buyLimit;
    private final int bidLimit;
    
    private static final ProtectedConfiguration config = Files.CONFIG.getFile();
    
    public MarketGroup(String groupname) {
        this.groupname = groupname;
        if (config.get("Settings.Permissions.Market.Permission-Groups." + groupname) != null) {
            exist = true;
            sellLimit = config.getInt("Settings.Permissions.Market.Permission-Groups." + groupname + ".Sell-Limit");
            buyLimit = config.getInt("Settings.Permissions.Market.Permission-Groups." + groupname + ".Buy-Limit");
            bidLimit = config.getInt("Settings.Permissions.Market.Permission-Groups." + groupname + ".Bid-Limit");
        } else {
            exist = false;
            sellLimit = 0;
            buyLimit = 0;
            bidLimit = 0;
        }
    }
    
    public int getSellLimit() {
        return sellLimit;
    }
    
    public int getBuyLimit() {
        return buyLimit;
    }
    
    public int getBidLimit() {
        return bidLimit;
    }
    
    public String getGroupName() {
        return groupname;
    }
    
    public boolean exist() {
        return exist;
    }
}
