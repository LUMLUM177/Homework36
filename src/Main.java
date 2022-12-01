import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        StringList arrayList = new StringListImpl();

        System.out.println(arrayList.isEmpty());

        arrayList.add("First");
        arrayList.add("Second");
        arrayList.add("Third");
        arrayList.add("Fourth");
        arrayList.add("Fifth");
        System.out.println(arrayList);

        arrayList.add(1, "Test");
        System.out.println(arrayList);

        arrayList.set(2, "Fifth");
        System.out.println(arrayList);

        arrayList.remove("Test");
        System.out.println(arrayList);

        arrayList.remove(2);
        System.out.println(arrayList);

        System.out.println(arrayList.contains("First"));
        System.out.println(arrayList.contains("Testadfadf"));

        System.out.println(arrayList.indexOf("First"));
        System.out.println(arrayList.indexOf("as;dfjas;d"));

        System.out.println(arrayList.lastIndexOf("First"));
        System.out.println(arrayList.lastIndexOf("as;dfjas;d"));

        System.out.println(arrayList.get(0));
        StringList otherList = new StringListImpl(5);

//        otherList = arrayList;
//        arrayList.equals(otherList);

        System.out.println(arrayList.size());

        System.out.println(arrayList.isEmpty());

//        arrayList.clear();
        System.out.println(arrayList);

        System.out.println(Arrays.toString(arrayList.toArray()));


    }
}