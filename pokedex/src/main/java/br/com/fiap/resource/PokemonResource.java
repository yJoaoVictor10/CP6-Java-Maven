package br.com.fiap.resource;

import br.com.fiap.bo.PokemonBO;
import br.com.fiap.to.PokemonTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/pokemon")
public class PokemonResource {
    private PokemonBO pokemonBO = new PokemonBO();
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        ArrayList<PokemonTO> resultado = pokemonBO.findAll();
        Response.ResponseBuilder response = null;
        if(resultado != null){
            response = Response.ok();
        }else{
            response = Response.status(404); // NOT FOUND
        }
        response.entity(resultado);
        return response.build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response save(PokemonTO pokemon){
        PokemonTO resultado = pokemonBO.save(pokemon);
        Response.ResponseBuilder response = null;
        if(resultado != null){
            response = Response.created(null);
        }else{
            response = Response.status(400);
        }
        response.entity(resultado);
        return response.build();
    }
}
