package com.example.omfg.napoleontesttask.ViewControllers;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import AppObjects.Banner;

import com.example.omfg.napoleontesttask.Networking.Requests.ImageDownloader;
import com.example.omfg.napoleontesttask.R;

import java.util.List;
import java.util.concurrent.ExecutionException;


public class TopRecyclerViewAdapter extends RecyclerView.Adapter<TopRecyclerViewAdapter.TopViewHolder> {
    private List<Banner> banners;
    Context context;

    public TopRecyclerViewAdapter(Context context, List<Banner> banners) {
        this.context = context;
        this.banners = banners;


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

       holder.bind(banners.get(position));
    }

    @Override
    public int getItemCount() {
        return banners.size();
    }

    public static class TopViewHolder extends RecyclerView.ViewHolder{
        private ImageView topRecyclerViewImage;
        private TextView topRecyclerViewText;
        private TextView topRecyclerViewDec;

        public TopViewHolder(View itemView){
            super(itemView);

            topRecyclerViewImage = itemView.findViewById(R.id.top_recyclerView_image);
            topRecyclerViewText = itemView.findViewById(R.id.top_recyclerView_Text);
            topRecyclerViewDec = itemView.findViewById(R.id.top_recyclerView_Desc);



        }
        public void bind(Banner banner){
            topRecyclerViewText.setText(banner.getTitle());
            ImageDownloader imageDownloader = new ImageDownloader();
            imageDownloader.execute(banner.getImage());


            try {
                topRecyclerViewImage.setImageBitmap(imageDownloader.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            topRecyclerViewDec.setText(banner.getDesc());

        }




    }


}
