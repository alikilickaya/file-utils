# file-utils

It is a library which helps on file operations such as parsing a csv file to a list of desired objects.

## Build
```console
$ mvn clean package
```

## Usage
```java
public void testParseToObject() {
        URL personsFile = classLoader.getResource("persons.csv");

        List<Person> persons = FileUtils.parseToObject(personsFile.getPath(), mapToPerson, 1);
    }

    private Function<String, Person> mapToPerson = line -> {
        String[] columns = line.split(";");
        return new Person(columns[0], columns[1], columns[2]);
    };
```

Please check `test/java/com/fileutils/FileUtilsTest.java` for more examples

## License
The MIT License (MIT)