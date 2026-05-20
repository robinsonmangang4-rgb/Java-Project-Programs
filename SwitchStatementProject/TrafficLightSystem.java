package SwitchStatementProject;

public class TrafficLightSystem {
    public  TrafficLightSystem() {
   }

    public static void main(String[] args) {

        String light = "red";

        switch(light) {

            case "red" -> System.out.println("Stop");

            case "yellow" -> System.out.println("Ready");

            case "green" -> System.out.println("Go");

            default -> System.out.println("Invalid signal");
        }
    }
}


