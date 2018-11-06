package be.cm.vsb.bar.controller;

import be.cm.vsb.bar.Bar;
import be.cm.vsb.bar.exception.UpdateFailedException;
import be.cm.vsb.bar.repository.BarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.*;

@BasePathAwareController
@ExposesResourceFor(Bar.class)
@RequestMapping("/bars")
@ResponseBody
public class BarControllerUpdataStatusFragment {

    private final BarRepository barRepository;

    @Autowired
    public BarControllerUpdataStatusFragment(BarRepository barRepository) {
        this.barRepository = barRepository;
    }

    @PatchMapping("/{identifier}/status")
    public Resource<Bar> updateStatus(@PathVariable String identifier, @RequestBody Bar.BarStatus status) throws UpdateFailedException {
        return new Resource<>(barRepository.save(identifier, status));
    }
}
