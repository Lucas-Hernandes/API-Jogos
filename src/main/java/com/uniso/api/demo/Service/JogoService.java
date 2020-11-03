package com.uniso.api.demo.Service;

import com.uniso.api.demo.Model.Jogo;
import com.uniso.api.demo.Repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogoService {

    @Autowired
    private JogoRepository _jr;

    public Jogo cadastrarNovoJogo(Jogo jogo) {
        _jr.save(jogo);
        return jogo;
    }

    public Jogo obterJogo(Long id) {
        Jogo jogo = _jr.findById(id).get();

        return jogo;
    }

    public List<Jogo> listarJogo() {
        return _jr.findAll();
    }

    public void deletarJogo(Jogo jogo) {
        _jr.deleteById(jogo.getId());
    }
}
