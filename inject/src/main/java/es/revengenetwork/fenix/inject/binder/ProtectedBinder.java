package es.revengenetwork.fenix.inject.binder;

import com.google.inject.Binder;
import org.jetbrains.annotations.NotNull;

public interface ProtectedBinder extends ForwardingPrivateBinder {
  @NotNull Binder publicBinder();

  default @NotNull ProtectedBinder withSource(final @NotNull Object source) {
    return new ProtectedBinderImpl(
      this.publicBinder()
        .withSource(source),
      this.forward()
        .withSource(source));
  }

  default @NotNull ProtectedBinder skipSources(final @NotNull Class<?>... classesToSkip) {
    return new ProtectedBinderImpl(
      this.publicBinder()
        .skipSources(classesToSkip),
      this.forward()
        .skipSources(classesToSkip));
  }

  static @NotNull ProtectedBinder create(final @NotNull Binder binder) {
    return new ProtectedBinderImpl(binder, binder.newPrivateBinder());
  }
}
