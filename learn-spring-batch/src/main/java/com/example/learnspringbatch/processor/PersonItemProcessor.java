package com.example.learnspringbatch.processor;

import com.example.learnspringbatch.entity.Person;
import org.springframework.batch.item.ItemProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    private static final Logger log = LoggerFactory.getLogger(PersonItemProcessor.class);

    @Override
    public Person process(final Person item) throws Exception {
        final String firstName = item.firstName();
        final String lastName = item.lastName();
        final Person transformedPerson = new Person(firstName.toUpperCase(), lastName.toUpperCase());

        log.info("Converting (" + item + ") into (" + transformedPerson + ")");
        return transformedPerson;
    }
}
