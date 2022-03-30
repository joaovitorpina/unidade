package br.com.informacaoquesalva.domain.aggregates;

import br.com.informacaoquesalva.domain.seedwork.ValueObject;

import java.util.List;

public class Endereco extends ValueObject {
    private String estado;
    private String cidade;
    private String logradouro;
    private String numero;
    private String bairro;
    private Long cep;
    private Float latitude;
    private Float longitude;

    public Endereco(String estado, String cidade, String logradouro, String numero, String bairro, Long cep, Float latitude, Float longitude) {
        this.estado = estado;
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.numero = numero;
        this.bairro = bairro;
        this.cep = cep;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    @Override
    protected List<Object> getEqualityComponents() {
        return List.of(estado, cidade, logradouro, numero, bairro, cep, latitude, longitude);
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public Long getCep() {
        return cep;
    }

    public void setCep(Long cep) {
        this.cep = cep;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }
}
