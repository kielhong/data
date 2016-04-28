package net.kiel.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

import net.kiel.domain.Component;
import net.kiel.domain.ComponentRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kiel on 2016. 4. 25..
 */
public class ComponentServiceTest {
    private ComponentService componentService;

    /**
     * test setUp
     */
    @Before
    public void setUp() {
        List<Component> components = new ArrayList<Component>();
        components.add(new Component(0L, "회원", ZonedDateTime.now()));
        components.add(new Component(1L, "업소", ZonedDateTime.now()));

        ComponentRepository componentRepository = mock(ComponentRepository.class);
        given(componentRepository.findAll()).willReturn(components);

        componentService = new ComponentService(componentRepository);
    }

    @Test
    public void getComponentsShouldList() {
        List<Component> components = componentService.getComponents();

        assertThat(components.size()).isEqualTo(2);
    }
}
