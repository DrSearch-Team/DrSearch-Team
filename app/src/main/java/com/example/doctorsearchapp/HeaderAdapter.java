package com.example.doctorsearchapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.doctorsearchapp.fragments.ComposeFragment;
import com.example.doctorsearchapp.fragments.DetailFragment;

import java.util.concurrent.Callable;

public class HeaderAdapter extends RecyclerView.Adapter<HeaderAdapter.HeaderViewHolder> {

    private Context context;

    public HeaderAdapter(Context context)
    {
        this.context = context;
    }

    // Inflate the view and return the HeaderViewHolder
    @NonNull
    @Override
    public HeaderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.header_layout,parent,false);
        return new HeaderViewHolder(view);
    }

    // Bind information to the Header
    @Override
    public void onBindViewHolder(@NonNull HeaderViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 1;
    }



    class HeaderViewHolder extends  RecyclerView.ViewHolder
    {
        private Button reviewBtn;
        private Button searchBtn;

        public HeaderViewHolder(@NonNull View itemView) {
            super(itemView);
            reviewBtn = itemView.findViewById(R.id.reviewBtn);
            searchBtn = itemView.findViewById(R.id.btnSearch);

            reviewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    MainActivity activity = (MainActivity) context;
                    activity.getSupportFragmentManager().beginTransaction().replace(R.id.flContainer,new ComposeFragment()).commit();
                }
            });

            searchBtn.setOnClickListener(new View.OnClickListener(){
                @Override
                public  void onClick(View view){

                    Uri gmIntentUri = Uri.parse("https://www.google.com/maps/search/?api=1&query=1322 Mauna Loa Road, Tustin, CA");
                    // 1171 El Camino Real, Tustin, CA 92780

                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");

                    context.startActivity(mapIntent);
                }
            });
        }
    }

}
