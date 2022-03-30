package br.com.informacaoquesalva.app.cqrs;

public interface QueryHandler<Q extends Query<R>, R> {
    R execute(Q command);
}
