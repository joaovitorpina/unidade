package br.com.informacaoquesalva.api.dtos;

public record EnderecoRequest(String estado, String cidade, String logradouro, String numero, String bairro, Long cep,
                              Float latitude, Float longitude) {

}
