import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private final String[] arrayList;

    public StringListImpl(int size) {
        this.arrayList = new String[size];
    }

    @Override
    public String add(String item) {
        if (item == null) {
            throw new WorkingArrayStringListException("Parameter is null.");
        }
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] == null) {
                arrayList[i] = item;
                return item;
            }
        }
        throw new WorkingArrayStringListException("Array is full!");
    }

    @Override
    public String add(int index, String item) {
        if (item == null) {
            throw new WorkingArrayStringListException("Parameter is null.");
        }
        if (index > arrayList.length) {
            throw new WorkingArrayStringListException("Array is full!");
        }
        if (arrayList[index] != null) {
            for (int i = arrayList.length - 1; i > index; i--) {
                arrayList[i] = arrayList[i - 1];
            }
        }
        arrayList[index] = item;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (item == null) {
            throw new WorkingArrayStringListException("Parameter is null.");
        }
        if (index > arrayList.length) {
            throw new WorkingArrayStringListException("Array is full!");
        }
        arrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (item == null) {
            throw new WorkingArrayStringListException("Parameter is null.");
        }
        int count = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i].equals(item)) {
                count++;
                for (; i < arrayList.length - 1; i++) {
                    arrayList[i] = arrayList[i + 1];
                }
            }
            if (i == arrayList.length - 1) {
                arrayList[i] = null;
            }
        }
        if (count == 0) {
            throw new WorkingArrayStringListException("Parameter is not found.");
        }
        return item;
    }

    @Override
    public String remove(int index) {
        if (index > arrayList.length) {
            throw new WorkingArrayStringListException("Array is full!");
        }
        String item = arrayList[index];
        for (int i = index; i < arrayList.length - 1; i++) {
            arrayList[i] = arrayList[i + 1];

            if (i == arrayList.length - 1) {
                arrayList[i] = null;
            }

        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        for (int i = 0; i < arrayList.length; i++) {
            if (Objects.equals(arrayList[i], item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < arrayList.length; i++) {
            if (Objects.equals(arrayList[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = arrayList.length - 1; i >= 0; i--) {
            if (Objects.equals(arrayList[i], item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        if (index > arrayList.length) {
            throw new WorkingArrayStringListException("Array is full!");
        }
        if (arrayList[index] != null) {
            return arrayList[index];
        }
        throw new WorkingArrayStringListException("Parameter is not found.");
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            throw new WorkingArrayStringListException("Parameter is null");
        }
        if (this.equals(otherList)) {
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        int count = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null) {
                count++;
            }
        }
        return count;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = null;
        }
    }

    @Override
    public String[] toArray() {
        String[] newArray = new String[arrayList.length];
        for (int i = 0; i < arrayList.length; i++) {
            newArray[i] = arrayList[i];
        }
        return newArray;
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }
}
