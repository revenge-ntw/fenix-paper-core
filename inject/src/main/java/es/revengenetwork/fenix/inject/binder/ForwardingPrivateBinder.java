package es.revengenetwork.fenix.inject.binder;

import com.google.inject.Key;
import com.google.inject.PrivateBinder;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedElementBuilder;
import org.jetbrains.annotations.NotNull;

public interface ForwardingPrivateBinder extends ForwardingBinder, PrivateBinder {
  @Override
  @NotNull PrivateBinder forward();

  @Override
  default void expose(final @NotNull Key<?> key) {
    this.forward()
      .expose(key);
  }

  @Override
  default @NotNull AnnotatedElementBuilder expose(final @NotNull Class<?> type) {
    return this.forward()
             .expose(type);
  }

  @Override
  default @NotNull AnnotatedElementBuilder expose(final @NotNull TypeLiteral<?> type) {
    return this.forward()
             .expose(type);
  }

  @Override
  default @NotNull PrivateBinder withSource(final @NotNull Object source) {
    return this.forward()
             .withSource(source);
  }

  @Override
  default @NotNull PrivateBinder skipSources(final @NotNull Class<?>... classesToSkip) {
    return this.forward()
             .skipSources(classesToSkip);
  }
}
