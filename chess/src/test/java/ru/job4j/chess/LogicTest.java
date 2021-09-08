package ru.job4j.chess;

import org.junit.Ignore;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.black.BishopBlack;
import ru.job4j.chess.firuges.black.PawnBlack;

public class LogicTest {

    @Ignore
    @Test
    public void move() throws OccupiedCellException,
            FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A8));
        logic.move(Cell.A8, Cell.H1);
    }

    @Test (expected = OccupiedCellException.class)
    public void whenNotFree() throws OccupiedCellException,
            FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A8));
        logic.add(new PawnBlack(Cell.B7));
        logic.move(Cell.A8, Cell.H1);
    }

    @Test (expected = FigureNotFoundException.class)
    public void whenNotFound() throws OccupiedCellException,
            FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.move(Cell.A8, Cell.H1);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void impossibleMove() throws OccupiedCellException,
            FigureNotFoundException, ImpossibleMoveException {
        Logic logic = new Logic();
        logic.add(new BishopBlack(Cell.A8));
        logic.move(Cell.A8, Cell.A7);
    }
}