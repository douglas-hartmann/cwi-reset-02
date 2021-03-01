package br.com.cwi.reset.exemploreset;


import org.springframework.web.bind.annotation.*;

@RestController()
public class NomeController {

    private static String nome="CWI-RESET-02";

    @GetMapping("/nome")
    public String nomeContrller(){
        return nome;
    }

    @PutMapping("/nome/{mudarNome}")
    public String mudarNome(@PathVariable String mudarNome){
        this.nome=mudarNome;
        return nome;
    }

    @DeleteMapping("/nome")
    public void deletarNome(){
        this.nome=null;
    }





}
