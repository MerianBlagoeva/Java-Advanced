package Lab.p05_DependencyInversion.p02_Worker;

public class Manager {

    private final Worker worker;

    public Manager(Worker worker) {
        this.worker = worker;
        this.worker.work();
    }
}
