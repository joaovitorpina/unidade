package br.com.informacaoquesalva.app.cqrs.buses;

import br.com.informacaoquesalva.app.cqrs.Command;

public interface CommandBus {
    <C extends Command<R>, R> R execute(C command);
}
