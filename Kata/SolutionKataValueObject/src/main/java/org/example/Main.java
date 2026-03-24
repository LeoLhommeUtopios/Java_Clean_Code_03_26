package org.example;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Portfolio portfolio = new Portfolio(new ArrayList<>(),"€");

        Investment investment = new Investment("invest1",4,new Money(300,"€"));
        Investment investment2 = new Investment("invest2",8,new Money(30,"€"));

        portfolio.addInvestment(investment);
        portfolio.addInvestment(investment2);

        PortfolioDiplayer portfolioDiplayer = new PortfolioDiplayer();
        portfolioDiplayer.displayAllInvestments(portfolio);

    }
}