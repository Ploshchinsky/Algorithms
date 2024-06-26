package PriorityQueue.MaxHeap2;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.concurrent.PriorityBlockingQueue;

public class Hospital {
    private String name;
    private PriorityQueue<Patient> patients;
    private int limit;

    public Hospital(String name, int patientsQueueSize) {
        this.name = name;
        this.limit = patientsQueueSize;
        Comparator<Patient> patientComparator = (o1, o2) -> {
            return o2.getPriority() - o1.getPriority();
        };
        patients = new PriorityQueue<>(patientComparator);
    }

    public boolean addPatient(Patient patient) {
        if (patients.size() >= limit) {
            return false;
        }
        patientPriorityInit(patient);
        return patients.offer(patient);
    }

    private void patientPriorityInit(Patient patient) {
        switch (patient.getType()) {
            case COLD:
                patient.setPriority(1);
                break;
            case INDIGESTION:
                patient.setPriority(2);
                break;
            case VIRUS:
                patient.setPriority(3);
                break;
            case FRACTURE:
                patient.setPriority(4);
                break;
        }
    }

    public Patient intake() {
        return patients.poll();
    }

    public String getPatientsQueue() {
        StringBuilder builder = new StringBuilder();
        Iterator<Patient> patientIterator = patients.iterator();
        builder.append("Hospital [" + name + "] queue: \n");
        while (patientIterator.hasNext()) {
            builder.append(patientIterator.next());
            if (patientIterator.hasNext()) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public boolean isFull() {
        return patients.size() == limit;
    }

    public boolean isEmpty() {
        return patients.isEmpty();
    }

}
