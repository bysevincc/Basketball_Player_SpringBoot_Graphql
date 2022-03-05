package com.example.BasketballPlayer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;

@Component
public class Mutation implements GraphQLMutationResolver{
	private PlayerRepository playerRepository;
	
	@Autowired
	public Mutation(PlayerRepository playerRepository) {
		this.playerRepository=playerRepository;
	}

	public Player createPlayer(String playerName, String playerSurname,String playerPosition) {
		Player player=new Player();
		player.setPlayerName(playerName);
		player.setPlayerSurname(playerSurname);
		player.setPlayerPosition(playerPosition);
		playerRepository.save(player);
		

		return player;
	}
	public boolean deletePlayer(Long id) {
		playerRepository.deleteById(id);
		return true;
	}

}
