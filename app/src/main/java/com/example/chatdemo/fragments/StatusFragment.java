package com.example.chatdemo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.chatdemo.R;
import com.example.chatdemo.model.EventModelStatus;
import com.example.chatdemo.model.EventModelStatus;

import java.util.ArrayList;
import java.util.List;


public class StatusFragment extends Fragment {
    RecyclerView recyclerViewStatus;
    StatusAdapter statusAdapter;
    List<EventModelStatus> listdata = new ArrayList<>();


    public StatusFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_status, container, false);

        recyclerViewStatus = v.findViewById(R.id.recyclerViewStatus);

        listdata.add(new EventModelStatus("Name1","title1","10:23 am"));
        listdata.add(new EventModelStatus("Name2","title2","10:23 am"));
        listdata.add(new EventModelStatus("Name3","title3","10:23 am"));
        listdata.add(new EventModelStatus("Name4","title4","10:23 am"));
        listdata.add(new EventModelStatus("Name5","title5","10:23 am"));
        listdata.add(new EventModelStatus("Name6","title6","10:23 am"));

        statusAdapter = new StatusAdapter(listdata);
        recyclerViewStatus.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewStatus.setAdapter(statusAdapter);


        return v;
    }
    public class StatusAdapter extends RecyclerView.Adapter<StatusAdapter.ViewHolder> {
        private List<EventModelStatus> listdata;

        // RecyclerView recyclerView;
        public StatusAdapter(List<EventModelStatus> listdata) {
            this.listdata = listdata;
        }

        @Override
        public StatusAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.status_listview, parent, false);
            StatusAdapter.ViewHolder viewHolder = new StatusAdapter.ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(StatusAdapter.ViewHolder holder, int position) {
            final EventModelStatus myListData = listdata.get(position);

            holder.tvNameFirst.setText(myListData.name);
            holder.tvTime.setText(myListData.date);
            holder.tvSubtitle.setText(myListData.title1);


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(view.getContext(), "click on item: " + myListData.name, Toast.LENGTH_LONG).show();
                }
            });
        }

        @Override
        public int getItemCount() {
            return listdata.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView tvNameFirst, tvSubtitle, tvTime;

            public ViewHolder(View itemView) {
                super(itemView);
                this.tvNameFirst = itemView.findViewById(R.id.tvNameFirst);
                this.tvTime = itemView.findViewById(R.id.tvTime);
                this.tvSubtitle = itemView.findViewById(R.id.tvSubtitle);

            }
        }
    }
}