package lesson1.obstructions;

import lesson1.members.Member;

public class Wall implements Obstruction {
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcoming(Member member) {
        return jump(member);
    }

    public boolean jump(Member member) {
        member.jump();
        if (member.getMaxHeight() >= getHeight()) {
            System.out.printf("%s Преодалено\n", getClass().getSimpleName());
            return true;
        }
        System.out.printf("Сошел с дистанции на %s\n", getClass().getSimpleName());
        return false;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
