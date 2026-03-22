package com.example.ex6.Controller;

import com.example.ex6.Models.ProdutoModel;
import com.example.ex6.Repositories.ProdutoRepository;
import com.example.ex6.Services.ProdutoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public ProdutoService getProdutoService() {
        return produtoService;
    }

    public void setProdutoService(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping
    public ProdutoModel criarProduto(@RequestBody ProdutoModel produto){
        return produtoService.criarProduto(produto);
    }

    @GetMapping
    public List<ProdutoModel> listarProdutos(){
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public ProdutoModel buscarProduto(@PathVariable Long id){
        return produtoService.buscarProdutoPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletarProduto(@PathVariable Long id){
        produtoService.deletarProduto(id);
    }
}
