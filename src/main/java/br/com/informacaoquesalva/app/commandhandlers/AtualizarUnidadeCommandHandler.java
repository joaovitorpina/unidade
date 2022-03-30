package br.com.informacaoquesalva.app.commandhandlers;

import br.com.informacaoquesalva.app.commands.AtualizarUnidadeCommand;
import br.com.informacaoquesalva.app.cqrs.CommandHandler;
import br.com.informacaoquesalva.app.exceptions.UnidadeNaoEncontradaException;
import br.com.informacaoquesalva.domain.aggregates.Unidade;
import br.com.informacaoquesalva.infrastructure.adapters.repositories.UnidadeRepository;
import reactor.core.publisher.Mono;

@br.com.informacaoquesalva.app.cqrs.annotations.CommandHandler(command = AtualizarUnidadeCommandHandler.class)
public class AtualizarUnidadeCommandHandler implements CommandHandler<AtualizarUnidadeCommand, Mono<Unidade>> {
    private final UnidadeRepository unidadeRepository;

    public AtualizarUnidadeCommandHandler(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    @Override
    public Mono<Unidade> execute(AtualizarUnidadeCommand command) {
        var mono = unidadeRepository.buscarUnidadePorId(command.getAtualizarUnidadeRequest().id());

        mono.map(unidade -> {
            if (unidade == null) {
                throw new UnidadeNaoEncontradaException();
            }


        })
    }
}
