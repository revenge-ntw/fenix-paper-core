package es.revengenetwork.fenix.paper.plugin;

import es.revengenetwork.fenix.inject.binder.ProtectedBinder;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class InjectedPlugin extends JavaPlugin {
  public void configure(final @NotNull ProtectedBinder binder) {
    // Override this method to configure the plugin
  }
}
