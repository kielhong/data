package net.kiel.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * Created by kiel on 2016. 5. 2..
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@Slf4j
public class BugStatusRepositoryTest {
    @Autowired
    TestEntityManager entityManager;
    @Autowired
    BugStatusRepository bugStatusRepository;

    @Before
    public void setUp() {
        entityManager.persist(new BugStatus("open"));
    }

    @Test
    public void findOneShouldReturnBugStatus() {
        BugStatus bugStatus = bugStatusRepository.findOne(1L);

        assertThat(bugStatus).isNotNull();
        assertThat(bugStatus.getStatus()).isEqualTo("open");
    }
}
