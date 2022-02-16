import members.Cat;
import members.Member;
import members.Person;
import members.Robot;
import obstructions.Obstruction;
import obstructions.RunningTrack;
import obstructions.Wall;

public class Lesson1 {
    public static void main(String[] args) {
        Member[] members = new Member[]{
                new Cat(100, 40),
                new Robot(200, 5),
                new Person(150, 25)
        };

        Obstruction[] obstructions = new Obstruction[]{
                new Wall(4),
                new RunningTrack(50),
                new Wall(10),
                new RunningTrack(170),
                new Wall(30),
                new RunningTrack(210),
                new Wall(45)
        };

        for (Member member : members) {
            for (Obstruction obstruction : obstructions) {
                if(!obstruction.overcoming(member)) {
                    break;
                }
            }
            System.out.println("----------------------\n");
        }
    }
}