package net.youssouf.bdcc_spring_boot.web;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import net.youssouf.bdcc_spring_boot.entities.Product;
import net.youssouf.bdcc_spring_boot.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping("/user/index")
    public String index(Model model) {
        List<Product> products = productRepository.findAll();
        model.addAttribute("products", products);
        return "products";
    }
    @GetMapping("/admin/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        productRepository.deleteById(id);
        return "redirect:/user/index";
    }
    @GetMapping("/")
    public String home() {
        return "redirect:/user/index";
    }
    @GetMapping("/admin/newProduct")
    public String newProduct(Model model) {
        model.addAttribute("product", new Product());
        return "new-Product";
    }
    @PostMapping("/admin/save")
    public String save(@Valid Product product, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) { return "new-Product"; }
        productRepository.save(product);
        return "redirect:/admin/newProduct";
    }
    @GetMapping("/notAuthorized")
    public String notAuthorized() {
        return "notAuthorized";
    }
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        session.setAttribute("user", null);
        return "login";
    }
    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model) {
        Product product = productRepository.findById(id).
                orElseThrow(() -> new IllegalArgumentException("ID invalide : " + id));
        model.addAttribute("product", product);
        return "new-Product";
    }
}
