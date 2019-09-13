package br.com.alura.forum;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.alura.forum.security.service.UsersService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AluraForumApplicationTests {
	
	@Autowired
	private UsersService usersService;

	@Test
	public void contextLoads() {
		assertThat(usersService).isNotNull();
		assertThat(usersService).isInstanceOf(UserDetailsService.class);
	}

}
