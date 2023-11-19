package com.example.preproject231.controller;

import com.example.preproject231.model.User;
import com.example.preproject231.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //6. Используйте только GET/POST маппинги
    //Как я понимаю, это не очень правильно идеологически, во всяком случае, если верить вот этому видео
    //www.youtube.com/watch?v=D58pIymCew4

    @GetMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("users", userService.index());
        model.addAttribute("newUser", new User());
        return "users";
    }
    //7. Используйте ReqestParam аннотацию, использование аннотации PathVariable запрещено
    //Кажется, в этот раз ничего не забыл.

    @PostMapping("/create")
    public String create(@ModelAttribute("user") User user) {
        userService.create(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String edit(Model model, @RequestParam("id") int id) {
        model.addAttribute("user", userService.read(id));
        return "edit";
    }

    //Put просто ради того чтобы оба маппинга были привязаны к настройке, которую пришлось изменить,
    //чтобы они работали, или есть какая-то причина использовать конкретно для этого варианта обновления
    //именно put, а не patch?
    @PutMapping("/update")
    public String update(@ModelAttribute("user") User user, @RequestParam("id") int id) {
        userService.update(id, user);
        return "redirect:/";
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam("id") int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
