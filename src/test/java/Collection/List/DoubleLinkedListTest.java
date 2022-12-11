package Collection.List;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {

    void check(DoubleLinkedList<String> list) {
        assertEquals(4, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("4", list.get(3));
    }

    @Test
    void add() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        check(list);
    }

    @Test
    void addFirst() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add(0, "4");
        assertEquals(4, list.size());
        assertEquals("4", list.get(0));
        assertEquals("1", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("3", list.get(3));
    }

    @Test
    void addFirstHalf() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(1, "5");
        assertEquals(5, list.size());
        assertEquals("1", list.get(0));
        assertEquals("5", list.get(1));
        assertEquals("2", list.get(2));
        assertEquals("3", list.get(3));
        assertEquals("4", list.get(4));
    }

    @Test
    void addLastHalf() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.add(3, "5");
        assertEquals(5, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        assertEquals("5", list.get(3));
        assertEquals("4", list.get(4));
    }

    @Test
    void indexOf() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertEquals(4, list.size());
        assertEquals(0, list.indexOf("1"));
        assertEquals(1, list.indexOf("2"));
        assertEquals(2, list.indexOf("3"));
        assertEquals(3, list.indexOf("4"));
        assertEquals(-1, list.indexOf("412"));
    }

    @Test
    void removeWrongIndex() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        try {
            list.remove(15);
            fail("NOT ERROR");
        } catch (IllegalArgumentException ignore) {

        }
    }

    @Test
    void removeSingle() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.remove(0);
        assertEquals(0, list.size());
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        check(list);
    }

    @Test
    void removeFirstOfTwo() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.remove(0);
        assertEquals(1, list.size());
        assertEquals("2", list.get(0));
        list.add(0, "1");
        list.add("3");
        list.add("4");
        check(list);
    }

    @Test
    void removeSecondOfTwo() {
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.remove(1);
        assertEquals(1, list.size());
        assertEquals("1", list.get(0));
        list.add("2");
        list.add("3");
        list.add("4");
        check(list);
    }
    @Test
    void removeFirstOfMany(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(0);
        assertEquals(3, list.size());
        assertEquals("2", list.get(0));
        assertEquals("3", list.get(1));
        assertEquals("4", list.get(2));
        list.add(0, "1");
        check(list);
    }
    @Test
    void removeLastOfMany(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(3);
        assertEquals(3, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        list.add(3, "4");
        check(list);
    }
    @Test
    void removeMiddleOfMany(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("5");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(1);
        check(list);
    }
    @Test
    void removeSingleElement(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        assertTrue(list.remove("1"));
        assertEquals(0, list.size());
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        check(list);
    }
    @Test
    void removeFirstOfTwoElements(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        assertTrue(list.remove("1"));
        assertEquals(1, list.size());
        assertEquals("2", list.get(0));
        list.add(0, "1");
        list.add("3");
        list.add("4");
        check(list);
    }
    @Test
    void removeSecondOfTwoElements(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
       assertTrue(list.remove("2"));
       assertEquals(1,list.size());
       assertEquals("1", list.get(0));
       list.add("2");
       list.add("3");
       list.add("4");
       check(list);
    }
    @Test
    void removeFirstOfManyElements(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertTrue(list.remove("1"));
        assertEquals(3, list.size());
        assertEquals("2", list.get(0));
        assertEquals("3", list.get(1));
        assertEquals("4", list.get(2));
        list.add(0, "1");
        check(list);
    }
    @Test
    void removeLastOfManyElements(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertTrue(list.remove("4"));
        assertEquals(3, list.size());
        assertEquals("1", list.get(0));
        assertEquals("2", list.get(1));
        assertEquals("3", list.get(2));
        list.add("4");
        check(list);
    }
    @Test
    void removeMiddleOfManyElements(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("5");
        list.add("2");
        list.add("3");
        list.add("4");
        assertTrue(list.remove("5"));
        check(list);
    }
    @Test
    void removeUnknownOfManyElements(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        assertFalse(list.remove("5"));
        check(list);
    }
    @Test
    void clear(){
        DoubleLinkedList<String> list = new DoubleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.clear();
        assertEquals(0, list.size());
    }
}