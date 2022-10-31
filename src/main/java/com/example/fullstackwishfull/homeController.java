package com.example.fullstackwishfull;
import com.example.fullstackwishfull.UserPackage.service.userService;
import com.example.fullstackwishfull.WishPackage.model.Wishlist;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;

@Controller
public class homeController {


  userService uService = new userService();

  @GetMapping("/")
  public String frontpage() {
    return "Frontpage";
  }

  @GetMapping("/login")
  public String login() {
    return "Login";
  }

  @PostMapping("/login") //send bruger info til profile
  public String userValidate(WebRequest req, Model model) {

    if (uService.findUser(req, model) == 0)
      return "Login";
    else
      return "Profile";

  }
  @GetMapping("/signup")
  public String signup() {
    return "SignUp";
  }

  @PostMapping("/signup")
  public String create(WebRequest req) {

    uService.create(req);

    return "redirect:/wishlists";
  }

  @GetMapping("/profile")
  public String profile() {
    return "Profile";
  }


  @GetMapping("/wishlists")
  public String viewWishlists(Model model) {
    model.addAttribute("wishlists", uService.getwService().userWishlist());

    return "AllWishlists";
  }

  @PostMapping("/wishlists")
  public String viewWishlists(WebRequest req, Model model) {
    model.addAttribute("wishlistTitle", req.getParameter("wishlistTitle"));

    System.out.println(req.getParameter("wishlistTitle"));

    uService.getwService().userWishes(req.getParameter("wishlistTitle"));


    return "redirect:/wishlists"; //skal redirectes til wihlist
  }

  @GetMapping ("/addwishlist")
    public String addWishlist(){
    return "AddWishlist" ;
  }

  @PostMapping("/addwishlist")
  public String addWishList(WebRequest req, Model model) {

    model.addAttribute("title", req.getParameter("title"));

    uService.getwService().createWishlist(req);

    return "redirect:/wishlists";
  }

  @GetMapping("/wishlist")
  public String viewWishlist(WebRequest req) {

    return "Wishlist";
  }


  @GetMapping("/addwish")
  public String addWish(WebRequest req) {

    uService.getwService().createWish(req);

    return "AddWish";
  }
}



