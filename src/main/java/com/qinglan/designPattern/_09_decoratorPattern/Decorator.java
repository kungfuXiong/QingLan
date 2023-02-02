package com.qinglan.designPattern._09_decoratorPattern;

import com.qinglan.designPattern._09_decoratorPattern.shape.Shape;

public abstract class Decorator implements Shape{
    protected Shape initialShape;

    public Decorator(Shape initialShape) {
        this.initialShape = initialShape;
    }

    public void draw(){
        initialShape.draw();
    }
}
