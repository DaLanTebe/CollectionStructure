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
    void removeFirstOfMany(){
        SingleLinkedList<String> list = new SingleLinkedList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        list.remove(0);
        assertEquals(3,list.size());
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
    void removeLastOfMany(){
        // то же самое что и first
    }

    @Test
    void removeOfMany(){
        //добав 5 эл удалить второй
    }

    @Test
    void removeElementOfElement(){

    }

    @Test
    void removeFirstOfTwoElementsOfElement(){
        //удалить первый элемент из 2 элементов удаление по элементу
    }

    @Test
    void removeSecondOfTwoElementsOfElement(){
        //второй элемент
    }
}