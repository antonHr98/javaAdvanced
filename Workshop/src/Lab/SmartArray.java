package Lab;

public class SmartArray {
    private Integer[] elementsArray;
    private int arraySize;

    public SmartArray() {
        this.elementsArray = new Integer[4];
        this.arraySize = 0;
    }

    public void add(int element) {
        if (this.arraySize == this.elementsArray.length) {
            this.elementsArray = evolve();
        }
        this.elementsArray[arraySize] = element;
        arraySize++;
    }

    public void addTo(int index, int element) {
        validateIndex(index);
        int lastIndex = this.arraySize -1;
        int lastElement = this.elementsArray[lastIndex];

        for (int i = lastElement; i > index; i--) {
            this.elementsArray[i]=this.elementsArray[i-1];
        }
        this.elementsArray[index]=element;
        add(lastElement);
    }

    public int remove(int index) {
        validateIndex(index);
        this.arraySize--;

        int element = this.elementsArray[index];
        for (int i = 0; i < this.arraySize; i++) {
            this.elementsArray[i] = this.elementsArray[i + 1];
        }

        this.elementsArray[this.arraySize] = null;
        return element;
    }

    public boolean contains(int element) {
        for (int i = 0; i < this.arraySize; i++) {
            if (this.elementsArray[i] == element) {
                return true;
            }
        }
        return false;
    }

    public int get(int index) {
        validateIndex(index);
        return this.elementsArray[index];
    }

    public void validateIndex(int index) {
        if (index < 0 || index >= this.arraySize) {
            throw new IndexOutOfBoundsException("Invalid index in the array: [" + index + "]!");
        }
    }

    public int arraySize() {
        return this.arraySize;
    }

    private Integer[] evolve() {
        Integer[] moreElements = new Integer[elementsArray.length * 2];
        for (int i = 0; i < this.elementsArray.length; i++) {
            moreElements[i] = elementsArray[i];
        }
        return moreElements;
    }
}