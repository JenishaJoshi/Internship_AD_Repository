package com.mastek.demo;
import com.mastek.demo.model.Circle;
import com.mastek.demo.model.Rectangle;
import com.mastek.demo.model.RedShapeDecorator;
import com.mastek.demo.model.Shape;
public class DecoratorPatternApp 
{
	public static void main(String[] args)
    {
        Shape circle = new Circle();
        Shape redCircle = new RedShapeDecorator (new Circle());
        Shape redRectangle = new RedShapeDecorator (new Rectangle());
        System.out.println ("Circle With Normal Border : ");
        circle.draw();
        System.out.println ("\nCircle Of Red Border : ");
        redCircle.draw();
        System.out.println ("\nRectangle Of Red Border : ");
        redRectangle.draw();
    }
}