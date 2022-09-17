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
import br.com.fiap.challenge.model.Pedido;
import br.com.fiap.challenge.repository.PedidoRepository;

@Controller
@RequestMapping("pedido")
public class PedidoController {

	@Autowired
	private PedidoRepository pedidoRepository;


	@GetMapping("buscar/")
    public String buscar(Long id, Model model) {
        model.addAttribute("Pedidos", pedidoRepository.findById(id).get());
        return "pedido/lista";
    }

    @GetMapping("listar")
    public String listar(Model model){
        model.addAttribute("Pedidos", pedidoRepository.findAll());
        return "pedido/lista";
    }

    @GetMapping("cadastrar")
    public String cadastrar(Pedido pedido, Model model){
        model.addAttribute("Pedidos", pedidoRepository.findAll());
        return "pedido/form";
    }

    @PostMapping("cadastrar")
    public String cadastrar(Pedido pedido, RedirectAttributes redirect){
        pedidoRepository.save(pedido);
        redirect.addFlashAttribute("msg", "Cadastrado!");
        return "redirect:/pedido/cadastrar";
    }

    @DeleteMapping("deletar/{id}")
    public String deletar(@PathVariable Long id,Model model) {
        pedidoRepository.deleteById(id);
        model.addAttribute("Pedidos",pedidoRepository.findAll());
        return "pedido/lista";
    }

    @PostMapping("editar")
    public String editBook(Long id, int quantidade, Double valor_uni, Pedido pedido, RedirectAttributes redirect) {
        pedido.setId(id);
        pedido.setQuantidade(quantidade);
        pedido.setValor_uni(valor_uni);
        pedido.setValor_total(valor_uni * quantidade);
        pedidoRepository.save(pedido);
        redirect.addFlashAttribute("msg", "Editado!");
        return "redirect:/";
    } 


    @GetMapping("editar/{id}")
    public String bookListUpdate(@PathVariable (value = "id") Long id, Model model) {
        model.addAttribute("Pedidos", pedidoRepository.findById(id).get());
        return "pedido/edit";
    } 
}
