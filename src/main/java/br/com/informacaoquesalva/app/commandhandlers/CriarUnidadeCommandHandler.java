package br.com.informacaoquesalva.app.commandhandlers;

import br.com.informacaoquesalva.app.commands.CriarUnidadeCommand;
import br.com.informacaoquesalva.app.cqrs.annotations.CommandHandler;
import br.com.informacaoquesalva.domain.aggregates.Endereco;
import br.com.informacaoquesalva.domain.aggregates.Unidade;
import br.com.informacaoquesalva.infrastructure.adapters.repositories.UnidadeRepository;
import reactor.core.publisher.Mono;

@CommandHandler(command = CriarUnidadeCommand.class)
public class CriarUnidadeCommandHandler implements br.com.informacaoquesalva.app.cqrs.CommandHandler<CriarUnidadeCommand, Mono<Unidade>> {
    private final UnidadeRepository unidadeRepository;

    public CriarUnidadeCommandHandler(UnidadeRepository unidadeRepository) {
        this.unidadeRepository = unidadeRepository;
    }

    @Override
    public Mono<Unidade> execute(CriarUnidadeCommand command) {
        var enderecoRequest = command.getCriarUnidadaRequest().endereco();
        var unidade = new Unidade(command.getCriarUnidadaRequest().descricao(), command.getCriarUnidadaRequest().urlAmigavel(), new Endereco(enderecoRequest.estado(), enderecoRequest.cidade(), enderecoRequest.logradouro(), enderecoRequest.numero(), enderecoRequest.bairro(), enderecoRequest.cep(), enderecoRequest.latitude(), enderecoRequest.longitude()));
        unidade.setTelefone(command.getCriarUnidadaRequest().telefone());
        unidade.setCelular(command.getCriarUnidadaRequest().celular());
        unidade.setEmail(command.getCriarUnidadaRequest().email());
        unidade.setUrlFacebook(command.getCriarUnidadaRequest().urlFacebook());
        unidade.setUrlInstagram(command.getCriarUnidadaRequest().urlInstagram());
        unidade.setUrlYoutube(command.getCriarUnidadaRequest().urlYoutube());
        unidade.setStatus(command.getCriarUnidadaRequest().status());

        return unidadeRepository.salvarUnidade(unidade);
    }
}
