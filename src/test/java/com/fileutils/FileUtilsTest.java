package com.fileutils;

import com.fileutils.model.Person;
import org.junit.jupiter.api.Test;

import java.net.URL;
import java.util.List;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FileUtilsTest {
    private ClassLoader classLoader = getClass().getClassLoader();

    @Test
    public void testParseToString() {
        URL namesFile = classLoader.getResource("names.csv");

        List<String> names = FileUtils.parseToObject(namesFile.getPath(), Function.identity(), 1);

        assertEquals(3, names.size());
        assertEquals("ali", names.get(0));
    }

    @Test
    public void testParseToObject() {
        URL personsFile = classLoader.getResource("persons.csv");

        List<Person> persons = FileUtils.parseToObject(personsFile.getPath(), mapToPerson, 1);

        assertEquals(2, persons.size());
        assertEquals(new Person("ali", "kilickaya", "Berlin, Germany"), persons.get(0));
        assertEquals(new Person("roberto", "dussman", "Sao Paulo, Brazil"), persons.get(1));
    }

    private Function<String, Person> mapToPerson = line -> {
        String[] columns = line.split(";");
        return new Person(columns[0], columns[1], columns[2]);
    };
}
