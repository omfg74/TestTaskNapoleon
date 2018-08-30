package com.example.omfg.napoleontesttask;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;

public class TopRecyclerViewAdapter extends RecyclerView.Adapter<TopRecyclerViewAdapter.TopViewHolder> {
    private List<TopRecyclerViewItem> items;
Context context;
    public TopRecyclerViewAdapter(Context context, List<TopRecyclerViewItem> items) {
        this.context = context;
        this.items = items;

    }

    @NonNull
    @Override
    public TopViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view  = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_list_item,parent,false);
        return new TopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopViewHolder holder, int position) {

       holder.
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(Collection<TopRecyclerViewItem> item){
        items.addAll(item);
        notifyDataSetChanged();
    }
    public void clearItems(){
        items.clear();
        notifyDataSetChanged();
    }

    public static class TopViewHolder extends RecyclerView.ViewHolder{
        private ImageView topRecyclerViewImage;
        private TextView topRecyclerViewText;

        public TopViewHolder(View itemView){
            super(itemView);

            topRecyclerViewImage = itemView.findViewById(R.id.top_recyclerView_image);
            topRecyclerViewText = itemView.findViewById(R.id.top_recyclerView_Text);



        }
        public void bind(TopRecyclerViewItem item){
            topRecyclerViewText.setText("TEST TEXT");
            topRecyclerViewImage.setImageBitmap(R.drawable.ic_launcher_background);
        }



    }


}
