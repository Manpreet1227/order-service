package com.restroapp.order.service;

import com.restroapp.order.entity.Sequence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import static com.mongodb.client.model.Filters.where;
//import static com.mongodb.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Query.query;

@Service
public class SequenceGenerator {

    @Autowired
    private MongoOperations mongoOperations;

    public int generateNextOrderId(){

        Sequence counter = mongoOperations.findAndModify(
                query(Criteria.where("_id").is("sequence")),
                new Update().inc("sequence", 1),
                options().returnNew(true).upsert(true),
                Sequence.class);
        assert counter != null;
        return counter.getSequence();
    }
}


