package br.com.fiap.challenge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.fiap.challenge.model.Produto;
import br.com.fiap.challenge.repository.ProdutoRepository;

@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private ProdutoRepository produtoRepository;
	
    
	@GetMapping("buscar")
    public String buscar(String nomeBusca, Model model ){
        model.addAttribute("Produtos", produtoRepository.findByNomeContainsIgnoreCase(nomeBusca));
        return "produto/lista";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("Produtos", produtoRepository.findAll());
        return "produto/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Produto produto, Model model){
        model.addAttribute("Produtos", produtoRepository.findAll());
        return "produto/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Produto produto, RedirectAttributes redirect){
        produtoRepository.save(produto);
        redirect.addFlashAttribute("msg", "Cadastrado!");
        return "redirect:/produto/cadastrar";
    }	

    @DeleteMapping("deletar/{id}")
    public String deletar(@PathVariable Long id,Model model) {
        produtoRepository.deleteById(id);
        model.addAttribute("Produtos",produtoRepository.findAll());
        return "produto/lista";
    }

    @PostMapping("editar")
    public String editBook(Long id, String nome, Long estoque, Double valor, Produto produto, RedirectAttributes redirect) {
        produto.setId(id);
        produto.setNome(nome);
        produto.setEstoque(estoque);
        produto.setValor(valor);
        produtoRepository.save(produto);
        redirect.addFlashAttribute("msg", "Editado!");
        return "redirect:/";
    } 


    @GetMapping("editar/{id}")
    public String bookListUpdate(@PathVariable (value = "id") Long id, Model model) {
        model.addAttribute("Produtos", produtoRepository.findById(id).get());
        return "produto/edit";
    } 
}