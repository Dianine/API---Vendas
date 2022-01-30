package com.api.vendas.service;

import com.api.vendas.model.Produto;

import java.util.List;

public interface VendasService {
    List<Produto> listarProdutos();
    Produto buscarProdutoPorId(Long id);
    Produto salvarProduto(Produto produto);
    Produto atualizarProdutoPorId(Long id,Produto produto);
    void deletarProdutoPorId(Long id);

}
