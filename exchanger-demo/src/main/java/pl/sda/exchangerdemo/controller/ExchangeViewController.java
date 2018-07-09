package pl.sda.exchangerdemo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExchangeViewController {

    @GetMapping("/")
    public String getEchnageView() {
        return "index.html";
    }
}
