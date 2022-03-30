package br.com.informacaoquesalva.api.controllers;

import br.com.informacaoquesalva.api.dtos.AtualizarUnidadeRequest;
import br.com.informacaoquesalva.api.dtos.CriarUnidadeRequest;
import br.com.informacaoquesalva.app.commands.AtualizarUnidadeCommand;
import br.com.informacaoquesalva.app.commands.CriarUnidadeCommand;
import br.com.informacaoquesalva.app.cqrs.buses.CommandBus;
import br.com.informacaoquesalva.domain.aggregates.Unidade;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Patch;
import io.micronaut.http.annotation.Post;
import org.reactivestreams.Publisher;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Controller("/unidades")
public class UnidadeController {
    private final CommandBus commandBus;

    public UnidadeController(CommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Post
    public Mono<HttpResponse<Unidade>> criarUnidade(@Body Publisher<CriarUnidadeRequest> body) {
        return Mono.from(body).publishOn(Schedulers.boundedElastic()).mapNotNull(unidade -> {
            var response = this.commandBus.execute(new CriarUnidadeCommand(unidade));
            return response.map(HttpResponse::ok).block();
        });
    }

    @Patch
    public Mono<HttpResponse<Unidade>> atualizarUnidade(@Body Publisher<AtualizarUnidadeRequest> body) {
        return Mono.from(body).publishOn(Schedulers.boundedElastic()).mapNotNull(unidade -> {
            var response = this.commandBus.execute(new AtualizarUnidadeCommand(unidade));
            return response.map(HttpResponse::ok).block();
        });
    }
}
