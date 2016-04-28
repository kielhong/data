package net.kiel.service;

import net.kiel.domain.Component;
import net.kiel.domain.ComponentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kiel on 2016. 4. 25..
 */
@Service
public class ComponentService {
    private ComponentRepository componentRepository;

    @Autowired
    public ComponentService(ComponentRepository componentRepository) {
        this.componentRepository = componentRepository;
    }

    public List<Component> getComponents() {
        return componentRepository.findAll();
    }


}
