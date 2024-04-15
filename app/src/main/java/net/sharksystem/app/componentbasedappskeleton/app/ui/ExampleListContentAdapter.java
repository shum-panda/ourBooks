package net.sharksystem.app.componentbasedappskeleton.app.ui;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import net.sharksystem.app.componentbasedappskeleton.R;
import net.sharksystem.app.componentbasedappskeleton.app.ThisApp;
import net.sharksystem.app.componentbasedappskeleton.app.componentB.DataStorageB;

class ExampleListContentAdapter extends
        RecyclerView.Adapter<ExampleListContentAdapter.MyViewHolder>
        implements View.OnClickListener {

    private final Context ctx;
    private View.OnClickListener clickListener;

    @Override
    public ExampleListContentAdapter.MyViewHolder onCreateViewHolder(
            ViewGroup parent, int viewType) {
        Log.d(this.getLogStart(), "onCreateViewHolder");

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.example_list_row, parent, false);

        return new ExampleListContentAdapter.MyViewHolder(itemView);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView entry1TextView, entry2TextView, ageTextView;

        public MyViewHolder(View view) {
            super(view);
            entry1TextView = (TextView) view.findViewById(R.id.example_list_row_entry1);
            entry2TextView = (TextView) view.findViewById(R.id.example_list_row_entry2);
            view.setOnClickListener(clickListener);
        }
    }

    public ExampleListContentAdapter(Context ctx) {
        Log.d(this.getLogStart(), "constructor");
        this.ctx = ctx;
        this.clickListener = this;
    }

    @Override
    public void onBindViewHolder(ExampleListContentAdapter.MyViewHolder holder, int position) {
        Log.d(this.getLogStart(), "onBindViewHolder with position: " + position);

        // get storage
        DataStorageB storage = ThisApp.getThisApp().getComponentB().getDataStorage();

        // set actual values in list row
        holder.entry1TextView.setText(storage.getElement1(position));
        holder.entry2TextView.setText(storage.getElement2(position));

        holder.itemView.setId(position); // really helpful - see onClick
    }

    @Override
    public int getItemCount() {
        Log.d(this.getLogStart(), "called getItemCount");

        DataStorageB storage = ThisApp.getThisApp().getComponentB().getDataStorage();
        return storage.getSize();
    }

    @Override
    public void onClick(View view) {
        Log.d(this.getLogStart(), "click on view recognized");

        TextView entry1TextView = (TextView) view.findViewById(R.id.example_list_row_entry1);
        Log.d(this.getLogStart(), "uri: " + entry1TextView.getText());

        TextView entry2TextView = (TextView) view.findViewById(R.id.example_list_row_entry1);
        Log.d(this.getLogStart(), "name: " + entry2TextView.getId());

        /* launch an activity after choosing an entry
        Intent intent = new Intent(ctx);
        this.putExtra(KEY_1, entry1TextView.getText()); // text
        this.putExtra(KEY_2, entry2TextView.getId()); // id most probably better
        ctx.startActivity(intent);
         */

        String illustrationText = "row selected: e1.text: " + entry1TextView.getText();
        // get back id, see onBindViewHolder
        illustrationText += " | view.id: " + view.getId();

        Toast.makeText(this.ctx, illustrationText, Toast.LENGTH_SHORT).show();
        Log.i(this.getLogStart(), illustrationText);
    }

    private String getLogStart() {
        return this.getClass().getSimpleName() + ": ";
    }
}

