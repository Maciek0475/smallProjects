package com.example.todolist;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import androidx.test.filters.LargeTest;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;


@RunWith(AndroidJUnit4ClassRunner.class)
@LargeTest
public class AddListTest {
    private AddList addList;
    @Test
    public void positiveDatabaseTest() {
        addList.titleTxt.setText("Tytuł przyklad");
        addList.descTxt.setText("Opis przyklad");
        addList.DataTxt.setText("2023");
        addList.done.setText("zrobione");

        assertTrue(addList.insertData("Tytuł przyklad", "Opis przyklad", "2023", "zrobione"));
    }

    @Test
    public void negativeDatabaseTest() {

        assertFalse(addList.insertData("", "", "", ""));
    }
}