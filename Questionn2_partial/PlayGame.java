/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Dev Ops
 */
public class PlayGame {
    public PlayGame()
    {
        win = 500.00;
        firstChoice = 1;
        randomBag = 1;
    }
    
    public double winCalc()
    {
        if((Math.random()*250000)<500.00)
            win = 500.00;
	win = Math.random()*250000;
	return win; 
    }
    
    public int randomBag()
    {
        double randomBagDouble=Math.round(Math.random()*16);
	int randomBagInt = (int) randomBagDouble;
	if(randomBagInt<1 | randomBagInt==firstChoice)
            randomBag();
	randomBag = randomBagInt;
	return randomBag;
    }
    
    public void finalWinCalc() throws IOException
    {
        System.out.println("Enter a number from 1 to 16 to choose a bag");
	InputStreamReader isr = new InputStreamReader(System.in);
	BufferedReader br = new BufferedReader(isr);
	String enteredNumber = br.readLine();
        win = Double.parseDouble(enteredNumber);
        firstChoice = Integer.parseInt(enteredNumber);
        if(firstChoice<1 || firstChoice>16)
            System.out.println("Out of range, please select a valid bag number from 1 to 16");
        System.out.println("You chose bag " + this.firstChoice);
	System.out.println("Enter 'r' to retain your choice or 'c' to change your answer to bag " + this.randomBag());
	String finalChoice = br.readLine();
	if(finalChoice.equals("r"))
        {
		this.winCalc();
		System.out.println("You have won " + this.winCalc());
        }

        else if(finalChoice.equals("c"))
                {
		this.winCalc();
		this.winCalc();
		System.out.println("You have won " + this.winCalc());
                }
 
        
    }
    
double win;
int firstChoice;
int randomBag;
    
}

