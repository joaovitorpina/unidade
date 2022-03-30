package br.com.informacaoquesalva.infrastructure.data.mappers;

import br.com.informacaoquesalva.domain.aggregates.Endereco;
import br.com.informacaoquesalva.domain.aggregates.Unidade;
import br.com.informacaoquesalva.infrastructure.data.models.UnidadeModel;

public class UnidadeMapper {
    public static UnidadeModel toModel(Unidade unidade) {
        var model = new UnidadeModel();

        if (!unidade.isTransient()) {
            model.setId(unidade.getId());
        }

        model.setDescricao(unidade.getDescricao());
        model.setUrlAmigavel(unidade.getUrlAmigavel());
        model.setEstado(unidade.getEndereco().getEstado());
        model.setCidade(unidade.getEndereco().getCidade());
        model.setLogradouro(unidade.getEndereco().getLogradouro());
        model.setNumero(unidade.getEndereco().getNumero());
        model.setBairro(unidade.getEndereco().getBairro());
        model.setCep(unidade.getEndereco().getCep());
        model.setLatitude(unidade.getEndereco().getLatitude());
        model.setLongitude(unidade.getEndereco().getLongitude());
        model.setTelefone(unidade.getTelefone());
        model.setCelular(unidade.getCelular());
        model.setEmail(unidade.getEmail());
        model.setUrlFacebook(unidade.getUrlFacebook());
        model.setUrlInstagram(unidade.getUrlInstagram());
        model.setUrlYoutube(unidade.getUrlYoutube());
        model.setStatus(unidade.getStatus());

        return model;
    }

    public static Unidade toDomain(UnidadeModel model) {
        var domain = new Unidade(model.getDescricao(), model.getUrlAmigavel(), new Endereco(model.getEstado(), model.getCidade(), model.getLogradouro(), model.getNumero(), model.getBairro(), model.getCep(), model.getLatitude(), model.getLongitude()));

        domain.setId(model.getId());
        domain.setTelefone(model.getTelefone());
        domain.setCelular(model.getCelular());
        domain.setEmail(model.getEmail());
        domain.setUrlFacebook(model.getUrlFacebook());
        domain.setUrlInstagram(model.getUrlInstagram());
        domain.setUrlYoutube(model.getUrlYoutube());
        domain.setStatus(model.getStatus());

        return domain;
    }
}
