package corp.data.data.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/demo")
public class ControllerPrueba {

    @PostMapping(path = "/add")
    public @ResponseBody String addNewUser (@RequestParam String name, @RequestParam String email){
        return "saved";
    }

    @GetMapping("/conocimientos/getByid/{id}")
    public String getByid(@PathVariable String id) {
        return id;
    }

}
