package guru.springframework.springrestclientexamples.controllers;

import guru.springframework.springrestclientexamples.services.ApiService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ServerWebExchange;

@Controller
@Slf4j
@AllArgsConstructor
public class UserController {

    private final ApiService apiService;

    @RequestMapping({"","/","/index"})
    public String index(){
        return "index";
    }

    @PostMapping("/users/")
    public String formPost(Model model){
//        public String formPost(Model model, ServerWebExchange serverWebExchange){
//        MultiValueMap<String, String> map = serverWebExchange.getFormData().block();

//        Integer id = new Integer(map.get("id").get(0));
//
//        log.debug("Received id value: "+id);

        model.addAttribute("users", apiService.getUsers());

        return "userList";
    }

}
