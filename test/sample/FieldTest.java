package sample;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    private Field field;

    @BeforeEach
    void setUp() {field = new Field();}
    @AfterEach
    void tearDown() {}
    @Test
    void isWinner() {
        assertTrue(field.isWinner());
        field.getArr()[1][1].setValue(true);
        assertFalse(field.isWinner());
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                field.getArr()[i][j].setValue(true);
            }
        }
        assertTrue(field.isWinner());
        field.getArr()[3][2].setValue(false);
        assertFalse(field.isWinner());
    }
    @Test
    void test1() {
        field.toggleTile1(0);
        assertFalse(field.getArr()[0][0].isValue());
        assertTrue(field.getArr()[1][0].isValue());
        assertTrue(field.getArr()[0][1].isValue());
        assertTrue(field.getArr()[1][1].isValue());
    }
    @Test
    void test2() {
        field.toggleTile1(2);
        assertFalse(field.getArr()[2][0].isValue());
        assertTrue(field.getArr()[1][0].isValue());
        assertTrue(field.getArr()[3][1].isValue());
        assertTrue(field.getArr()[1][1].isValue());
        assertTrue(field.getArr()[2][1].isValue());
        assertTrue(field.getArr()[3][1].isValue());
    }
    @Test
    void test3() {
        field.toggleTile1(6);
        assertFalse(field.getArr()[2][1].isValue());
        assertTrue(field.getArr()[1][0].isValue());
        assertTrue(field.getArr()[2][0].isValue());
        assertTrue(field.getArr()[3][0].isValue());
        assertTrue(field.getArr()[3][1].isValue());
        assertTrue(field.getArr()[1][1].isValue());
        assertTrue(field.getArr()[2][2].isValue());
        assertTrue(field.getArr()[3][2].isValue());
        assertTrue(field.getArr()[1][2].isValue());
    }
    @Test
    void test4() {
        field.toggleTile1(13);
        field.toggleTile1(7);
        field.toggleTile1(5);
        field.toggleTile1(2);
        field.toggleTile1(2);
        field.toggleTile1(5);
        field.toggleTile1(7);
        field.toggleTile1(13);
        field.toggleTile1(13);
        assertFalse(field.getArr()[1][3].isValue());
        assertTrue(field.getArr()[0][3].isValue());
        assertTrue(field.getArr()[2][3].isValue());
        assertTrue(field.getArr()[0][2].isValue());
        assertTrue(field.getArr()[1][2].isValue());
        assertTrue(field.getArr()[2][2].isValue());
        field.toggleTile1(13);
        assertTrue(field.isWinner());
    }
    @Test
    void test5() {
        field.toggleTile1(4);
        field.toggleTile1(9);
        field.toggleTile1(15);
        field.toggleTile1(1);
        field.toggleTile1(8);
        field.toggleTile1(5);
        field.toggleTile1(12);
        field.toggleTile1(10);
        assertTrue(field.getArr()[0][0].isValue());
        assertFalse(field.getArr()[0][1].isValue());
        assertFalse(field.getArr()[0][2].isValue());
        assertFalse(field.getArr()[0][3].isValue());
        assertFalse(field.getArr()[1][0].isValue());
        assertTrue(field.getArr()[1][1].isValue());
        assertTrue(field.getArr()[1][2].isValue());
        assertFalse(field.getArr()[1][3].isValue());
        assertFalse(field.getArr()[2][0].isValue());
        assertFalse(field.getArr()[2][1].isValue());
        assertTrue(field.getArr()[2][2].isValue());
        assertTrue(field.getArr()[2][3].isValue());
        assertFalse(field.getArr()[3][0].isValue());
        assertTrue(field.getArr()[3][1].isValue());
        assertFalse(field.getArr()[3][2].isValue());
        assertTrue(field.getArr()[3][3].isValue());
        assertFalse(field.isWinner());
    }
}
