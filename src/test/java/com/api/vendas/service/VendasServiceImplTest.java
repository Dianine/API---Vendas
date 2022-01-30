package com.api.vendas.service;

import com.api.vendas.model.Produto;
import com.api.vendas.repository.ProdutoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Optional.ofNullable;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class VendasServiceImplTest {

    @InjectMocks
    private VendasServiceImpl service;
    @Mock
    private ProdutoRepository repository;
    private Produto produto;

    @BeforeEach
    void setUp() {
        produto = new Produto(1l,"Honda",120.89, BigDecimal.valueOf(120));
    }

    @Test
    void listarProdutos() {
        //when
        List<Produto> produtos = new ArrayList<>(Arrays.asList(produto));
        Mockito.when(repository.findAll()).thenReturn(produtos);
        //given
        //assert
        Assertions.assertEquals(produtos,service.listarProdutos());

    }

    @Test
    void buscarProdutoPorId() {
        //when
        Mockito.when(repository.findById(Mockito.anyLong())).thenReturn(ofNullable(produto));
        //given

        //assert
        assertEquals(produto,service.buscarProdutoPorId(Mockito.anyLong()));
    }

    @Test
    void salvarProduto() {
    }

    @Test
    void atualizarProdutoPorId() {
    }

    @Test
    void deletarProdutoPorId() {
    }
}