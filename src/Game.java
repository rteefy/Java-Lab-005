import java.util.Scanner;

public class Game {
    Player p1;
    Player p2;
    Dice die;

    public Game (Player p1, Player p2, Dice die){
        this.p1 = p1;
        this.p2 = p2;
        this.die = die;
    }

    public void play() {
        Player current = this.p1;
        takeTurn(current);
        current = nextPlayer(current);
        takeTurn(current);
        System.out.println(announceWinner());
    }

    public Player nextPlayer(Player current) {
        if (current == this.p1){
            return this.p2;}
        return this.p1;
    }

    public void takeTurn(Player player) {
        player.toss(this.die);
    }

    public String announceWinner() {

        System.out.println( String.format("Player: %s Score: %d", this.p1.getName(), this.p1.getScore()));
        System.out.println(String.format("Player: %s Score: %d", this.p2.getName(), this.p2.getScore()));
        if (this.p1.getScore() > this.p2.getScore()){
            return String.format("WINNER: %s", this.p1.getName());}
        if (this.p1.getScore() < this.p2.getScore()){
            return String.format("WINNER: %s", this.p2.getName());}
        else{
            return ("Draw!");
        }

    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
            System.out.println("How many sides is your dice?");
            int sides = Integer.parseInt(s.nextLine());
            Player p1 = new Player("Kongo");
            Player p2 = new Player("Bongo");
            Dice die = new Dice(sides);
            Game game = new Game(p1, p2, die);
        game.play();
        }
    }


