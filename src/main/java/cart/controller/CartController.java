package cart.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cart.domain.Cart;
import cart.repository.CartRepository;
import cart.service.CartService;
import lombok.RequiredArgsConstructor;

// @RestController
@Controller
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    // @GetMapping(value = "/cart")
    // public ResponseEntity<List<Cart>> cartList(Model model) {
    // System.out.println("++++test");
    // return ResponseEntity.ok().body(cartService.getList());
    // }

    @GetMapping(value = "/cart")
    public String cart() {
        return "/cart";
    }

    @PostMapping(value = "/cart/list")
    public ResponseEntity<List<Cart>> cartList() {
        return ResponseEntity.ok().body(cartService.getList());
    }

    @PostMapping(value = "/cart")
    public ResponseEntity<Cart> create(@RequestBody Cart cart) {
        return ResponseEntity.ok().body(cartService.create(cart));
    }

    @DeleteMapping(value = "/cart/{id}")
    public String delete(@PathVariable("id") long id) {
        cartService.delete(id);
        return "redirect:/cart";
    }

    // @GetMapping(value = "/cart")
    // public String cartList(Model model) {
    // System.out.println("++++test");
    // // return ResponseEntity.ok().body(cartService.getList());
    // model.addAttribute("products", response.data.getList());
    // return "/cart";
    // }
}
