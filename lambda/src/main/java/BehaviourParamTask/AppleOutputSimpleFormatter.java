package BehaviourParamTask;

public class AppleOutputSimpleFormatter implements AppleOutputFormatter{
    @Override
    public String output(Apple apple) {
        return "An apple of " + apple.getWeight() + "g";
    }
}
