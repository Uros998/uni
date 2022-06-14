package service.impl;

import service.Animal;

public class Dog implements Animal {
    @Override
    public void makeSound() throws Throwable {
        System.out.println("Av av av");
    }

    @Override
    public void feed() {
        System.out.println("Hranjenje psa...");
    }
}
