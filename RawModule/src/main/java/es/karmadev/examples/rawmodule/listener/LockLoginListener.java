package es.karmadev.examples.rawmodule.listener;

import es.karmadev.locklogin.api.CurrentPlugin;
import es.karmadev.locklogin.api.LockLogin;
import es.karmadev.locklogin.api.event.entity.client.EntityPreConnectEvent;
import es.karmadev.locklogin.api.event.handler.EventHandler;
import es.karmadev.locklogin.api.network.NetworkEntity;
import es.karmadev.locklogin.api.network.client.offline.LocalNetworkClient;

public class LockLoginListener implements EventHandler {

    private final LockLogin plugin = CurrentPlugin.getPlugin();

    public void onJoin(EntityPreConnectEvent e) {
        NetworkEntity entity = e.getEntity();
        if (entity instanceof LocalNetworkClient) {
            LocalNetworkClient client = (LocalNetworkClient) entity;
            plugin.info("Connected: {0}", client.name());
        }
    }
}
