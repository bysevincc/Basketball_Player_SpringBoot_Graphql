package com.example.BasketballPlayer;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity

public class Player {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)	
	private Long id ;
	
	@Column(name = "playerName", nullable = false)
	private String playerName ;
	
	@Column(name = "playerSurname", nullable = false)
	private String playerSurname ;
	
	@Column(name = "playerPosition", nullable = false)
	private String playerPosition ;
	
	public Player() {
		
	}
	public Player(Long id) {
		this.id=id;
	}
	
	public Player(String playerName,String playerSurname,String playerPosition) {
		this.playerName=playerName;
		this.playerSurname=playerSurname;
		this.playerPosition=playerSurname;
		}
	public Long getId() {
		return id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPlayerSurname() {
		return playerSurname;
	}

	public void setPlayerSurname(String playerSurname) {
		this.playerSurname = playerSurname;
	}

	public String getPlayerPosition() {
		return playerPosition;
	}

	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}
@Override
public String toString() {
	return "Player [id="+id+",playerName="+playerName+",playerSurname="+playerSurname+",playerPosition="+playerPosition+"]";
}
}
