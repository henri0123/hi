package br.com.senai.comercio094.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senai.comercio094.entity.Produto;
import br.com.senai.comercio094.repository.ProdutoRepository;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;
    // listar todos os protudos

    public List<Produto> findAll(){
        return produtoRepository.findAll();
    }

    //Mostrar produto por id
    public Produto findById(Long id){
        return produtoRepository.findById(id).orElse(null);
    }

    // Alterar produto
    public Produto update(Long id, Produto produtoAlterado){
        Produto produtoAtual = findById(id);
        produtoAtual.setNome(produtoAlterado.getNome());
        produtoAtual.setPreco(produtoAlterado.getPreco());
        produtoAtual.setDescricao(produtoAlterado.getDescricao());
        produtoAtual.setQuantidade(produtoAlterado.getQuantidade());
        produtoRepository.save(produtoAtual);
        return produtoAtual;
    }

    // Apagar um produto
    public Boolean deleteById(Long id){
        Produto produto = findById(id);
        if (produto == null){
            return false;
        }else{
            produtoRepository.deleteById(id);
            return true;
        }

    }

    //insere novo produto
    public Produto insertNew(Produto produto){
        return produtoRepository.save(produto);
    }
}
