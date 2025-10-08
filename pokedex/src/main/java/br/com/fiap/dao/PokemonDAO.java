package br.com.fiap.dao;

import br.com.fiap.to.PokemonTO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

    public PokemonTO save(PokemonTO pokemon){
        String sql = "INSERT INTO ddd_pokemons(nome, altura, peso, categoria, data_da_captura) VALUES (?, ?, ?, ?, ?)";
        try(PreparedStatement ps = ConnectionFactory.getConnection().prepareStatement(sql)) {
            ps.setString(1, pokemon.getNome());
            ps.setDouble(2, pokemon.getAltura());
            ps.setDouble(3, pokemon.getPeso());
            ps.setString(4, pokemon.getCategoria());
            ps.setDate(5, Date.valueOf(pokemon.getDataDaCaptura()));
            if(ps.executeUpdate() > 0){
                return pokemon;
            }else{
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }finally {
            ConnectionFactory.closeConnection();
        }
        return null;
    }
}
