package PriorityQueue.MaxHeap2;

public class Patient {
    private String name;
    private DiseaseType type;
    private int priority;

    public Patient(String name, DiseaseType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DiseaseType getType() {
        return type;
    }

    public void setType(DiseaseType type) {
        this.type = type;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", priority=" + priority +
                '}';
    }
}
