package Exercises.trafficLights;

public class TrafficLight {


    private Signal signal;

    public enum Signal {
        RED,
        GREEN,
        YELLOW;

    }

    public TrafficLight(Signal signal) {
        this.signal = signal;
    }

    public void update() {
        switch (this.signal) {
            case RED:
                this.signal = Signal.GREEN;
                break;
            case GREEN:
                this.signal = Signal.YELLOW;
                break;
            case YELLOW:
                this.signal = Signal.RED;
                break;
            default:
                throw new IllegalArgumentException("Unknown state " + signal);
        }
    }

    public Signal getSignal() {
        return signal;
    }
}
