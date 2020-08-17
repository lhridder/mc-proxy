package nl.lucasridder.proxy;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.plugin.Plugin;

public class Proxy extends Plugin {

    String prefix = "[L-P] ";

    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerListener(this, new Events());

        getProxy().getPluginManager().registerCommand(this, new proxyCommand());

        //enable
        System.out.println(prefix + ChatColor.GREEN + " succesfully enabled");
    }

    @Override
    public void onDisable() {
        //disable
        System.out.println(prefix + ChatColor.GREEN + " succesfully disabled");
    }
}
