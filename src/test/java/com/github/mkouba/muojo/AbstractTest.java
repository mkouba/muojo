package com.github.mkouba.muojo;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.ElementType;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Martin Kouba
 */
public abstract class AbstractTest {

    private StringBuilder output;

    @Before
    public void before() {
        output = new StringBuilder();
    }

    @After
    public void after() throws IOException {
        Files.write(new File("target", getOutputFilename()).toPath(), output
                .toString().getBytes());
    }

    @Test
    public void testSize() {

        printSize(new Object());
        printSize(Boolean.FALSE);

        printTitle("Numbers");
        printSize(Long.MAX_VALUE);
        printSize(BigDecimal.ONE);
        printSize(BigDecimal.valueOf(System.currentTimeMillis()));

        printTitle("Strings and arrays");
        printSize("Hello");
        printSize("Hello Sušice!");
        printSize(new StringBuffer().append("hello"));
        printSize(new StringBuilder().append("hello"));
        String[] stringArray = new String[] { "foo", "bar", "baz" };
        printSize("Array of " + Arrays.toString(stringArray), stringArray);
        printSize("Empty array of size 10", new String[10]);

        printTitle("Time");
        printSize(new Date());
        Calendar calendarNow = Calendar.getInstance();
        calendarNow.setTime(new Date());
        printSize(Calendar.class.getName() + "[" + calendarNow.getTime() + "]",
                calendarNow);
        printSize(LocalDateTime.now());

        printTitle("Collections");
        List<String> stringList = new ArrayList<>();
        fillCollection(stringList);
        printSize(stringList);
        printSize("Empty ArrayList with capacity of 100 ", new ArrayList<>(100));
        Set<String> stringSet = new HashSet<>();
        fillCollection(stringSet);
        printSize(stringSet);

        printTitle("Enums");
        printSize(ElementType.ANNOTATION_TYPE);

    }

    abstract long getShallowSize(Object reference);

    abstract long getDeepSize(Object reference);

    abstract String getOutputFilename();

    private void printSize(Object reference) {
        printSize(null, reference);
    }

    private void fillCollection(Collection<String> collection) {
        collection.add("foo");
        collection.add("bar");
        collection.add("baz");
    }

    protected static void printStart(String title) {
        System.out.println(new StringBuilder().append(System.lineSeparator())
                .append(System.lineSeparator()));
        String separator = title.chars().mapToObj((val) -> "=")
                .collect(Collectors.joining());
        System.out.println(separator + System.lineSeparator() + title
                + System.lineSeparator() + separator);
    }

    protected void printTitle(String title) {
        String separator = title.chars().mapToObj((val) -> "=")
                .collect(Collectors.joining());
        println(separator + System.lineSeparator() + title
                + System.lineSeparator() + separator);
    }

    private void printSize(String description, Object reference) {
        if (description == null) {
            description = new StringBuilder()
                    .append(reference.getClass().getName()).append(" [")
                    .append(reference.toString()).append("]").toString();
        }
        long deep = getDeepSize(reference);
        long shallow = getShallowSize(reference);
        println(String.format("%s, %s/%s (+%s) bytes", description, shallow,
                deep, deep - shallow));
    }

    private void println(String text) {
        output.append(text).append(System.lineSeparator());
        System.out.println(text);
    }

}
