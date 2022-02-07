package com.api.vendas.service;

import com.api.vendas.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.vendas.repository.ProdutoRepository;

import java.util.List;
@Service
public class VendasServiceImpl implements VendasService{

    @Autowired
    private ProdutoRepository repository;

    @Override
    public List<Produto> listarProdutos() {
        return repository.findAll();
    }

    @Override
    public Produto buscarProdutoPorId(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException());
    }

    @Override
    public Produto salvarProduto(Produto produto) {
        return repository.save(produto);
    }

    @Override
    public Produto atualizarProdutoPorId(Long id, Produto produto) {
        return repository.findById(id)
                .map(search -> search = Produto.builder()
                        .id(produto.getId())
                        .nome(produto.getNome())
                        .idade(produto.getIdade())
                        //.quantidade(produto.getQuantidade())
                        .build())
                .orElseThrow(() -> new RuntimeException());
    }

    @Override
    public void deletarProdutoPorId(Long id) {
        repository.deleteById(id);
    }
}
