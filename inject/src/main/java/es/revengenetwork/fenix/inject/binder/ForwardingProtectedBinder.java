package es.revengenetwork.fenix.inject.binder;

import com.google.inject.Binder;
import org.jetbrains.annotations.NotNull;

public interface ForwardingProtectedBinder extends ProtectedBinder, ForwardingPrivateBinder {
  @Override
  @NotNull ProtectedBinder forward();

  @Override
  default @NotNull Binder publicBinder() {
    return this.forward()
             .publicBinder();
  }

  @Override
  default @NotNull ProtectedBinder withSource(final @NotNull Object source) {
    return this.forward()
             .withSource(source);
  }

  @Override
  default @NotNull ProtectedBinder skipSources(final @NotNull Class<?>... classesToSkip) {
    return this.forward()
             .skipSources(classesToSkip);
  }
}
