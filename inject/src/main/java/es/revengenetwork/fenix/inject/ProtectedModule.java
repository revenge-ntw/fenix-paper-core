package es.revengenetwork.fenix.inject;

import com.google.inject.Binder;
import com.google.inject.Module;
import es.revengenetwork.fenix.inject.binder.ForwardingProtectedBinder;
import es.revengenetwork.fenix.inject.binder.ProtectedBinder;
import es.revengenetwork.fenix.inject.binder.ProtectedBinderImpl;
import java.util.Objects;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ProtectedModule implements Module, ForwardingProtectedBinder {
  private final Object moduleKey;
  private ProtectedBinder binder;

  protected ProtectedModule(final @Nullable Object moduleKey) {
    this.moduleKey = moduleKey;
  }

  protected ProtectedModule() {
    this(null);
  }

  protected void configure() {

  }

  @Override
  public @NotNull ProtectedBinder forward() {
    return this.binder();
  }

  @Override
  public int hashCode() {
    return this.moduleKey != null ?
           this.moduleKey.hashCode() :
           super.hashCode();
  }

  @Override
  public boolean equals(final @Nullable Object object) {
    if (object == this) {
      return true;
    }
    if (object == null) {
      return false;
    }
    if (object.getClass() != this.getClass()) {
      return false;
    }
    final var other = (ProtectedModule) object;
    return Objects.equals(this.moduleKey, other.moduleKey);
  }

  protected final @NotNull ProtectedBinder binder() {
    if (this.binder == null) {
      throw new IllegalStateException("Cannot access binder outside of configure()");
    }
    return this.binder;
  }

  @Override
  public void configure(final @NotNull Binder binder) {
    final var old = this.binder;
    this.binder = ProtectedBinderImpl.current(binder);
    try {
      if (this.binder != null) {
        this.configure();
        return;
      }
      binder.skipSources(ProtectedModule.class)
        .addError(ProtectedModule.class.getSimpleName() + " must be installed in a " +
                  ProtectedBinder.class.getSimpleName() + " context");
    } finally {
      this.binder = old;
    }
  }
}
