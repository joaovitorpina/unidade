package br.com.informacaoquesalva.infrastructure.adapters.repositories;

import br.com.informacaoquesalva.domain.aggregates.Unidade;
import br.com.informacaoquesalva.infrastructure.data.mappers.UnidadeMapper;
import br.com.informacaoquesalva.infrastructure.data.models.UnidadeModel;
import io.micronaut.data.model.query.builder.sql.Dialect;
import io.micronaut.data.r2dbc.annotation.R2dbcRepository;
import io.micronaut.data.repository.reactive.ReactorCrudRepository;
import reactor.core.publisher.Mono;

@R2dbcRepository(dialect = Dialect.MYSQL)
public abstract class UnidadeRepository implements ReactorCrudRepository<UnidadeModel, Long> {
    public Mono<Unidade> salvarUnidade(Unidade unidade) {
        var model = UnidadeMapper.toModel(unidade);

        return save(model).map(UnidadeMapper::toDomain);
    }

    public Mono<Unidade> buscarUnidadePorId(Long id) {
        var unidade = findById(id);

        return unidade.map((model -> {
            if (model == null) {
                return null;
            }

            return UnidadeMapper.toDomain(model);
        }));
    }
}
