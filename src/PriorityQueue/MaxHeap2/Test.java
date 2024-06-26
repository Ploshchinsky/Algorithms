package PriorityQueue.MaxHeap2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Test {
    public static void main(String[] args) {
        Hospital centralHospital = new Hospital("Central Hospital", 4);

        int listSize = 7;
        List<Patient> patients = patientsGenerator(listSize);
        System.out.println(patients);

        for (Patient p : patients) {
            System.out.println(centralHospital.addPatient(p));
            if (centralHospital.isFull()) {
                System.out.println("----");
                System.out.println(centralHospital.getPatientsQueue());
                System.out.println("Execute: " + centralHospital.intake());
                System.out.println("----");
            }
        }
        System.out.println(centralHospital.getPatientsQueue());
    }


    public static List<Patient> patientsGenerator(int size) {
        List<Patient> patientList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            DiseaseType tempType = null;
            int randomInt = new Random().nextInt(4) + 1;
            tempType = switch (randomInt) {
                case 1 -> DiseaseType.COLD;
                case 2 -> DiseaseType.FRACTURE;
                case 3 -> DiseaseType.VIRUS;
                case 4 -> DiseaseType.INDIGESTION;
                default -> tempType;
            };
            patientList.add(new Patient("Patient [" + i + "]", tempType));
        }
        return patientList;
    }
}

