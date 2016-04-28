package net.kiel.api;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import net.kiel.domain.Component;
import net.kiel.service.ComponentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiel on 2016. 4. 28..
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComponentControllerResponseTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private ComponentService componentService;

    @Test
    public void componentListTest() {
        given(componentService.getComponents()).willReturn(getList());

        ResponseEntity<String> responseEntity =
                testRestTemplate.getForEntity("/components", String.class);

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).contains("회원");
    }

    /**
     * Mock Components List
     * @return Mock List
     */
    public List<Component> getList() {
        List<Component> list = new ArrayList<Component>();
        list.add(new Component(0L, "회원", ZonedDateTime.now()));
        list.add(new Component(1L, "업소", ZonedDateTime.now()));

        return list;
    }
}
