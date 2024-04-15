package net.sharksystem.app.componentbasedappskeleton.app.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import net.sharksystem.app.componentbasedappskeleton.R;
import net.sharksystem.app.componentbasedappskeleton.app.ThisAppActivity;
import net.sharksystem.app.componentbasedappskeleton.componentA.ComponentA;

public class ComponentAActivity extends ThisAppActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thisapp_drawer_activity_example_layout);
        this.activateDrawerMenu();
    }

    public void onButtonClicked(View view) {
        Log.println(Log.INFO, this.getLogStart(), ": onButtonClicked reached");
        Toast.makeText(this,
                this.getLogStart() + ": buttonClicked", Toast.LENGTH_SHORT).show();

        // do some application logic

        // get control
        ComponentA compA = getThisApp().getComponentA();

        // let control do something - returned value is to be presented on screen
        int value = compA.getExampleValue();

        // put result on screen
        Button b = (Button) view;
        b.setText(String.valueOf(value));
    }
}
