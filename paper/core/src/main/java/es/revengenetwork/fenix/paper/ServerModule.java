package es.revengenetwork.fenix.paper;

import com.google.inject.AbstractModule;
import es.revengenetwork.fenix.inject.binder.ProtectedBinder;
import es.revengenetwork.fenix.paper.plugin.InjectedPlugin;
import es.revengenetwork.fenix.paper.plugin.PluginModule;
import java.util.Collection;
import org.jetbrains.annotations.NotNull;

@SuppressWarnings("unused")
public class ServerModule extends AbstractModule {
  private final Collection<InjectedPlugin> plugins;

  public ServerModule(final @NotNull Collection<InjectedPlugin> plugins) {
    this.plugins = plugins;
  }

  @Override
  public void configure() {
    for (final var plugin : this.plugins) {
      ProtectedBinder.create(super.binder())
        .install(new PluginModule(plugin));
    }
  }
}
