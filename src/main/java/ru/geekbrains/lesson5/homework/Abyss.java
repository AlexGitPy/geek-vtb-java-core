package ru.geekbrains.lesson5.homework;

public class Abyss extends Obstacle {

    private final int flightLength;

    public Abyss(String name, int flightLength) {
        super(name);
        this.flightLength = flightLength;
    }

    @Override
    public boolean canPass(Participant participant) {
        if (!(participant instanceof Parrot)) {
            System.out.printf("Участник %s не умеет летать %n", participant.getName());
        } else {
            boolean result = participant.getMaxFlightLength() >= flightLength;
            System.out.printf("Участник %s %s перелетел пропасть длиной %d%n",
                    participant.getName(), result ? "" : "не", flightLength);
            return result;
        } return false;
    }
}
