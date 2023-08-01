package es.karmadev.examples.rawmodule;

import es.karmadev.examples.rawmodule.listener.LockLoginListener;
import es.karmadev.locklogin.api.extension.module.Module;

import java.net.URI;

public class Main extends Module {

    @Override
    public void onLoad() {
        manager.addEventHandler(new LockLoginListener());
    }

    @Override
    public void onUnload() {

    }

    @Override
    public URI sourceUpdateURI() {
        return null;
    }
}
