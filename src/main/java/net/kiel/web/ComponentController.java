package net.kiel.web;

import net.kiel.domain.Component;
import net.kiel.service.ComponentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by kiel on 2016. 4. 28..
 */
@RestController
@RequestMapping("/components")
public class ComponentController {
    @Autowired
    private ComponentService componentService;

    @GetMapping
    public List<Component> list() {
        return componentService.getComponents();
    }
}
