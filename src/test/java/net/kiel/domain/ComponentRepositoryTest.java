package net.kiel.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiel on 2016. 4. 25..
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ComponentRepositoryTest {
    @Autowired
    private ComponentRepository componentRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private BugStatusRepository bugStatusRepository;
    @Autowired
    private BugRepository bugRepository;

    @Test
    public void multipleComponentShouldBeIncludedInBug() {
        Account account = new Account("보고자");
        accountRepository.save(account);
        BugStatus status = new BugStatus("TODO");
        bugStatusRepository.save(status);
        Component component1 = new Component(0L, "회원", ZonedDateTime.now());
        componentRepository.save(component1);
        Component component2 = new Component(1L, "업소", ZonedDateTime.now());
        componentRepository.save(component2);

        Bug bug = new Bug();
        bug.setReporter(account);
        bug.setStatus(status);
        List<Component> components = new ArrayList<Component>();
        components.add(component1);
        components.add(component2);
        bug.setComponents(components);

        bugRepository.save(bug);

        Bug savedBug = bugRepository.findOne(bug.getId());
        assertThat(savedBug.getComponents().size()).isEqualTo(2);
    }
}
