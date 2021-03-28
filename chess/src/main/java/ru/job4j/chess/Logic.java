package ru.job4j.chess;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;
import java.util.Arrays;

public final class Logic {
    private final Figure[] figures = new Figure[32];
    public Figure[] figuresForTest = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        figures[index++] = figure;
    }

    public void move(Cell source, Cell dest)
            throws FigureNotFoundException, ImpossibleMoveException, OccupiedCellException {
        int index = findBy(source);
        Cell[] steps = figures[index].way(dest);
        free(steps);
        figures[index] = figures[index].copy(dest);
        figuresForTest = figures;
    }

    private boolean free(Cell[] steps) throws OccupiedCellException {
        for (int index1 = 0; index1 < figures.length; index1++) {
            for (int index2 = 0; index2 < steps.length; index2++) {
                if (figures[index1] != null && figures[index1].position().equals(steps[index2])) {
                    throw new OccupiedCellException(
                            String.format("There are some figure in %s cell on the way", steps[index2]));
                }
            }
        }
        return true;
    }

    public void clean() {
        Arrays.fill(figures, null);
        index = 0;
    }

    private int findBy(Cell cell) throws FigureNotFoundException {
        for (int index = 0; index != figures.length; index++) {
            Figure figure = figures[index];
            if (figure != null && figure.position().equals(cell)) {
                return index;
            }
        }
        throw new FigureNotFoundException(
                String.format("There are not found figure in this cell"));
    }
}
