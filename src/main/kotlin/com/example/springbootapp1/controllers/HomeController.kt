package com.example.springbootapp1.controllers

import com.example.springbootapp1.models.Dados
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.servlet.ModelAndView
import java.time.LocalDateTime

@Controller
@RequestMapping("/home")
class HomeController {

    @GetMapping("/hello")
    fun Ola() : String {
        return "OlaMundo"
    }

    @GetMapping("/PassandoValores")
    fun PassandoValores() : ModelAndView {
        val mv: ModelAndView = ModelAndView("PassandoValores")
        mv.addObject("texto", "Texto Gerado no Controller")
        mv.addObject("numero", 30)
        mv.addObject("dataHora", LocalDateTime.now())
        return mv
    }

    // Exemplo com Post
    @GetMapping("/MandarDados")
    fun ReceberDados(@ModelAttribute dados: Dados) : ModelAndView {
        val mv: ModelAndView = ModelAndView("MandarDados")
        mv.addObject("dados", Dados())
        mv.addObject("nome", dados.nome)
        mv.addObject("email", dados.email)
        mv.addObject("numero", dados.numero)
        return mv
    }
}