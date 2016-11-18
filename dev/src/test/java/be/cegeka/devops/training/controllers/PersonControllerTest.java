package be.cegeka.devops.training.controllers;

import be.cegeka.devops.training.model.Person;
import be.cegeka.devops.training.model.PersonRepository;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PersonControllerTest {
    private static final Person PATRICK = new Person("Verboven", "Patrick");
    private static final Person RUDY = new Person("Desmet", "Rudy");
    private static final String ID = "id";

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    private PersonRepository repository;

    private PersonController controller;

    @Before
    public void setUp() {
        controller = new PersonController(repository);
    }

    @Test
    public void canGetAllPersons() {
        when(repository.findAll()).thenReturn(asList(PATRICK, RUDY));

        List<Person> actual = controller.getAll();

        assertThat(actual).containsOnly(PATRICK, RUDY);
    }

    @Test
    public void canGetSinglePerson() {
        when(repository.findOne(ID)).thenReturn(RUDY);

        assertThat(controller.getSinglePerson(ID)).isEqualTo(RUDY);
    }

    @Test
    public void canInsertPerson() {
        controller.insertPerson(PATRICK);

        verify(repository).save(PATRICK);
    }


}