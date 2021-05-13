package vgvr.stocksapp.controller;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import vgvr.stocksapp.model.User;
import vgvr.stocksapp.service.UserService;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.math.BigDecimal;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @SneakyThrows
    @GetMapping("/users")
    public String findAll(Model model)  {
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "allUsers";
    }
    @GetMapping("/signup")
    public String signUpForm(User user, Model model){
        model.addAttribute("status","register");
        return "signup";
    }

    @GetMapping("/signin")
    public String signInForm(User user, Model model){
        model.addAttribute("status","signin");
        return "signin";
    }
    @PostMapping("/signin")
    public String authorizeUser(User user, Model model){
        try {
            User foundedUser = userService.findByEmailPassword(user);
            if(foundedUser!=null){
                model.addAttribute("status","success");
                User.setIdUser(userService.findByEmailPassword(user).getId());
                System.out.println("success");
            }
            else{
                model.addAttribute("status","notexist");
                System.out.println("not");
            }

        }catch (Exception e){
            System.out.println("Error");
            model.addAttribute("status","error");
        }
        return "signin";
    }
    @GetMapping("/account")
    public String accountForm(Model model){
        User user =  userService.findById(User.getIdUser());
        System.out.println("_______");
        System.out.println(user.getFirstName());
        System.out.println("_______");
        model.addAttribute("user", user);
        return "account";
    }
    @GetMapping("/changePassword")
    public String changePasswordForm(Model model){
        User user =  userService.findById(User.getIdUser());
        model.addAttribute("status","register");
        model.addAttribute("user", user);
        return "changePassword";
    }
    @PostMapping("/changePassword")
    public String changePassword(Model model, User user){
       /* User old = userService.findById(User.getIdUser());
        old.setPassword(user.getPassword());
        userService.updateUser(old.getId(), old.getPassword());*/
        model.addAttribute("status","saved");
        return "changePassword";
    }
    @PostMapping("/changeCredentials")
    public String changeCredentials(Model model){
        return "account";
    }
    @PostMapping("/signup")
    public String saveUser(User user, Model model){
        try {
            if(userService.exist(user)){
                userService.save(user);
                model.addAttribute("status","saved");
                System.out.println("saved");
            }
            else{
                model.addAttribute("status","email");
                System.out.println("error");
            }

        }catch (Exception e){
            System.out.println("Error");
            model.addAttribute("status","error");
        }
        return "signup";
    }
    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model){
        userService.deleteById(id);
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "allUsers";
    }
}
