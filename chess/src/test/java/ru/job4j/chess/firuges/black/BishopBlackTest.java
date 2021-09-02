package ru.job4j.chess.firuges.black;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

import static org.junit.Assert.*;

public class BishopBlackTest {
    @Test
    public void position() {
        Figure bishop = new BishopBlack(Cell.A1);
        Cell expected = Cell.A1;
        Cell real = bishop.position();
        Assert.assertEquals(expected, real);
    }

    @Test
    public void copy() {
        Figure bishop = new BishopBlack(Cell.A1);
        Figure expected = new BishopBlack(Cell.B7);
        Figure real = bishop.copy(Cell.B7);
        Assert.assertEquals(expected.position(), real.position());
    }

    @Test
    public void whenIsDiagonal() {
        Figure bishop = new BishopBlack(Cell.A8);
        Cell[] expected = {Cell.B7, Cell.C6, Cell.D5};
        Cell[] real = bishop.way(Cell.D5);
        Assert.assertArrayEquals(expected, real);
    }

    @Test (expected = ImpossibleMoveException.class)
    public void whenNotDiagonal() {
        Figure bishop = new BishopBlack(Cell.A8);
        bishop.way(Cell.B6);
    }
}