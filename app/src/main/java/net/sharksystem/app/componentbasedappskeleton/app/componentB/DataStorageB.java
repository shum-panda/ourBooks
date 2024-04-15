package net.sharksystem.app.componentbasedappskeleton.app.componentB;

public interface DataStorageB {
    /**
     *
     * @return number of elements
     */
    int getSize();

    /**
     * Example - return a value from a storage
     * @param position position (imagine a line, an index, ..)
     * @return actual value
     */
    String getElement1(int position);

    String getElement2(int position);
}
