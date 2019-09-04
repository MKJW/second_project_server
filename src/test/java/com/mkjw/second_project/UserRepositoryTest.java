package com.mkjw.second_project;

import com.mkjw.second_project.persistence.User;
import com.mkjw.second_project.persistence.UserRepository;
import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

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

        User user = users.get(0);

        Assert.assertThat(user.getUser_id(), Is.is("qwebnm7788"));
        Assert.assertThat(user.getType(), Is.is("STUDENT"));*/
    }
}
