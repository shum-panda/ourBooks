package net.sharksystem.app.componentbasedappskeleton.app;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

import net.sharksystem.app.componentbasedappskeleton.R;
import net.sharksystem.app.componentbasedappskeleton.app.componentB.ComponentB;
import net.sharksystem.app.componentbasedappskeleton.app.componentB.ComponentBImpl;
import net.sharksystem.app.componentbasedappskeleton.componentA.ComponentA;
import net.sharksystem.app.componentbasedappskeleton.componentA.ComponentAImpl;
import net.sharksystem.app.componentbasedappskeleton.app.ui.ComponentAActivity;
import net.sharksystem.app.componentbasedappskeleton.app.ui.ComponentBActivity;

/**
 * Singleton - knows all the components
 */
public class ThisApp implements NavigationView.OnNavigationItemSelectedListener {
    private static ThisApp thisApp;

    private ThisApp() {
        // could do some init stuff, e.g. reading persistent info from database / file..
    }

    public static ThisApp getThisApp() {
        if(ThisApp.thisApp == null) {
            ThisApp.thisApp = new ThisApp();
        }

        return ThisApp.thisApp;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //                   factory methods of all sub component of this app                      //
    /////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * Convenience: Could call directly factory method in component implementation.
     * This variant allows you to forget what components are in your system at all.
     * Found it helpful.
     * @return component a instance (a singleton in that case)
     */
    public ComponentA getComponentA() {
        return ComponentAImpl.getComponentA();
    }

    public ComponentB getComponentB() {
        return ComponentBImpl.getComponentB();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //                                debugging helper                                         //
    /////////////////////////////////////////////////////////////////////////////////////////////

    protected String getLogStart() {
        return this.getClass().getSimpleName();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //                             let users switch between components                         //
    /////////////////////////////////////////////////////////////////////////////////////////////

    //////////// drawer menu management
    private Activity drawerActivity = null;
    private DrawerLayout mDrawerLayout = null;

    public void setupDrawerLayout(Activity activity) {
        this.mDrawerLayout = activity.findViewById(R.id.sharknet_drawer_layout);
        if(mDrawerLayout == null) {
            Log.d(this.getLogStart(), "cannot find drawer layout: " +
                    R.id.sharknet_drawer_layout);
            return;
        }

        // add listener to drawer items
        NavigationView navigationView = activity.findViewById(R.id.sharknet_drawer_navigation_view);
        navigationView.setNavigationItemSelectedListener(this);
        // remeber
        this.drawerActivity = activity;
    }

    //////////// drawer menu actions - it is a delegate
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        try {
            Intent intent = null;
            switch (itemId) {
                case R.id.componentA:
                    intent = new Intent(this.drawerActivity, ComponentAActivity.class);
                    this.drawerActivity.startActivity(intent);
                    break;

                case R.id.componentB:
                    intent = new Intent(this.drawerActivity, ComponentBActivity.class);
                    this.drawerActivity.startActivity(intent);
                    break;
            }
            this.mDrawerLayout.closeDrawers();
        }
        catch(Throwable t) {
            Log.d(this.getLogStart(), "while handling navigation item selected");
            Log.d(this.getLogStart(), t.getLocalizedMessage());
        }

        return true;
    }
}
