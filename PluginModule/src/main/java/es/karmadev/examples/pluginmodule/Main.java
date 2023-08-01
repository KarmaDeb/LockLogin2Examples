package es.karmadev.examples.pluginmodule;

import es.karmadev.examples.pluginmodule.listener.LockLoginListener;
import es.karmadev.locklogin.api.CurrentPlugin;
import es.karmadev.locklogin.api.LockLogin;
import es.karmadev.locklogin.api.extension.ModuleConverter;
import es.karmadev.locklogin.api.extension.module.manager.ModuleManager;
import es.karmadev.locklogin.api.extension.plugin.PluginModule;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private PluginModule<JavaPlugin> module;

    @Override
    public void onEnable() {
        LockLogin plugin = CurrentPlugin.getPlugin();
        ModuleConverter<JavaPlugin> converter = plugin.getConverter();
        module = converter.extend(this);

        if (module != null) {
            plugin.info("Successfully hooked plugin {0} into LockLogin", getName());
            ModuleManager manager = plugin.moduleManager();

            manager.addEventHandler(new LockLoginListener());
        }
    }

    @Override
    public void onDisable() {
        if (module != null) {
            LockLogin plugin = CurrentPlugin.getPlugin();
            ModuleConverter<JavaPlugin> converter = plugin.getConverter();

            converter.retract(module);
        }
    }
}
