package ru.geekbrains.lesson5.homework;

public class SwimmingPool extends Obstacle {

    private final int poolLength;

    public SwimmingPool(String name, int poolLength) {
        super(name);
        this.poolLength = poolLength;
    }

    @Override
    public boolean canPass(Participant participant) {
        if (!(participant instanceof Swim)) {
            System.out.printf("Участник %s не умеет плавать %n", participant.getName());
        } else {
            boolean result = participant.getMaxProjectedLength() >= poolLength;
            System.out.printf("Участник %s %s переплыл бассейн длиной %d%n",
                    participant.getName(), result ? "" : "не", poolLength);
            return result;
        } return false;
    }
}
