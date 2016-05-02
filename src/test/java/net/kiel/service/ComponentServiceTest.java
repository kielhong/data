package net.kiel.service;


import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

import net.kiel.domain.Component;
import net.kiel.domain.ComponentRepository;
import org.junit.Before;
import org.junit.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by kiel on 2016. 4. 25..
 */
public class ComponentServiceTest {
    ComponentRepository componentRepository = mock(ComponentRepository.class);

    /**
     * setup
     */
    @Before
    public void setUp() {
        given(componentRepository.findAll()).willReturn(new ArrayList<Component>(
                Arrays.asList(
                        new Component(0L, "회원", ZonedDateTime.now()),
                        new Component(1L, "업소", ZonedDateTime.now()))));
    }

    @Test
    public void getComponentsShouldList() {
        ComponentService componentService = new ComponentService(componentRepository);

        List<Component> result = componentService.getComponents();

        assertThat(result.size()).isEqualTo(2);
        then(componentRepository).should().findAll();
    }
}
