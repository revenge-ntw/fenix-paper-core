package es.revengenetwork.fenix.inject.binder;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.PrivateBinder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProtectedBinderImpl implements ProtectedBinder {
  private static final ThreadLocal<ProtectedBinderImpl> CURRENT = new ThreadLocal<>();
  private static final Class<?>[] SKIP_SOURCES = new Class<?>[] {
    ForwardingBinder.class,
    ForwardingPrivateBinder.class,
    ProtectedBinder.class,
    ProtectedBinderImpl.class
  };
  private final Binder global;
  private final PrivateBinder local;

  protected ProtectedBinderImpl(final @NotNull Binder global, final @NotNull PrivateBinder local) {
    this.global = global;
    this.local = (local instanceof ProtectedBinder protectedBinder ?
                  protectedBinder.forward() :
                  local).skipSources(ProtectedBinderImpl.SKIP_SOURCES);
  }

  public static @Nullable ProtectedBinder current(final @NotNull Binder global) {
    if (global instanceof ProtectedBinder globalProtected) {
      return globalProtected;
    }
    final var current = ProtectedBinderImpl.CURRENT.get();
    if (current != null && current.local == global) {
      return current;
    }
    return null;
  }

  @Override
  public @NotNull PrivateBinder forward() {
    return this.local;
  }

  @Override
  public @NotNull Binder publicBinder() {
    return this.global;
  }

  @Override
  public void install(final @NotNull Module module) {
    final var current = ProtectedBinderImpl.CURRENT.get();
    ProtectedBinderImpl.CURRENT.set(this);
    try {
      this.local.install(module);
    } finally {
      ProtectedBinderImpl.CURRENT.set(current);
    }
  }
}
