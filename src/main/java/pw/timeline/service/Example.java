package pw.timeline.service;

import java.util.List;
import java.util.stream.Collectors;

public class Example {

    public static void main(String[] args) {
        List<Object[]> listObjectArrays = getListOfObjectArrays();

        List<AnotherObject> listAnotherObjects = listObjectArrays.stream()
                .map(Example::convertToObject) // Use a static method for conversion
                .collect(Collectors.toList());

        System.out.println(listAnotherObjects);
    }

    static class AnotherObject {
        private String field1;
        private int field2;

        public AnotherObject(String field1, int field2) {
            this.field1 = field1;
            this.field2 = field2;
        }

        // Getters and setters
    }

    // Sample method to convert Object[] to AnotherObject
    static AnotherObject convertToObject(Object[] array) {
        // Adjust this method based on the structure of your Object[]
        if (array == null || array.length != 2) {
            throw new IllegalArgumentException("Invalid array");
        }

        return new AnotherObject((String) array[0], (int) array[1]);
    }

    // Sample method to generate a list of Object[]
    static List<Object[]> getListOfObjectArrays() {
        // Replace this with your logic to generate a list of Object[]
        return List.of(new Object[]{"Value1", 1}, new Object[]{"Value2", 2}, new Object[]{"Value3", 3});
    }

}
