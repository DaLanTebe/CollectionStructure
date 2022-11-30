package Collection.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest {


    @Test
    void add() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
    }

    @Test
    void addIndex() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("5");
        list.add("4");
        list.add("3");

        list.add(0, "1");
        list.add(1, "2");

        assertEquals(5, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("5", list.get(2));
        assertEquals("4", list.get(3));
        assertEquals("3", list.get(4));
    }

    @Test
    void addWrong() {

        try {
            SingleLinkedList<String> list = new SingleLinkedList<>();
            list.add(3, "");
            fail("No exception");
        } catch (IllegalArgumentException exception) {

        }
    }

    @Test
    void set() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.set(3, "5");

        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void setWrong() {
        try {
            SingleLinkedList<String> list = new SingleLinkedList<>();
            list.set(3, "5");
            fail("No exception");
        } catch (IllegalArgumentException exception) {

        }
    }

    @Test
    void indexOf() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertEquals(4, list.indexOf("5"));
        assertEquals(-1, list.indexOf("10"));
    }

    @Test
    void removeOne() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.remove(0);
        assertEquals(0, list.size());
        list.add("5");
        list.add("4");
        list.add("3");
        list.add("2");
        assertEquals(4, list.size());
        assertEquals("5", list.get(0));
        assertEquals("4", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("2", list.get(3));
    }

    @Test
    void removeFirstOfTwoElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals("2", list.get(0));
        list.add(0, "3");
        list.add("4");
        list.add("5");
        assertEquals(4, list.size());
        assertEquals("3", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("4", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeSecondOfTwoElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.remove(1);
        assertEquals(1, list.size());
        assertEquals("1", list.get(0));
        list.add(1, "3");
        list.add("4");
        list.add("5");
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("3", list.get(1));
        assertEquals("4", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeFirstOfMany() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(0);
        assertEquals(3, list.size());
        assertEquals("2", list.get(0));
        assertEquals("3", list.get(1));
        assertEquals("4", list.get(2));
        list.add(0, "5");
        assertEquals(4, list.size());
        assertEquals("5", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
    }

    @Test
    void removeLastOfMany() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(3);
        assertEquals(3, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        list.add(3, "5");
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeOfMany() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        list.remove(2);
        assertEquals(5, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("4", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeElementOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");

        assertTrue(list.remove("1"));
        assertEquals(0, list.size());
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
    }

    @Test
    void removeFirstOfTwoElementsOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");

        assertTrue(list.remove("1"));
        assertEquals(1, list.size());
        assertEquals("2", list.get(0));
        list.add(0, "7");
        list.add("4");
        list.add("5");
        assertEquals(4, list.size());
        assertEquals("7", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("4", list.get(2));
        assertEquals("5", list.get(3));

    }

    @Test
    void removeSecondOfTwoElementsOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");

        assertTrue(list.remove("2"));
        assertEquals(1, list.size());
        assertEquals("1", list.get(0));
        list.add(1, "7");
        list.add("3");
        list.add("4");
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("7", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
    }

    @Test
    void removeFirstOfManyOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        assertTrue(list.remove("1"));
        assertEquals(3, list.size());
        assertEquals("2", list.get(0));
        assertEquals("3", list.get(1));
        assertEquals("4", list.get(2));
        list.add(0, "5");
        assertEquals(4, list.size());
        assertEquals("5", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));

    }

    @Test
    void removeLastOfManyOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        assertTrue(list.remove("4"));
        assertEquals(3, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        list.add("5");
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeManyOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");

        assertTrue(list.remove("3"));
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("4", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeZeroElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        assertFalse(list.remove("1"));
        assertEquals(0, list.size());
        list.add("2");
        list.add("3");
        list.add("4");
        list.add("5");
        assertEquals(4, list.size());
        assertEquals("2", list.get(0));
        assertEquals("3", list.get(1));
        assertEquals("4", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeZeroOfOneElementOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");

        assertFalse(list.remove("2"));
        assertEquals(1, list.size());
        list.add("3");
        list.add("4");
        list.add("5");
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("3", list.get(1));
        assertEquals("4", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeZeroOfTwoElementOfElement() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");

        assertFalse(list.remove("3"));
        assertEquals(2, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        list.add("4");
        list.add("5");

        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("4", list.get(2));
        assertEquals("5", list.get(3));
    }

    @Test
    void removeZeroOfManyElements() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");

        assertFalse(list.remove("5"));
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
    }

    @Test
    void clear() {
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.clear();
        assertEquals(0, list.size());
    }
}