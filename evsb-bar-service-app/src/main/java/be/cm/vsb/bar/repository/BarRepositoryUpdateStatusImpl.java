package be.cm.vsb.bar.repository;

import be.cm.vsb.bar.Bar;
import be.cm.vsb.bar.exception.UpdateFailedException;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.rest.core.annotation.RestResource;
import springfox.documentation.annotations.ApiIgnore;

import java.lang.reflect.Modifier;

public class BarRepositoryUpdateStatusImpl implements BarRepositoryUpdateStatus {

    @Autowired
    MongoTemplate mongoTemplate;

    @ApiIgnore
    @RestResource(exported = false)
    @Override
    public Bar save(String identifier, Bar.BarStatus status) throws UpdateFailedException {

        Query query = new Query(Criteria.where("_id").is(identifier));

        Update update = new Update();
        update.set("status", status);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Bar.class);

        if(result!=null || result.wasAcknowledged()) {
            return mongoTemplate.findOne(query, Bar.class);
        } else {
            throw new UpdateFailedException();
        }
    }
}
