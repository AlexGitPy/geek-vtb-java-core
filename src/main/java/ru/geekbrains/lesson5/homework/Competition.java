package ru.geekbrains.lesson5.homework;

public class Competition {

    private final Participant[] participants;

    private final Obstacle[] obstacles;

    public Competition(Participant[] participants, Obstacle[] obstacles) {
        this.participants = participants;
        this.obstacles = obstacles;
    }

    public void compete() {
        for (Participant participant : participants) {
            boolean finish = true;
            for (Obstacle obs : obstacles) {
                if (!obs.canPass(participant)) {
                    System.out.println(participant.getName() + " сошел с дистанции.");
                    finish = false;
                    break;
                }
            }
            if (finish) {
                System.out.println("Участник " + participant.getName() + " прошел полосу препятсвий");
            }
        }
    }

    public static void main(String[] args) {

        Competition competition = new Competition(
                new Participant[] {
                        new Cat("Бася", 10, 50),
                        new Human("Жора", 20, 15, 30),
                        new Robot("XAEA-12", 5),
                        new Fish("Золтоая рыбка", 100),
                        new Parrot("Корелла", 1500, 10)
                },
                new Obstacle[] {
//                        new Abyss("Гранд каньон", 100),
                        new SwimmingPool("Басик", 20),
                        new Treadmill("Дорога дальняя", 5),
                        new Wall("Забор", 7),
                        new Treadmill("Дорожка беговая", 15)
                }
        );

        competition.compete();


    }
}
