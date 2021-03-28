package ru.job4j.chess.firuges.black;

import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BishopBlackTest {

    @Test
    public void positionWhenC8ThenC8() {
        Cell pos = Cell.C8;
        Figure bishopBlack = new BishopBlack(pos);
        assertEquals(bishopBlack.position(),pos);
    }

    @Test
    public void copyWhenC8ThenB7() {
        Cell pos1 = Cell.C8;
        Cell pos2 = Cell.B7;
        Figure bishopBlack1 = new BishopBlack(pos1);
        Figure bishopBlack2 = bishopBlack1.copy(pos2);
        assertEquals(bishopBlack2.position(),pos2);
    }

    @Test
    public void wayWhenPosC1DestG5ThenD2E3F4G5() {
        Cell source = Cell.C1;
        Cell dest = Cell.G5;
        Cell[] wayExpected = new Cell[] {Cell.D2, Cell.E3, Cell.F4, Cell.G5};
        Figure bishopBlack1 = new BishopBlack(source);
        Cell[] wayResult = bishopBlack1.way(dest);
        assertThat(wayResult, is(wayExpected));
    }

    @Test(expected = ImpossibleMoveException.class)
    public void wayWhenPosC1DestA5ThenException() {
        Cell source = Cell.C1;
        Cell dest = Cell.A5;
        Figure bishopBlack1 = new BishopBlack(source);
        Cell[] wayResult = bishopBlack1.way(dest);
    }
}