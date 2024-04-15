package net.sharksystem.app.componentbasedappskeleton.app.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.sharksystem.app.componentbasedappskeleton.R;
import net.sharksystem.app.componentbasedappskeleton.app.ThisAppActivity;

public class ComponentBActivity extends ThisAppActivity {
    private RecyclerView mRecyclerView;
    private ExampleListContentAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            // present GUI
            setContentView(R.layout.thisapp_drawer_activity_list_example_layout);

            // set drawer menu listener in action
            this.activateDrawerMenu();

            ////////////////////////////////////////////////////////////////////////
            //                         prepare action bar                         //
            ////////////////////////////////////////////////////////////////////////
            // setup toolbar
            Toolbar myToolbar = (Toolbar) findViewById(R.id.thisapp_list_with_toolbar_example);
            setSupportActionBar(myToolbar);

            ////////////////////////////////////////////////////////////////////////
            //                         prepare recycler view                      //
            ////////////////////////////////////////////////////////////////////////

            mRecyclerView = (RecyclerView) findViewById(R.id.sn_channel_list_recycler_view);

            mAdapter = new ExampleListContentAdapter(this);
            RecyclerView.LayoutManager mLayoutManager =
                    new LinearLayoutManager(getApplicationContext());

            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setItemAnimator(new DefaultItemAnimator());
            mRecyclerView.setAdapter(mAdapter);
            Log.d(this.getLogStart(), "attached content adapter");
        }
            catch(Exception e) {
            Log.d(this.getLogStart(), "problems while attaching content adapter: "
                    + e.getLocalizedMessage());
        }
    }

    /////////////////////////////////////////////////////////////////////////////////
    //                              toolbar methods                                //
    /////////////////////////////////////////////////////////////////////////////////

    /**
     * connect menu with menu items and make them visible
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.thisapp_toolbar_example_buttons, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String text = "toolbar button clicked: ";
        try {
            switch (item.getItemId()) {
                case R.id.doAButton:
                    text += "A"; break;

                case R.id.doBButton:
                    text += "B"; break;

                default:
                    // If we got here, the user's action was not recognized.
                    // Invoke the superclass to handle it.
                    return super.onOptionsItemSelected(item);
            }

            Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
        }
        catch(Exception e) {
            Log.d(this.getLogStart(), e.getLocalizedMessage());
        }

        return false;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    //                                     life cycle                                          //
    /////////////////////////////////////////////////////////////////////////////////////////////

    protected void onResume() {
        super.onResume();
        Log.d(this.getLogStart(), "onResume");

        if(mAdapter != null) {
            mAdapter.notifyDataSetChanged();
        }
    }
}
