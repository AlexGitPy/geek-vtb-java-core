package ru.geekbrains.lesson5.homework;

public class Treadmill extends Obstacle {

    private final int length;

    public Treadmill(String name, int length) {
        super(name);
        this.length = length;
    }

    @Override
    public boolean canPass(Participant participant) {
        if (!(participant instanceof Run)) {
            System.out.printf("Участник %s не умеет бегать %n", participant.getName());
        } else {
            boolean result = participant.getMaxRunLength() >= length;
            System.out.printf("Участник %s %s пробежал дорожку длиной %d%n",
                    participant.getName(), result ? "" : "не", length);
            return result;
        } return false;


    }

}
