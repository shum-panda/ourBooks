package net.sharksystem.app.componentbasedappskeleton.app;

import android.os.Bundle;

import androidx.annotation.CallSuper;
import androidx.appcompat.app.AppCompatActivity;

// you can derive from any activity (subclass) your want.
public class ThisAppActivity extends AppCompatActivity {
    protected ThisApp getThisApp() {
        return ThisApp.getThisApp();
    }
    protected String getLogStart() {
        return this.getClass().getSimpleName();
    }
    protected void activateDrawerMenu() {
        this.getThisApp().setupDrawerLayout(this);
    }
}

