package LLDFamousQuestions.LLDElevatorDesign;

public class Display {
    public int floor;
    public Direction dir;

    public void setDisplay(int floor,Direction dir){
        this.floor=floor;
        this.dir=dir;
    }

    public void showDisplay(){
        System.out.println("Current Florr is:"+floor);
        System.out.println("Going:"+dir);
    }

}
