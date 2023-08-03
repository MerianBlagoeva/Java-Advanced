package Exercises.calculator;

public class MemoryRecallOperation implements Operation {
    private final Memory memory;

    public MemoryRecallOperation(Memory memory) {
        this.memory = memory;
    }

    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        int recall = memory.recall();
        return recall;
    }

    @Override
    public boolean isCompleted() {
        return true;
    }
}
