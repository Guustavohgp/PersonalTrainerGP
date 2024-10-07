package com.personaltrainerweb.personaltrainerweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller  // Certifique-se de que a classe está anotada como @Controller
public class TreinoController {  // Nome da classe deve estar de acordo com a convenção
    
    @GetMapping("/gerarTreino")
    public String gerarTreino(
            @RequestParam("nome") String nome,
            @RequestParam("idade") int idade,
            @RequestParam("sexo") String sexo,
            @RequestParam("biotipo") String biotipo,
            @RequestParam("dias") int dias,
            @RequestParam("tipoTreino") String tipoTreino,
            @RequestParam("nivel") String nivel,
            Model model) {
        
        // Lógica para gerar o plano de treino com base nos parâmetros
        String treinoGerado = "Aqui está seu treino personalizado..."; // Lógica de geração do treino

        // Adiciona os atributos ao modelo para serem acessados no front-end
        model.addAttribute("nome", nome);
        model.addAttribute("idade", idade);
        model.addAttribute("sexo", sexo);
        model.addAttribute("biotipo", biotipo);
        model.addAttribute("dias", dias);
        model.addAttribute("tipoTreino", tipoTreino);
        model.addAttribute("nivel", nivel);
        model.addAttribute("treinoGerado", treinoGerado);

        return "result";  // Nome da página HTML que será renderizada
    }
}