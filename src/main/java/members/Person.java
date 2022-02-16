package members;

public class Person implements Member {
    private int maxDistance;
    private int maxHeight;

    public Person(int maxDistance, int maxHeight) {
        this.maxDistance = maxDistance;
        this.maxHeight = maxHeight;
    }

    @Override
    public void run() {
        System.out.printf("%s is Runing\n", getClass().getSimpleName());
    }

    @Override
    public void jump() {
        System.out.printf("%s is Jumping\n", getClass().getSimpleName());
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public int getMaxDistance() {
        return maxDistance;
    }
}
