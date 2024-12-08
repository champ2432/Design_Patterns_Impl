package LLDFamousQuestions.LLDElevatorDesign;

public class Floor {
    int floorNumber;
    ExternalDispatcher eobj;

    public Floor(int floorNumber){
        this.floorNumber = floorNumber;
        eobj = new ExternalDispatcher();
    }
    public void pressButton(Direction direction) {

        eobj.submitExternalRequest(floorNumber, direction);
    }

}
