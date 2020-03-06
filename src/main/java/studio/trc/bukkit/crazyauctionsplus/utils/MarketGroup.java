package studio.trc.bukkit.crazyauctionsplus.utils;

import studio.trc.bukkit.crazyauctionsplus.utils.FileManager.Files;
import studio.trc.bukkit.crazyauctionsplus.utils.FileManager.ProtectedConfiguration;

public class MarketGroup
{
    private final String groupname;
    
    private static final ProtectedConfiguration config = Files.CONFIG.getFile();
    
    public MarketGroup(String groupname) {
        this.groupname = groupname;
    }
    
    public int getSellLimit() {
        return config.getInt("Settings.Permissions.Market.Permission-Groups." + groupname + ".Sell-Limit");
    }
    
    public int getBuyLimit() {
        return config.getInt("Settings.Permissions.Market.Permission-Groups." + groupname + ".Buy-Limit");
    }
    
    public int getBidLimit() {
        return config.getInt("Settings.Permissions.Market.Permission-Groups." + groupname + ".Bid-Limit");
    }
    
    public String getGroupName() {
        return groupname;
    }
    
    public boolean exist() {
        return config.get("Settings.Permissions.Market.Permission-Groups." + groupname) != null;
    }
}
