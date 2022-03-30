package br.com.informacaoquesalva.app.commands;

import br.com.informacaoquesalva.api.dtos.AtualizarUnidadeRequest;
import br.com.informacaoquesalva.app.cqrs.Command;
import br.com.informacaoquesalva.domain.aggregates.Unidade;
import reactor.core.publisher.Mono;

public class AtualizarUnidadeCommand implements Command<Mono<Unidade>> {
    private final AtualizarUnidadeRequest atualizarUnidadeRequest;

    public AtualizarUnidadeCommand(AtualizarUnidadeRequest atualizarUnidadeRequest) {
        this.atualizarUnidadeRequest = atualizarUnidadeRequest;
    }

    public AtualizarUnidadeRequest getAtualizarUnidadeRequest() {
        return atualizarUnidadeRequest;
    }
}
