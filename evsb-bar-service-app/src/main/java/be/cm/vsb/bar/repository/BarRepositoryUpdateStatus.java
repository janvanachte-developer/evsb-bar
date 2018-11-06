package be.cm.vsb.bar.repository;

import be.cm.vsb.bar.Bar;
import be.cm.vsb.bar.exception.UpdateFailedException;
import org.springframework.data.rest.core.annotation.RestResource;
import springfox.documentation.annotations.ApiIgnore;

public interface BarRepositoryUpdateStatus {

    @ApiIgnore
    @RestResource(exported = false)
    Bar save(String identifier, Bar.BarStatus status) throws UpdateFailedException ;
}
