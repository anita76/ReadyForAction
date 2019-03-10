package com.cmdf2019.readyforaction;

public class OwlPromptTest {

    public static void main(String[] args) {
        OwlPrompt prompt = new OwlPrompt();
        System.out.println(prompt.getCurrPrompt());
        prompt.moveToNextStep();
        System.out.println(prompt.getCurrPrompt());
    }
}
