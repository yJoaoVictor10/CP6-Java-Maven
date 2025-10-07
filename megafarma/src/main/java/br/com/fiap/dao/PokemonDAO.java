package br.com.fiap.dao;

import br.com.fiap.to.PokemonTO;

import java.time.LocalDate;
import java.util.ArrayList;

public class PokemonDAO {
    public ArrayList<PokemonTO> findAll(){
        ArrayList<PokemonTO> pokemons = new ArrayList<PokemonTO>();
        PokemonTO pokemon = new PokemonTO(1L, "Pikachu", 1.3, 1.5, "Elétrico",
                LocalDate.parse("2025-10-07"));
        pokemons.add(pokemon);

        pokemon = new PokemonTO(2L, "Charmander", 1.4, 1.7, "Fogo",
                LocalDate.parse("2025-10-09"));
        pokemons.add(pokemon);

        return pokemons;
    }
}
