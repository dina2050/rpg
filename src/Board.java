import java.util.Arrays;
import java.util.Scanner;
interface MapObject {
    public char getSymbol();
}

public class Board {
    int row, col;
    char[][] boardGame = new char[5][15];
    MapObject[][] map = new MapObject[5][15];
    Elfe newplayer = new Elfe("name", 100, 100, 50, 0);
    Sorcier newplayer2 = new Sorcier("name", 100, 100, 50, 0);

    public String enterPlayer(){
        System.out.println("choose player");
        Scanner scan = new Scanner(System.in);
        String action = scan.nextLine();
        return action;
    }


/*    public void whichPlayer(String entered){
        switch (entered){
            case "elfe":
                boardGame[row][col] = newplayer.getSymbol();
                break;
            case "sorcier":
                boardGame[row][col] = newplayer2.getSymbol();
                break;
        }
    }*/

    public void setBoardGame(MapObject[][] map, char[][] boardGame,int row, int col) {
        this.map = map;
        this.row = row;
        this.col = col;
        this.boardGame = boardGame;



        String entered = enterPlayer();
        System.out.println(entered);
        for(row=0; row<boardGame.length;row++){
            System.out.println();
            for(col=0; col<boardGame[row].length; col++){
                map[0][0] = new Monster();
                map[0][1] = new Obstacle();
                double random = Math.random();

                if (row == 4 && col == 14){
                    //whichPlayer(entered);
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }
                }
                else if (random <= .08){
                    char msymbol = map[0][0].getSymbol();
                    boardGame[row][col] = msymbol;
                }
                else if (random > .08 && random <= .13){
                    char osymbol = map[0][1].getSymbol();
                    boardGame[row][col] = osymbol;
                }
                else{
                    boardGame[row][col] = '-';
                }
                System.out.print(boardGame[row][col]);

            }}

        System.out.println(" \n Type, up, down, left, or right, to move.");
        Board myboard = new Board();
        row = 4;
        col = 14;
        do {
            Scanner scan = new Scanner(System.in);
            String dir = scan.nextLine();
            switch (dir) {
                case "u":
                    boardGame[row][col]='-';
                    row--;
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }

                    display();
                    break;
                case "d":
                    boardGame[row][col]='-';
                    row++;
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }
                    display();
                    break;
                case "l":
                    boardGame[row][col]='-';
                    col--;
                    game(row, col);
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }
                    display();
                    break;
                case "r":
                    boardGame[row][col]='-';
                    col++;
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }
                    display();
                    break;
            }
        }
        while(row>=0 && col>=0);
            System.out.println("row: " + row);
            System.out.println("col: " + col);



            for (row = 0; row < boardGame.length; row++) {
                System.out.println();
                for (col = 0; col < boardGame[row].length; col++) {
                    System.out.print(boardGame[row][col]);
                }
            }
    }

    public void display(){
        for (row = 0; row < boardGame.length; row++) {
            System.out.println();
            for (col = 0; col < boardGame[row].length; col++) {
                System.out.print(boardGame[row][col]);
            }
        }
    }
    public void game(int row,int col){
        this.row = row;
        this.col = col;
        Scanner scan = new Scanner(System.in);
        Weapon axe = new Axe();
        Weapon hammer = new Hammer();
        int health = 0;
        if(boardGame[row][col] == 'M'){
            System.out.println("attack or run away?");
            String action = scan.nextLine();
            if (action.equals("attack")) {
                System.out.println("axe or hammer?");
                String choice = scan.nextLine();
                    if(choice == "axe"){
                        newplayer.attack();
                        newplayer.health+=axe.damage;
                        health = newplayer.health;
                        System.out.println("health " + health);
                    }
                    else if (choice == "hammer"){
                        newplayer.attack();
                        newplayer.health+=hammer.damage;
                    }
                    else{
                        System.out.println("enter something");
                    }
            }
            else if (action.equals("run")) {
                System.out.println("run");
            }
            else{
                System.out.println("enter something");
            }
            System.out.println("monster!!!");
            System.out.println("finalxp: " + newplayer.attack());
        }
        else if (boardGame[row][col] == 'O'){
            System.out.println("obstacle!!!");
        }
    }
}
