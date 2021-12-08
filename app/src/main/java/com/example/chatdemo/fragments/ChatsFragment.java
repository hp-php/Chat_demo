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
import com.example.chatdemo.model.EventModelChats;

import java.util.ArrayList;
import java.util.List;


public class ChatsFragment extends Fragment {

    RecyclerView recyclerViewChats;
    ChatsAdapter chatsAdapter;
    List<EventModelChats> listdata = new ArrayList<>();

    public ChatsFragment() {
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


        View v = inflater.inflate(R.layout.fragment_chats, container, false);

        recyclerViewChats = v.findViewById(R.id.recyclerViewChats);
        //list view

        listdata.add(new EventModelChats("Name","title","10:23 am"));
        listdata.add(new EventModelChats("Name","title","10:23 am"));
        listdata.add(new EventModelChats("Name","title","10:23 am"));
        listdata.add(new EventModelChats("Name","title","10:23 am"));
        listdata.add(new EventModelChats("Name","title","10:23 am"));
        listdata.add(new EventModelChats("Name","title","10:23 am"));

        chatsAdapter = new ChatsAdapter(listdata);
        recyclerViewChats.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewChats.setAdapter(chatsAdapter);

        return v;
    }

    public static class ChatsAdapter extends RecyclerView.Adapter<ChatsAdapter.ViewHolder> {
        private List<EventModelChats> listdata;

        // RecyclerView recyclerView;
        public ChatsAdapter(List<EventModelChats> listdata) {
            1`this.listdata = listdata;
        }

        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View listItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.chats_listview, parent, false);
            ViewHolder viewHolder = new ViewHolder(listItem);
            return viewHolder;
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            final EventModelChats myListData = listdata.get(position);

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