package net.sharksystem.app.componentbasedappskeleton.app.componentB;

/**
 * Component B control - singleton
 */
public class ComponentBImpl implements ComponentB {
    private static ComponentB instance;

    private ComponentBImpl() {
        // do some init stuff here
    }

    /** singleton */
    public static ComponentB getComponentB() {
        if(ComponentBImpl.instance == null) {
            ComponentBImpl.instance = new ComponentBImpl();
        }
        return ComponentBImpl.instance;
    }

    /** create multiple objects of this components - be aware of synchronisation issues */
    public static ComponentB getNewComponentB() {
        return new ComponentBImpl();
    }

    private static int value = Integer.MAX_VALUE;
    @Override
    public int getExampleValue() {
        return ComponentBImpl.value--;
    }

    /////////////////////////////////////////////////////////////////////////////////////////
    //                          factory methods for sub components                         //
    /////////////////////////////////////////////////////////////////////////////////////////

    private DataStorageB dataStorageB = null;
    @Override
    public DataStorageB getDataStorage() {
        if(this.dataStorageB == null) {
            this.dataStorageB = new DataStorageBImpl();
        }

        return this.dataStorageB;
    }
}
