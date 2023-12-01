package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ArrayListTest {

    private MyArrayList list;

    @BeforeEach
    public void setUp(){
        list = new MyArrayList();
    }

    @Test
    public void testAdd(){
        int[] array = list.getArray();
        assertThat(array.length, is(0));

        list.add(1);
        array = list.getArray();
        assertThat(array.length, is(1));
        assertThat(array[0], is(1));
    }

    @Test
    public void testAddMultiple(){
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }

        for (int i = 0; i < 12; i++) {
            assertThat(list.getArray()[i], is(i));
        }
    }

    @Test
    public void testSize(){
        for (int i = 0; i < 20; i++) {
            list.add(i*2);
            assertThat(list.size(), is(i+1));
        }
    }

    @Test
    public void testRemove(){
        for (int i = 0; i < 12; i++) {
            list.add(i*2);
        }

        assertThat(list.getArray(), is(new int[]{0,2,4,6,8,10,12,14,16,18,20,22}));

        list.remove(2);
        assertThat(list.getArray(), is(new int[]{0,2,6,8,10,12,14,16,18,20,22}));

    }

    @Test
    public void testContains_success(){
        for (int i = 0; i < 12; i++) {
            list.add(i*2);
        }

        assertThat(list.contains(10), is(true));
    }

    @Test
    public void testContains_fail(){
        for (int i = 0; i < 12; i++) {
            list.add(i*2);
        }

        assertThat(list.contains(11), is(false));
    }
}
