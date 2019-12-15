package com.mkjw.second_project;

import com.mkjw.second_project.repository.UserRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTest {

    @Autowired
    UserRepository userRepository;

    @After
    public void cleanup() {
        userRepository.deleteAll();
    }

    @Test
    public void 사용자저장_확인() {
        /*userRepository.save(User.builder()
                .userId("qwebnm7788")
                .firstName("Jaewon")
                .lastName("Choi")
                .email("qwebnm7788@naver.com")
                .type("STUDENT")
                .phone("010-1234-1234")
                .schoolId("SCHOOL_ID")
                .build());

        List<User> users = userRepository.findAll();

        User dto = users.get(0);

        Assert.assertThat(dto.getUser_id(), Is.is("qwebnm7788"));
        Assert.assertThat(dto.getType(), Is.is("STUDENT"));*/
    }
}
