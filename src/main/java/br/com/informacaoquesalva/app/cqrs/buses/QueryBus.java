package br.com.informacaoquesalva.app.cqrs.buses;

import br.com.informacaoquesalva.app.cqrs.Query;

public interface QueryBus {
    <Q extends Query<R>, R> R execute(Q query);
}
