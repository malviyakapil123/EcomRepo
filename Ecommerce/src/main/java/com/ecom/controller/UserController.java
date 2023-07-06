package com.ecom.controller;

import com.ecom.Entity.Product;
import com.ecom.Entity.Userdto;
import com.ecom.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
  private final UserRepo userRepo;

    public UserController(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    @PostMapping("/save")
    public Userdto add(@RequestBody Userdto user){
        return userRepo.save(user);
    }
    @GetMapping("all")
    public List<Userdto> getAllProducts() {

        return userRepo.findAll();
    }
    @PostMapping("login")
    public String login(@RequestBody Userdto user){

   Userdto  user1=  userRepo.findByLoginId(user.getLoginId());

     if (user1!=null){
         if (user.getPassword().equals(user1.getPassword())){
             return "Login SuccessFully";
         }
         else {
             return "Invalid LoginId And Password";
         }



     }
     else {
         return "Invalid LoginId And Password";
     }



    }

}
