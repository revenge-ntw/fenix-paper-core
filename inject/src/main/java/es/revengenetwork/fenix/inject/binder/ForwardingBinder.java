package es.revengenetwork.fenix.inject.binder;

import com.google.inject.Binder;
import com.google.inject.Binding;
import com.google.inject.Key;
import com.google.inject.MembersInjector;
import com.google.inject.Module;
import com.google.inject.PrivateBinder;
import com.google.inject.Provider;
import com.google.inject.Scope;
import com.google.inject.Stage;
import com.google.inject.TypeLiteral;
import com.google.inject.binder.AnnotatedBindingBuilder;
import com.google.inject.binder.AnnotatedConstantBindingBuilder;
import com.google.inject.binder.LinkedBindingBuilder;
import com.google.inject.matcher.Matcher;
import com.google.inject.spi.Dependency;
import com.google.inject.spi.Message;
import com.google.inject.spi.ModuleAnnotatedMethodScanner;
import com.google.inject.spi.ProvisionListener;
import com.google.inject.spi.TypeConverter;
import com.google.inject.spi.TypeListener;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.aopalliance.intercept.MethodInterceptor;
import org.jetbrains.annotations.NotNull;

public interface ForwardingBinder extends Binder {
  @NotNull Binder forward();

  @Override
  default void bindInterceptor(
    final @NotNull Matcher<? super Class<?>> classMatcher,
    final @NotNull Matcher<? super Method> methodMatcher,
    final @NotNull MethodInterceptor... interceptors
  ) {
    this.forward()
      .bindInterceptor(classMatcher, methodMatcher, interceptors);
  }

  @Override
  default void bindScope(
    final @NotNull Class<? extends Annotation> annotationType,
    final @NotNull Scope scope
  ) {
    this.forward()
      .bindScope(annotationType, scope);
  }

  @Override
  default <T> @NotNull LinkedBindingBuilder<T> bind(final @NotNull Key<T> key) {
    return this.forward()
             .bind(key);
  }

  @Override
  default <T> @NotNull AnnotatedBindingBuilder<T> bind(final @NotNull TypeLiteral<T> typeLiteral) {
    return this.forward()
             .bind(typeLiteral);
  }

  @Override
  default <T> @NotNull AnnotatedBindingBuilder<T> bind(final @NotNull Class<T> type) {
    return this.forward()
             .bind(type);
  }

  @Override
  default @NotNull AnnotatedConstantBindingBuilder bindConstant() {
    return this.forward()
             .bindConstant();
  }

  @Override
  default <T> void requestInjection(final @NotNull TypeLiteral<T> type, final @NotNull T instance) {
    this.forward()
      .requestInjection(type, instance);
  }

  @Override
  default void requestInjection(final @NotNull Object instance) {
    this.forward()
      .requestInjection(instance);
  }

  @Override
  default void requestStaticInjection(final @NotNull Class<?>... types) {
    this.forward()
      .requestStaticInjection(types);
  }

  @Override
  default void install(final @NotNull Module module) {
    this.forward()
      .install(module);
  }

  @Override
  default @NotNull Stage currentStage() {
    return this.forward()
             .currentStage();
  }

  @Override
  default void addError(final @NotNull String message, final @NotNull Object... arguments) {
    this.forward()
      .addError(message, arguments);
  }

  @Override
  default void addError(final @NotNull Throwable t) {
    this.forward()
      .addError(t);
  }

  @Override
  default void addError(final @NotNull Message message) {
    this.forward()
      .addError(message);
  }

  @Override
  default <T> @NotNull Provider<T> getProvider(final @NotNull Key<T> key) {
    return this.forward()
             .getProvider(key);
  }

  @Override
  default <T> @NotNull Provider<T> getProvider(final @NotNull Dependency<T> dependency) {
    return this.forward()
             .getProvider(dependency);
  }

  @Override
  default <T> @NotNull Provider<T> getProvider(final @NotNull Class<T> type) {
    return this.forward()
             .getProvider(type);
  }

  @Override
  default <T> @NotNull MembersInjector<T> getMembersInjector(
    final @NotNull TypeLiteral<T> typeLiteral
  ) {
    return this.forward()
             .getMembersInjector(typeLiteral);
  }

  @Override
  default <T> @NotNull MembersInjector<T> getMembersInjector(final @NotNull Class<T> type) {
    return this.forward()
             .getMembersInjector(type);
  }

  @Override
  default void convertToTypes(
    final @NotNull Matcher<? super TypeLiteral<?>> typeMatcher,
    final @NotNull TypeConverter converter
  ) {
    this.forward()
      .convertToTypes(typeMatcher, converter);
  }

  @Override
  default void bindListener(
    final @NotNull Matcher<? super TypeLiteral<?>> typeMatcher,
    final @NotNull TypeListener listener
  ) {
    this.forward()
      .bindListener(typeMatcher, listener);
  }

  @Override
  default void bindListener(
    final @NotNull Matcher<? super Binding<?>> bindingMatcher,
    final @NotNull ProvisionListener... listeners
  ) {
    this.forward()
      .bindListener(bindingMatcher, listeners);
  }

  @Override
  default @NotNull Binder withSource(final @NotNull Object source) {
    return this.forward()
             .withSource(source);
  }

  @Override
  default @NotNull Binder skipSources(final @NotNull Class<?>... classesToSkip) {
    return this.forward()
             .skipSources(classesToSkip);
  }

  @Override
  default @NotNull PrivateBinder newPrivateBinder() {
    return this.forward()
             .newPrivateBinder();
  }

  @Override
  default void requireExplicitBindings() {
    this.forward()
      .requireExplicitBindings();
  }

  @Override
  default void disableCircularProxies() {
    this.forward()
      .disableCircularProxies();
  }

  @Override
  default void requireAtInjectOnConstructors() {
    this.forward()
      .requireAtInjectOnConstructors();
  }

  @Override
  default void requireExactBindingAnnotations() {
    this.forward()
      .requireExactBindingAnnotations();
  }

  @Override
  default void scanModulesForAnnotatedMethods(final @NotNull ModuleAnnotatedMethodScanner scanner) {
    this.forward()
      .scanModulesForAnnotatedMethods(scanner);
  }
}
