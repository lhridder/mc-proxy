package nl.lucasridder.proxy;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.event.PlayerDisconnectEvent;
import net.md_5.bungee.api.event.PostLoginEvent;
import net.md_5.bungee.api.event.ServerConnectedEvent;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.event.EventHandler;

public class Events implements Listener {

    Proxy main;
    public Events(Proxy plugin) {
        this.main = plugin;
    }

    public Events() {

    }

    @EventHandler
    public void onPostLogin(PostLoginEvent e) {
        for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
            String name = e.getPlayer().getName();
            String server = e.getPlayer().getServer().getInfo().getName();

            //tell console join
            System.out.println(main.prefix + ChatColor.GREEN + name + " connected to proxy");

            //tell admin players
            if (players.hasPermission("LucasProxy.admin")) {
                players.sendMessage(new TextComponent(main.prefix + ChatColor.RESET + e.getPlayer().getName() + " connected to proxy"));
            }
        }

    }

    @EventHandler
    public void onServerConnect(ServerConnectedEvent e) {
        for(ProxiedPlayer players : ProxyServer.getInstance().getPlayers()) {
            String name = e.getPlayer().getName();
            String server = e.getPlayer().getServer().getInfo().getName();

            //tell console join
            System.out.println(main.prefix + ChatColor.GREEN + name + " connected server " + server);

            //tell admin players
            if (!players.getServer().equals(e.getPlayer().getServer()) && players.hasPermission("LucasProxy.admin")) {

                players.sendMessage(new TextComponent(main.prefix + e.getPlayer().getName() + " connected to server " + server));
            }
        }
    }

    @EventHandler
    public void onDisconnect(PlayerDisconnectEvent e) {
        ProxiedPlayer player = e.getPlayer();
        String name = player.getName();
        String server = player.getServer().getInfo().getName();
    }

}
