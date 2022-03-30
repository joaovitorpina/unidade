package br.com.informacaoquesalva.api.dtos;

public record AtualizarUnidadeRequest(Long id, String descricao, String urlAmigavel, EnderecoRequest endereco,
                                      Long telefone,
                                      Long celular, String email, String urlFacebook, String urlInstagram,
                                      String urlYoutube, Boolean status) {
}

