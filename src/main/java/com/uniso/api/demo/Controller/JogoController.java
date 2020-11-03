package com.uniso.api.demo.Controller;

import com.uniso.api.demo.Model.Jogo;
import com.uniso.api.demo.Service.JogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
public class JogoController {

    @Autowired
    private JogoService _js;

    @PostMapping
    public Jogo adicionar(@RequestBody Jogo jogo) {
        Jogo jg = _js.cadastrarNovoJogo(jogo);

        return jg;
    }

    @GetMapping
    public List<Jogo> listar() {
        List<Jogo> jogos = _js.listarJogo();

        return jogos;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> obterJogo(@PathVariable(value = "id") Long id) {
        Jogo jg = _js.obterJogo(id);

        if (jg != null) {
            return new ResponseEntity<>(jg, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizarJogo(@PathVariable(value = "id") Long id) {
        Jogo jg = _js.obterJogo(id);

        if (jg != null) {
            _js.cadastrarNovoJogo(jg);

            return new ResponseEntity<>(jg, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Jogo> deletarJogo(@PathVariable(value = "id") Long id) {
        Jogo jg = _js.obterJogo(id);

        if (jg != null) {
            _js.deletarJogo(jg);

            return new ResponseEntity<>(jg, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
