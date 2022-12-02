import java.util.Arrays;
import java.util.Objects;

public class StringListImpl implements StringList {

    private final String[] arrayList;

    private int size;

    public StringListImpl() {
        arrayList = new String[7];
    }

    public StringListImpl(int size) {
        this.arrayList = new String[size];
    }

    @Override
    public String add(String item) {
        validateItem(item);
        validateSizeArray();
        arrayList[size++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        validateItem(item);
        validateSizeArray();
        validateIndex(index);

        if (index == size) {
            arrayList[size++] = item;
            return item;
        }

        System.arraycopy(arrayList, index, arrayList, index +1, size - index);
        arrayList[index] = item;
        size++;

        return item;
    }

    @Override
    public String set(int index, String item) {
        validateItem(item);
        validateSizeArray();
        arrayList[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        validateItem(item);

        int index = indexOf(item);

        return remove(index);
    }

    @Override
    public String remove(int index) {
        validateIndex(index);

        String item = arrayList[index];

        if (index != size) {
            System.arraycopy(arrayList, index +1, arrayList, index, size - index);
        }

        size--;
        return item;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        for (int i = 0; i < size; i++) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        for (int i = size - 1; i >= 0; i--) {
            if (arrayList[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String get(int index) {
        validateIndex(index);
        return arrayList[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        size = 0;
    }

    @Override
    public String[] toArray() {
        return Arrays.copyOf(arrayList, size);
    }

    private void validateIndex(int index) {
        if (index < 0 || index > size) {
            throw new WorkingArrayStringListException("Array is full! Invalid index to add.");
        }
    }

    private void validateItem(String item) {
        if (item == null) {
            throw new WorkingArrayStringListException("Item is null.");
        }
    }

    private void validateSizeArray() {
        if (arrayList.length == size) {
            throw new WorkingArrayStringListException("Array is full!");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringListImpl that = (StringListImpl) o;
        return size == that.size && Arrays.equals(arrayList, that.arrayList);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size);
        result = 31 * result + Arrays.hashCode(arrayList);
        return result;
    }

    @Override
    public String toString() {
        return "StringListImpl{" +
                "arrayList=" + Arrays.toString(arrayList) +
                '}';
    }
}
