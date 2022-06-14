package service.impl;

import service.Animal;

public class Sheep implements Animal {
    @Override
    public void makeSound() throws Throwable{
        System.out.println("Be be be");
    }

    @Override
    public void feed() {
        System.out.println("Hranjenje ovce...");
    }
}
