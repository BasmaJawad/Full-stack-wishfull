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

// ALLE ØNSKELISTER PÅ DISPLAY
  @GetMapping("/wishlists")
  public String viewWishlists(Model model) {
    model.addAttribute("wishlists", uService.getwService().userWishlist());

    return "AllWishlists";
  }

  @PostMapping("/wishlists")
  public String viewWishlists(WebRequest req, Model model) {
    model.addAttribute("wishlistTitle", req.getParameter("wishlistTitle"));

    uService.getwService().setWishlistTitle(req.getParameter("wishlistTitle"));

    return "redirect:/wishlist"; //skal redirectes til wihlist
  }


  //TILFØJELSE AF ØNSKELISTE POPUP SIDE
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

  @GetMapping("/addwish")
  public String addWish() {
    return "AddWish";
  }

  @PostMapping("/addwish")
  public String addWish(WebRequest req, Model model) {
    model.addAttribute("title", req.getParameter("title"));
    model.addAttribute("description", req.getParameter("description"));
    model.addAttribute("price", req.getParameter("price"));
    model.addAttribute("link", req.getParameter("link"));

    uService.getwService().createWish(req);
    return "redirect:/wishlist";
  }

  @GetMapping("/wishlist")
  public String viewWishlist(Model model) {

    model.addAttribute("wishlist", uService.getwService().userWishes());
    System.out.println(uService.getwService().userWishes());
    return "Wishlist";
  }

}



