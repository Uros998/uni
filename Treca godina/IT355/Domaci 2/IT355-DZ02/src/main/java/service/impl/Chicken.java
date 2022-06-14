package service.impl;

import service.Animal;

public class Chicken implements Animal {
    @Override
    public void makeSound() throws Throwable{
        System.out.println("Kljuc kljuc");
    }

    @Override
    public void feed() {
        System.out.println("Hreanjenje kokoske...");
    }
}
