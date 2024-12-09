package pl.uken.krakow.web_service.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.uken.krakow.web_service.model.Commitet;

@Controller
@RequestMapping("/sejm")
public class SejmController {
        @GetMapping("/committets")
    public String getAllCommittetsView(Model model){
        String url = "https://api.sejm.gov.pl/sejm/term10/committees";
        RestTemplate rest = new RestTemplate();
        String result = rest.getForObject(url, String.class);
        ObjectMapper mapper = new ObjectMapper(); 
        Commitet[] committets = null;
        try {
            committets = mapper.readValue(result, Commitet[].class);
            System.out.println(committets[0].getCode());
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        model.addAttribute("committets", committets);
        return "committets_list";
    }
}
