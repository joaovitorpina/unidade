package br.com.informacaoquesalva.domain.aggregates;

import br.com.informacaoquesalva.domain.seedwork.AggregateRoot;
import br.com.informacaoquesalva.domain.seedwork.Entity;

public class Unidade extends Entity implements AggregateRoot {
    private String descricao;
    private String urlAmigavel;
    private Endereco endereco;
    private Long telefone;
    private Long celular;
    private String email;
    private String urlFacebook;
    private String urlInstagram;
    private String urlYoutube;
    private Boolean status;

    public Unidade(String descricao, String urlAmigavel, Endereco endereco) {
        this.descricao = descricao;
        this.urlAmigavel = urlAmigavel;
        this.endereco = endereco;
        status = true;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrlAmigavel() {
        return urlAmigavel;
    }

    public void setUrlAmigavel(String urlAmigavel) {
        this.urlAmigavel = urlAmigavel;
    }

    public Long getTelefone() {
        return telefone;
    }

    public void setTelefone(Long telefone) {
        this.telefone = telefone;
    }

    public Long getCelular() {
        return celular;
    }

    public void setCelular(Long celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrlFacebook() {
        return urlFacebook;
    }

    public void setUrlFacebook(String urlFacebook) {
        this.urlFacebook = urlFacebook;
    }

    public String getUrlInstagram() {
        return urlInstagram;
    }

    public void setUrlInstagram(String urlInstagram) {
        this.urlInstagram = urlInstagram;
    }

    public String getUrlYoutube() {
        return urlYoutube;
    }

    public void setUrlYoutube(String urlYoutube) {
        this.urlYoutube = urlYoutube;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}
