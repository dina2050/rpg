import java.util.Scanner;
interface MapObject {
    char getSymbol();
}

public class Board {
    int row, col;
    char[][] boardGame = new char[5][15];
    MapObject[][] map = new MapObject[5][15];
    Character player = new Character("name", 100, 100, 50, 0);
    Elfe newplayer = new Elfe("name", 100, 100, 50, 0);
    Sorcier newplayer2 = new Sorcier("name", 100, 100, 50, 0);
    Monster enemy = new Monster();
    Obstacle problem = new Obstacle();
    public String enterPlayer(){
        System.out.println("choose player! Enter elfe or sorcier!");
        Scanner scan = new Scanner(System.in);
        String action = scan.nextLine();
        return action;
    }


  /*  public void whichPlayer(String entered){
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

        System.out.println(" \n Type, u, d, l, or r, to move.");
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
                    game(row, col);
                    if(condition){
                        if(row != 0){
                            row--;
                        }
                        else {
                            row++;
                            System.out.println("can't run from there! go to the left or to the right");
                        }
                    }
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }

                    display();
                    condition = false;
                    break;
                case "d":
                    boardGame[row][col]='-';
                    row++;
                    game(row, col);
                    if(condition){
                        if(row != 0){
                            row++;
                        }
                        else {
                            row--;
                            System.out.println("can't run from there! go to the left or to the right");
                        }
                    }
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }
                    display();
                    condition = false;
                    break;
                case "l":
                    boardGame[row][col]='-';
                    col--;
                    game(row, col);
                    if(condition){
                        if(col != 0){
                            col--;
                        }
                        else {
                            col++;
                            System.out.println("can't run from there! go to the top or to the right");
                        }
                    }
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }

                    display();
                    condition = false;
                    break;
                case "r":
                    boardGame[row][col]='-';
                    col++;
                    game(row, col);
                    if(condition){
                        if(col != 0){
                            col++;

                        }
                        else {
                            col--;
                            System.out.println("can't run from there! go to the left or to the top");
                        }
                    }
                    switch (entered){
                        case "elfe":
                            boardGame[row][col] = newplayer.getSymbol();
                            break;
                        case "sorcier":
                            boardGame[row][col] = newplayer2.getSymbol();
                            break;
                    }
                    display();
                    condition = false;
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
    boolean condition = false;
    public void game(int row,int col){

        this.row = row;
        this.col = col;
        Scanner scan = new Scanner(System.in);
        Weapon axe = new Axe();
        Weapon hammer = new Hammer();
        if(boardGame[row][col] == 'M'){
            System.out.println("attack or run away?");
            String action = scan.nextLine();
            if (action.equals("attack")) {
                System.out.println("axe or hammer?");
                String choice = scan.nextLine();
                    if(choice.equals("axe")){
                        newplayer.attack();
                        newplayer.health+=axe.damage;
                        System.out.println("bravo");
                    }
                    else if (choice.equals("hammer")){
                        newplayer.attack();
                        newplayer.health+=hammer.damage;
                        System.out.println("bravo");
                    }
                    else{
                        condition =true;
                        enemy.hit_me(enemy.damage);
                        newplayer.health-=enemy.damage;
                        System.out.println("Not correct! You lost "+ enemy.damage + " health points!!!");
                    }
                condition = false;
            }
            else if (action.equals("run")) {
                condition =true;
                System.out.println("run");
            }
            else {
                condition = true;
                enemy.hit_me(enemy.damage);
                newplayer.health-=enemy.damage;
                System.out.println("Not correct! You lost "+ enemy.damage + " health points!!!");
            }
            System.out.println("monster!!!");

        }
        else if (boardGame[row][col] == 'O'){
            condition =true;
            System.out.println("obstacle!!!");
        }
        System.out.println("health: " + newplayer.health );
        System.out.println("xp: " + newplayer.xp);
    }

}
