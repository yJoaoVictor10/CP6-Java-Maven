package br.com.fiap.bo;

import br.com.fiap.dao.PokemonDAO;
import br.com.fiap.to.PokemonTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PokemonBO {
    private PokemonDAO pokemonDAO;

    public ArrayList<PokemonTO> findAll(){
        pokemonDAO = new PokemonDAO();
        return pokemonDAO.findAll();
    }

    public PokemonTO save(PokemonTO pokemon){
        pokemonDAO = new PokemonDAO();

        if(pokemon.getDataDaCaptura().isAfter(LocalDate.now())){
            return null;
        }else{
            return pokemonDAO.save(pokemon);
        }
    }
}