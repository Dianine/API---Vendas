package com.api.vendas.controler;


import com.api.vendas.service.VendasService;
import com.api.vendas.service.VendasServiceImpl;
import com.api.vendas.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class ProdutoController {
    // aqui vc so faz as requisições no maximo

    @Autowired
    private VendasService service;

    @GetMapping("/produtos") /*Lista Todos os Produtos*/
    public List<Produto> listaProdutos(){
        return service.listarProdutos();
    }

    @GetMapping("/produto/{id}")/*Lista Produto por Id*/
    public Produto listaProdutoId(@PathVariable("id") long id){
        return service.buscarProdutoPorId(id);
        /*Tem que fazer o: Produto findById(long id); na Interface*/
    }

    @PostMapping("/produto")
    public Produto salvarProduto (@RequestBody Produto produto){
        return service.salvarProduto(produto);
    }


    @PutMapping("/produto/{id}")
    public Produto editaProduto(@PathVariable("id") long id,@RequestBody Produto produto){
        return service.atualizarProdutoPorId(id,produto);
    }
    @DeleteMapping("/produto/{id}")
    public void deletaProduto(@PathVariable("id") long id){
        service.deletarProdutoPorId(id);
    }
}
