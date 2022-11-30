package com.nomad.algorithm;

import com.nomad.algorithm.service.StringList;
import com.nomad.algorithm.service.StringListImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


class StringListImplTest {
    private StringList stringList;
    private static String first = "New string1";
    private static String second = "New string2";
    private static String test = "New string3";

    @BeforeEach
    void setUp() {
        {
            stringList = new StringListImpl(3);
            stringList.add(first);
            stringList.add(second);
        }

    }


    @Test
    void addStringToArray() {
        stringList.add(test);
        assertEquals(test,stringList.get(2));
    }

    @Test
    void addStringToArrayIndex() {
        stringList.add(0, test);
        assertEquals(test, stringList.get(0));
        assertEquals(first, stringList.get(1));
        assertEquals(second, stringList.get(2));
        assertEquals(3, stringList.size());
    }

    @Test
    void setStringToArray() {
        stringList.set(0, test);
        assertEquals(test, stringList.get(0));
    }

    @Test
    void arrayRemove() {
        stringList.remove(first);
        assertEquals(1, stringList.size());
        assertEquals(second, stringList.get(0));
    }

    @Test
    void arrayRemoveIndex() {
        stringList.remove(0);
        assertEquals(1, stringList.size());
        assertEquals(second, stringList.get(0));
    }

    @Test
    void arrayContains() {
        assertTrue(stringList.contains(first));
    }

    @Test
    void arrayIndexOf() {
        assertEquals(0, stringList.indexOf(first));
    }

    @Test
    void arrayLastIndexOf() {
        stringList.add(first);
        assertEquals(2, stringList.lastIndexOf(first));
    }

    @Test
    void arrayGet() {
        assertEquals(first, stringList.get(0));
    }

    @Test
    void arrayTestEquals() {
        StringListImpl check = new StringListImpl(2);
        check.add(first);
        check.add(second);
        assertTrue(stringList.equals(check));
    }

    @Test
    void size() {

        assertEquals(2, stringList.size());
    }

    @Test
    void arrayIsEmpty() {
        stringList.clear();
        assertTrue(stringList.isEmpty());
    }

    @Test
    void arrayClear() {
        stringList.clear();
        assertEquals(0, stringList.size());
    }

}