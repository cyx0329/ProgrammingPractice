package com.study.interview.ood;

public class Solution {

    public static void main(String[] args) throws Exception {
        Kindle kindle = new Kindle();
        Book epub = new Book(Format.EPUB);
        String answer = kindle.readBook(epub);
        System.out.println(answer);

        int milk = 2;
        int sugar = 3;
        CoffeePack pack = new CoffeePack(milk, sugar);
        CoffeeMaker maker = new CoffeeMaker();
        Coffee coffee = maker.makeCoffee(pack);
        System.out.println("Cost:" + coffee.getCost());
        System.out.println("Ingredients" + coffee.getIngredients());
    }
}
