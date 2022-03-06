import java.io.IOException;
import org.springframework.boot.test.mock.mockito.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import com.example.BasketballPlayer.Mutation;
import com.example.BasketballPlayer.Player;
import com.example.BasketballPlayer.PlayerRepository;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

import kotlin.reflect.jvm.internal.impl.resolve.constants.IntValue;
import kotlin.reflect.jvm.internal.impl.resolve.constants.LongValue;

import com.graphql.spring.boot.test.*;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.mock.mockito.*;


import java.io.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;
@GraphQLTest
public class PlayerMutationIntTest {

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;
 
    @MockBean
    Mutation mutationMock;
    
    static Player player = new Player();
    private static final String TEST_USERNAME = "Furkan";
    private static final String TEST_SURNAME = "Korkmaz";
    private static final String TEST_POSITION = "PF";
    private static final Long ID=(long) 4;

    @BeforeAll
    static void setUp() {
    	player.setPlayerName(TEST_USERNAME);
    	player.setPlayerSurname(TEST_SURNAME);
    	player.setPlayerPosition(TEST_POSITION);
    }

    @Test
    public void createPlayer() throws IOException {
        doReturn(player).when(mutationMock).createPlayer(TEST_USERNAME, TEST_SURNAME,TEST_POSITION);
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/create-player.graphql");
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.createPlayer.id")).isNotNull();
        assertThat(response.get("$.data.createPlayer.playerName")).isEqualTo(TEST_USERNAME);
        assertThat(response.get("$.data.createPlayer.playerSurname")).isEqualTo(TEST_SURNAME);
        assertThat(response.get("$.data.createPlayer.playerPosition")).isEqualTo(TEST_POSITION);

    }
    @Test
    @WithMockUser
    public void deletePlayer() throws IOException {
        doReturn(player).when(mutationMock).deletePlayer(ID);
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/delete-user.graphql");
        assertThat(response.isOk()).isTrue();
        assertThat(response.get("$.data.deleteUser.id")).isNotNull();
        assertThat(response.get("$.data.deleteUser.username")).isEqualTo(TEST_USERNAME);

    }

}
