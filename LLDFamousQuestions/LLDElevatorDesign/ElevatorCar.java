package LLDFamousQuestions.LLDElevatorDesign;

public class ElevatorCar {
    int id;
    int currFLoor;
    Direction dir;
    Status stat;
    Door dObj;
    Display dis;
    InternalButton IObj;

    public ElevatorCar(){
        currFLoor=0;
        dir=Direction.UP;
        stat=Status.IDLE;
        dObj=new Door();
        dis = new Display();
        IObj=new InternalButton();
    }

    public void showDisplay(){
        dis.showDisplay();
    }

    public void setDisplay(){
        this.dis.setDisplay(currFLoor, dir);
    }

    public void pressButton(int destination){
        this.IObj.pressButton(destination,this);
    }

    public boolean moveElevator(Direction dir, int destinationFLoor){
        int startFLoor=currFLoor;
        if(dir==Direction.UP){
            for(int i=startFLoor;i<destinationFLoor;i++){
                this.currFLoor=startFLoor;
                setDisplay();
                showDisplay();
                if(i==destinationFLoor)
                    return true;
            }
        }
        if(dir==Direction.DOWN){
            for(int i=startFLoor;i>=destinationFLoor;i--){
                this.currFLoor=startFLoor;
                setDisplay();
                showDisplay();
                if(i==destinationFLoor)
                    return true;
            }
        }
        return false;
    }
}
