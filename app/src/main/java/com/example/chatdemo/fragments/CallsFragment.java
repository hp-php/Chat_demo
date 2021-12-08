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
import com.example.chatdemo.model.EventModelCalls;
import com.example.chatdemo.model.EventModelChats;

import java.util.ArrayList;
import java.util.List;


public class CallsFragment extends Fragment {

    RecyclerView recyclerViewCalls;
    CallsAdapter callsAdapter;
    List<EventModelCalls> listdata = new ArrayList<>();

    public CallsFragment() {
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

        View v = inflater.inflate(R.layout.fragment_calls, container, false);

        recyclerViewCalls = v.findViewById(R.id.recyclerViewCalls);
        //list view

        listdata.add(new EventModelCalls("Name1", "title1", "10:23 am"));
        listdata.add(new EventModelCalls("Name2", "title2", "10:23 am"));
        listdata.add(new EventModelCalls("Name3", "title3", "10:23 am"));
        listdata.add(new EventModelCalls("Name4", "title4", "10:23 am"));
        listdata.add(new EventModelCalls("Name5", "title5", "10:23 am"));
        listdata.add(new EventModelCalls("Name6", "title6", "10:23 am"));

        callsAdapter = new CallsAdapter(listdata);
        recyclerViewCalls.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewCalls.setAdapter(callsAdapter);

        return v;
    }


    class CallsAdapter extends RecyclerView.Adapter<CallsAdapter.ViewHolder> {
        private List<EventModelCalls> listdata;

        // RecyclerView recyclerView;
        public CallsAdapter(List<EventModelCalls> listdata) {
            this.listdata = listdata;
        }

        @Override
        public CallsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.calls_listview, parent, false);
            CallsAdapter.ViewHolder viewHolder = new CallsAdapter.ViewHolder(listItem);
            return viewHolder;
        }


        public void onBindViewHolder(CallsAdapter.ViewHolder holder, int position) {
            final EventModelCalls myListData = listdata.get(position);

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