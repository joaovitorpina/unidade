package br.com.informacaoquesalva.app.cqrs.buses;

import br.com.informacaoquesalva.app.cqrs.Event;

import java.util.List;

public interface EventBus {
    <E extends Event> void publish(E event);

    <E extends Event> void publishAll(List<E> events);
}
