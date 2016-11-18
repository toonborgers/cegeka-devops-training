package be.cegeka.devops.training.model;

import be.cegeka.devops.training.AbstractIntegrationTest;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PersonRepositoryIntegrationTest extends AbstractIntegrationTest {
    @Autowired
    private PersonRepository personRepository;

    @Before
    public void setUp() {
        personRepository.deleteAll();
    }

    @Test
    public void canWireRepository() {
        assertThat(personRepository).isNotNull();
    }

    @Test
    public void canInsertAndDeletePersons() {
        Person jos = new Person("Smos", "Jos");
        Person patrick = new Person("Verstraeten", "Patrick");

        personRepository.save(jos);
        personRepository.save(patrick);

        List<Person> actual = personRepository.findAll();

        assertThat(actual).containsOnly(jos, patrick);
    }

}