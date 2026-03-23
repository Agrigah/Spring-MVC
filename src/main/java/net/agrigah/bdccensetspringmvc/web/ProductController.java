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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
@Controller
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }

    @GetMapping("/user/index")
    public String index(Model model,
                        @RequestParam(name = "page", defaultValue = "0") int page,
                        @RequestParam(name = "size", defaultValue = "5") int size,
                        @RequestParam(name = "keyword", defaultValue = "") String keyword) {

        Page<Product> pageProducts =
                productRepository.findByNameContains(keyword, PageRequest.of(page, size));

        model.addAttribute("products", pageProducts.getContent());
        model.addAttribute("pages", new int[pageProducts.getTotalPages()]);
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);

        return "products";
    }
    @GetMapping("/admin/formProducts")
    public String formProducts(Model model) {
        model.addAttribute("product", new Product());
        return "formProducts";
    }

    @PostMapping("/admin/save")
    public String save(Model model, @Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) return "formProducts";
        productRepository.save(product);
        return "redirect:/index";
    }

    @GetMapping("/admin/delete")
    public String delete(Long id, String keyword, int page) {
        productRepository.deleteById(id);
        return "redirect:/index?page=" + page + "&keyword=" + keyword;
    }

    @GetMapping("/editProduct")
    public String editProduct(Model model, Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product == null) throw new RuntimeException("Produit introuvable");
        model.addAttribute("product", product);
        return "formProducts";
    }
    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }
}