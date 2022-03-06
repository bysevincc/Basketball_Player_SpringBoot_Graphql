
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;

import com.example.BasketballPlayer.Player;
import com.example.BasketballPlayer.Query;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

public class UserQueryIntTest {
	@Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

	 @MockBean
	 Query queryMock;
	    static Player player = new Player();
	    private static final String TEST_USERNAME = "Furkan";
	    private static final String TEST_SURNAME = "Korkmaz";
	    private static final String TEST_POSITION = "PF";
	    private static final Long ID=(long) 4;
	    
	    @Test
	    @WithMockUser(username = TEST_USERNAME)
	    public void getPlayer() throws Exception {

	        Player player = new Player();
	        player.setPlayerName(TEST_USERNAME);
	    	player.setPlayerSurname(TEST_SURNAME);
	    	player.setPlayerPosition(TEST_POSITION);
	    	
	        doReturn(player).when(queryMock).findByIdPlayer(ID);

	        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/get-player.graphql");
	        assertThat(response.isOk()).isTrue();
	        assertThat(response.get("$.data.findByIdPlayer.id")).isNotNull();
	        assertThat(response.get("$.data.findByIdPlayer.playerName")).isEqualTo(TEST_USERNAME);
	        assertThat(response.get("$.data.findByIdPlayer.playerSurname")).isEqualTo(TEST_SURNAME);
	        assertThat(response.get("$.data.findByIdPlayer.playerPosition")).isEqualTo(TEST_POSITION);
	    }
}
