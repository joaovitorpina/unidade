package br.com.informacaoquesalva.app.cqrs;

public interface EventHandler<E extends Event> {
    void execute(E event);
}
