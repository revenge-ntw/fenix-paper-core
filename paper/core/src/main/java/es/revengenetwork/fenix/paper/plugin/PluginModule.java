package es.revengenetwork.fenix.paper.plugin;

import com.google.inject.Scopes;
import es.revengenetwork.fenix.inject.ProtectedModule;
import java.nio.file.Path;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;

public class PluginModule extends ProtectedModule {
  private final InjectedPlugin plugin;

  public PluginModule(final @NotNull InjectedPlugin plugin) {
    this.plugin = plugin;
  }

  @Override
  public void configure() {
    super.bind(Plugin.class)
      .toInstance(this.plugin);
    super.bind(Path.class)
      .toProvider(() -> this.plugin.getDataFolder()
                          .toPath())
      .in(Scopes.SINGLETON);
    super.bind(Logger.class)
      .toProvider(this.plugin::getSLF4JLogger)
      .in(Scopes.SINGLETON);

    this.plugin.configure(super.binder());
  }
}
