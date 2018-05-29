package com.spring.training.controller;

import com.spring.training.model.Player;
import com.spring.training.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.DELETE;

@RestController
public class DeliController {

    @Autowired
    PlayerService playerService;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> listPlayers(){
        List<Player> players = playerService.findAllPlayers();
        if (players == null) {
            return new ResponseEntity<List<Player>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Player>>(players, HttpStatus.OK);
    }

    @RequestMapping(value = "/player/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> getPlayer(@PathVariable("id") Integer id) {
        Player player = playerService.findById(id);
        if (player == null) {
            return new ResponseEntity<Player>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Player>(player, HttpStatus.OK);
    }

    @RequestMapping(value = "/player", method = RequestMethod.POST)
    public ResponseEntity<Void> savePlayer(@RequestBody Player player, UriComponentsBuilder ucBuilder){
        playerService.savePlayer(player);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/player/{id}").buildAndExpand(player.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/player/{id}", method = DELETE)
    public ResponseEntity<Void> deletePlayer(@PathVariable("id") Integer id){
        Player player = playerService.findById(id);
        if(player == null){
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        playerService.deletePlayer(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);

    }

}
