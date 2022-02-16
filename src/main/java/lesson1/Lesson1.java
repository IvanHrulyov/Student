package lesson1;

import lesson1.members.Cat;
import lesson1.members.Member;
import lesson1.members.Person;
import lesson1.members.Robot;
import lesson1.obstructions.Obstruction;
import lesson1.obstructions.RunningTrack;
import lesson1.obstructions.Wall;

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