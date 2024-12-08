package LLDFamousQuestions.LLDElevatorDesign;

import java.util.PriorityQueue;

public class ElevatorContorller {
    PriorityQueue<Integer> upMinQueue;
    PriorityQueue<Integer> downMaxQueue;
    ElevatorCar elevator;

    public ElevatorContorller(ElevatorCar car){
        upMinQueue = new PriorityQueue<>();
        downMaxQueue = new PriorityQueue<>((a,b)->b-a);
        this.elevator = car;
    }

    public void SubmitExternalRequest(int floor,Direction dir){
        if(dir==Direction.DOWN){
            downMaxQueue.offer(floor);
        }
        else{
            upMinQueue.offer(floor);
        }
    }

    public void submitInternalRequest(int floor){

    }

    public void controlElevator(){
        while(true) {

            if(elevator.dir == Direction.UP){

            }
        }
    }

}
