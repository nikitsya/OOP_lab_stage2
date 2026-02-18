package t08_generics_1.ce03_frequency_forge;

import java.util.List;

public class FrequencyForge<T> {

    private List<T> codes;

    public static void printFrequenciesNaive(List<String> codes) {
        for (String code : codes) {
            System.out.println(code);
        }
    }
}