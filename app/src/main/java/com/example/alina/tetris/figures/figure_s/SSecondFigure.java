package com.example.alina.tetris.figures.figure_s;


import android.content.Context;
import android.graphics.Path;
import android.graphics.Point;

import com.example.alina.tetris.enums.FigureType;
import com.example.alina.tetris.figures.Figure;

public class SSecondFigure extends Figure {

    public SSecondFigure(int squareWidth, int scale, Context context) {
        super(squareWidth, scale, context);
        this.scale += squareWidth;
    }

    public SSecondFigure(int widthSquare, Context context, Point point) {
        super(widthSquare, context, point);
    }

    public SSecondFigure(int squareWidth, int scale, Context context, Point point) {
        super(squareWidth, scale, context, point);
    }

    @Override
    public void initFigureMask() {
        super.initFigureMask();
        figureMask[0][1] = true;
        figureMask[1][0] = true;
        figureMask[1][1] = true;
        figureMask[2][0] = true;
    }

    @Override
    public FigureType getRotatedFigure() {
        return FigureType.Z_FIGURE;
    }

    @Override
    public int getWidthInSquare() {
        return 2;
    }

    @Override
    public int getHeightInSquare() {
        return 3;
    }

    @Override
    public Path getPath() {
        Path path = new Path();
        path.moveTo(pointOnScreen.x, pointOnScreen.y - scale);
        path.lineTo(pointOnScreen.x, pointOnScreen.y + squareWidth * 2 - scale);
        path.lineTo(pointOnScreen.x + squareWidth, pointOnScreen.y + squareWidth * 2 - scale);
        path.lineTo(pointOnScreen.x + squareWidth, pointOnScreen.y + squareWidth - scale);
        path.lineTo(pointOnScreen.x + squareWidth * 2, pointOnScreen.y + squareWidth - scale);
        path.lineTo(pointOnScreen.x + squareWidth * 2, pointOnScreen.y - squareWidth - scale);
        path.lineTo(pointOnScreen.x + squareWidth, pointOnScreen.y - squareWidth - scale);
        path.lineTo(pointOnScreen.x + squareWidth, pointOnScreen.y - scale);
        path.close();
        return path;
    }
}
