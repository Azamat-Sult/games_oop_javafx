package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

import static org.junit.Assert.assertEquals;

public class LogicTest {

    @Test(expected = OccupiedCellException.class)
    public void moveWhenPosA1DestC3OccupiedB2ThenException()
            throws FigureNotFoundException, OccupiedCellException {
        Cell bishopBlackPosition = Cell.A1;
        Cell PawnBlackPosition = Cell.B2;
        Cell SourcePosition = Cell.A1;
        Cell DestPosition = Cell.C3;
        Logic logic = new Logic();
        logic.add(new BishopBlack(bishopBlackPosition));
        logic.add(new PawnBlack(PawnBlackPosition));
        logic.move(SourcePosition, DestPosition);
    }

    @Test(expected = FigureNotFoundException.class)
    public void moveWhenPosB2DestC3ThenException()
            throws FigureNotFoundException, OccupiedCellException {
        Cell bishopBlackPosition = Cell.A1;
        Cell SourcePosition = Cell.B2;
        Cell DestPosition = Cell.C3;
        Logic logic = new Logic();
        logic.add(new BishopBlack(bishopBlackPosition));
        logic.move(SourcePosition, DestPosition);
    }

    @Test(expected = ImpossibleMoveException.class)
    public void moveWhenPosA1DestA2ThenException()
            throws FigureNotFoundException, OccupiedCellException {
        Cell bishopBlackPosition = Cell.A1;
        Cell SourcePosition = Cell.A1;
        Cell DestPosition = Cell.A2;
        Logic logic = new Logic();
        logic.add(new BishopBlack(bishopBlackPosition));
        logic.move(SourcePosition, DestPosition);
    }

    @Test
    public void moveWhenPosA1DestH8ThenNewPosH8()
            throws FigureNotFoundException, OccupiedCellException {
        Cell bishopBlackPosition = Cell.A1;
        Cell SourcePosition = Cell.A1;
        Cell DestPosition = Cell.H8;
        Logic logic = new Logic();
        Figure bishopBlack1 = new BishopBlack(bishopBlackPosition);
        logic.add(bishopBlack1);
        logic.move(SourcePosition, DestPosition);
        assertEquals(logic.figuresForTest[0].position(),DestPosition);
    }
}