package LLDFamousQuestions.LLDElevatorDesign;

import java.util.List;

public class ExternalDispatcher {
    List<ElevatorContorller>  elevatorControllerList = ElevatorCreator.elevatorControllerList;

    public void submitExternalRequest(int floor, Direction direction){


        //for simplicity, i am following even odd,
        for(ElevatorContorller elevatorController : elevatorControllerList) {

           int elevatorID = elevatorController.elevator.id;
           if (elevatorID%2==1 && floor%2==1){
               elevatorController.SubmitExternalRequest(floor,direction);
           } else if(elevatorID%2==0 && floor%2==0){
               elevatorController.SubmitExternalRequest(floor,direction);

           }
        }
    }

}
