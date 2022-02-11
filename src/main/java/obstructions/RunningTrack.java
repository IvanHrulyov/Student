package obstructions;

import members.Member;

public class RunningTrack implements Obstruction {
    private int distance;

    public RunningTrack(int distance) {
        this.distance = distance;
    }

    @Override
    public boolean overcoming(Member member) {
        return run(member);
    }

    public boolean run(Member member) {
        member.run();
        if (member.getMaxDistance() >= getDistance()) {
            System.out.printf("%s Преодалено\n", getClass().getSimpleName());
            return true;
        }
        System.out.printf("Сошел с дистанции на %s\n", getClass().getSimpleName());
        return false;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }
}
