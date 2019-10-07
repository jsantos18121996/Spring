package com.example.learningmockito.basics;

import com.example.learningmockito.bean.Game;
import com.example.learningmockito.bean.Player;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class InjectMocksTest {

    @Mock
    Player player;

    @Spy
    List<String> enemies = new ArrayList<>();

    /* @InjectMocks: Using this, Mockito will put that player and enemies into Game */
    @InjectMocks
    Game game;

    @Test
    public void attackWithSwordTest() {
        when(player.getWeapon()).thenReturn("Sword");

        enemies.add("Dragon");
        enemies.add("Orc");

        assertEquals(2, game.numberOfEnemies());
        assertEquals("Player attack with: Sword", game.attack());
    }
}
