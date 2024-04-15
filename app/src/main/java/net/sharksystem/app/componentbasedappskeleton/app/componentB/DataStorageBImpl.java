package net.sharksystem.app.componentbasedappskeleton.app.componentB;

class DataStorageBImpl implements DataStorageB {
    private static final int EXAMPLE_SIZE = 5;
    private static final String EXAMPLE_ELEMENT1_VALUE = "exampleValue1";
    private static final String EXAMPLE_ELEMENT2_VALUE = "exampleValue2";

    @Override
    public int getSize() {
        return EXAMPLE_SIZE;
    }

    @Override
    public String getElement1(int position) {
        return EXAMPLE_ELEMENT1_VALUE;
    }

    @Override
    public String getElement2(int position) {
        return EXAMPLE_ELEMENT2_VALUE;
    }
}
