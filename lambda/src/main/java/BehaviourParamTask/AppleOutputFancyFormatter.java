package BehaviourParamTask;

public class AppleOutputFancyFormatter implements AppleOutputFormatter{
    @Override
    public String output(Apple apple) {
        String weightCategory = apple.getWeight() > 150 ? "Heavy" : "Light";
        return "A " + weightCategory + " " + apple.getColor() + " apple";
    }
}
