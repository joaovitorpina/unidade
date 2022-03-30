package br.com.informacaoquesalva.app.cqrs.annotations;

import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Named
@Target({ElementType.TYPE})
@Singleton
public @interface QueryHandler {
    Class<?> query();
}
