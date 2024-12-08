package LLDFamousQuestions.LLDElevatorDesign;

import java.util.ArrayList;
import java.util.List;

public class ElevatorCreator {
    static List<ElevatorContorller> elevatorControllerList = new ArrayList<>();
    static {

        ElevatorCar elevatorCar1 = new ElevatorCar();
        elevatorCar1.id =1;
        ElevatorContorller controller1 = new ElevatorContorller(elevatorCar1);

        ElevatorCar elevatorCar2 = new ElevatorCar();
        elevatorCar1.id =2;
        ElevatorContorller controller2 = new ElevatorContorller(elevatorCar2);

        elevatorControllerList.add(controller1);
        elevatorControllerList.add(controller2);
    }

}
