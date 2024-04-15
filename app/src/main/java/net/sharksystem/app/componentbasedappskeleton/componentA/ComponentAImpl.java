package net.sharksystem.app.componentbasedappskeleton.componentA;

/**
 * Component A control - singleton
 */
public class ComponentAImpl implements ComponentA {
    private static ComponentA instance;

    private ComponentAImpl() {
        // do some init stuff here
    }

    public static ComponentA getComponentA() {
        if(ComponentAImpl.instance == null) {
            ComponentAImpl.instance = new ComponentAImpl();
        }
        return ComponentAImpl.instance;
    }

    private static int value = 0;
    @Override
    public int getExampleValue() {
        return ComponentAImpl.value++;
    }
}
