package com.vachan.vachan.adaptors;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.vachan.vachan.R;

/**
 * Created by leela on 16/4/16.
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.PersonViewHolder> {

   private  Context context;
    public RecyclerViewAdapter(Context context){

        this.context = context;


    }


    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.couple_shoot_recycler,null);
        return new PersonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {




    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class PersonViewHolder extends RecyclerView.ViewHolder{


        public PersonViewHolder(View itemView) {
            super(itemView);
            TextView textView = (TextView)itemView.findViewById(R.id.edit_price);
            final TextView priceTextView =(TextView)itemView.findViewById(R.id.price);
            textView.setText(Html.fromHtml("<u>Edit Price</u>"));
            textView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showChangeLangDialog(v.getContext(), priceTextView);
                }
            });
        }



    }

    public static void showChangeLangDialog(Context context,final TextView pricetext) {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View dialogView = inflater.inflate(R.layout.alert_dailog, null);
        dialogBuilder.setView(dialogView);

        final EditText edt = (EditText) dialogView.findViewById(R.id.edit_alert_price);
        edt.setText(pricetext.getText().toString());

        dialogBuilder.setTitle("Event Pricing");
        dialogBuilder.setMessage("Enter Coupleshoot price");
        dialogBuilder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                pricetext.setText(edt.getText().toString());
            }
        });
        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //pass
            }
        });
        AlertDialog b = dialogBuilder.create();
        b.show();
    }




}
