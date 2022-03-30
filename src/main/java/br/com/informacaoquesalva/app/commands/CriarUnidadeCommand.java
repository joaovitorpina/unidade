package br.com.informacaoquesalva.app.commands;

import br.com.informacaoquesalva.api.dtos.CriarUnidadeRequest;
import br.com.informacaoquesalva.app.cqrs.Command;
import br.com.informacaoquesalva.domain.aggregates.Unidade;
import reactor.core.publisher.Mono;

public class CriarUnidadeCommand implements Command<Mono<Unidade>> {
    private final CriarUnidadeRequest criarUnidadeRequest;

    public CriarUnidadeCommand(CriarUnidadeRequest criarUnidadeRequest) {
        this.criarUnidadeRequest = criarUnidadeRequest;
    }

    public CriarUnidadeRequest getCriarUnidadaRequest() {
        return criarUnidadeRequest;
    }
}
