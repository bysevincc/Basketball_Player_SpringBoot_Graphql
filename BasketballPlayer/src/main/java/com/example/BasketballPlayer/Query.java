package com.example.BasketballPlayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;

@Component
public class Query implements GraphQLQueryResolver{

	private PlayerRepository playerRepository;
	
	@Autowired
	public Query(PlayerRepository playerRepository) {
		this.playerRepository=playerRepository;
		
	}
	
	public Iterable<Player> findAllPlayers(){
		return playerRepository.findAll();
	}
	public Optional<Player> findByIdPlayer(Long id) {
	return	playerRepository.findById(id);
		
	}
}
