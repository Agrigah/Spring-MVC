package net.agrigah.bdccensetspringmvc.web;

import jakarta.validation.Valid;
import net.agrigah.bdccensetspringmvc.entities.Product;
import net.agrigah.bdccensetspringmvc.repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index(Model model,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {
        model.addAttribute("products", productRepository.findByNameContains(keyword));
        model.addAttribute("keyword", keyword);
        return "products";
    }

    @GetMapping("/formProducts")
    public String formProducts(Model model) {
        model.addAttribute("product", new Product());
        return "formProducts";
    }

    @PostMapping("/save")
    public String save(Model model, @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formProducts";
        productRepository.save(product);
        return "redirect:/index";
    }

    @GetMapping("/delete")
    public String delete(Long id) {
        productRepository.deleteById(id);
        return "redirect:/index";
    }

    @GetMapping("/editProduct")
    public String editProduct(Model model, Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) throw new RuntimeException("Produit introuvable");
        model.addAttribute("product", product);
        return "formProducts";
    }
}