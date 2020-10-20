package ru.geekbrains.lesson4.homework;

public class ObstacleCourse {

    private Action[] actions;


    public ObstacleCourse(Action... actions) {
        this.actions = actions;
    }


    public void printAllNames() {
        for (Action action : actions) {
            if (action instanceof Cat) {
                System.out.print("Cat: ");
            } else if (action instanceof Human) {
                System.out.print("Human: ");
            } else if (action instanceof Robot) {
                System.out.print("Robot: ");
            }
            System.out.println(action.getName());
        }
    }

    public void printAllRunAndJump() {
        for (Action action : actions) {
            action.run();
            action.jump();
        }
    }


    public static void main(String[] args) {

        ObstacleCourse obstacleCourseTheParticipants = new ObstacleCourse(
                new Cat("Myrz", 3, 1300, 6),
                new Human("Forest", 22, 3000, 2),
                new Robot("XAEA-12", 1, 0, 0)
        );

        Object[] obstacleCourse = {
                new Treadmill(1000),
                new Wall(1),
                new Treadmill(100),
                new Wall(3),
                new Treadmill(100),
                new Wall(1)
        };

//        obstacleCourseTheParticipants.printAllNames();
//        obstacleCourseTheParticipants.printAllRunAndJump();
        obstacleCourseTheParticipants.runAndJump(obstacleCourse);
    }

    public void runAndJump(Object[] obstacleCourse) {
        for (Action action : actions) {
            int r = action.getCountRun();
            int j = action.getCountJump();
            action.jump();
            action.run();
            for (int i = 0; i < obstacleCourse.length; i++) {
                if (obstacleCourse[i] instanceof Treadmill){
                    if (r >= ((Treadmill) obstacleCourse[i]).getLength()) {
                        r -= ((Treadmill) obstacleCourse[i]).getLength();
                    }
                    else {
                        System.out.println(action.getName() + " Dropped out");
                        break;
                    }
                } else {
                    if (j >= ((Wall) obstacleCourse[i]).getHeight()) {
                        j -= ((Wall) obstacleCourse[i]).getHeight();
                    } else {
                        System.out.println(action.getName() + " Dropped out");
                        break;
                    }
                }
            }
        }
    }


}
