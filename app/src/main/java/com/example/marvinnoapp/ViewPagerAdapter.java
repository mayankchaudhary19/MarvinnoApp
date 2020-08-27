package com.example.marvinnoapp;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerAdapter extends RecyclerView.Adapter<ViewPagerAdapter.ViewHolder> {

    private List<IntroModel> introModelList ;
    Context context;

    public ViewPagerAdapter(Context context,List<IntroModel> introModelList) {
        this.context= context;
        this.introModelList = introModelList;
    }

    @NonNull
    @Override
    public ViewPagerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.container_intro_view_pager,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.ViewHolder holder, int position) {
        int img =introModelList.get(position).getImg();
        String title =introModelList.get(position).getHeading();
        String subtitle =introModelList.get(position).getSubheading();
        holder.setData(img,title,subtitle);
    }

    @Override
    public int getItemCount() {
        return introModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView title,subtitle;
        public ViewHolder(@NonNull final View view) {
            super(view);
            imageView = view.findViewById(R.id.introImage);
            title = view.findViewById(R.id.introHeading);
            subtitle= view.findViewById(R.id.introSubHeading);

        }

        private void setData(int image, String heading, String subheading) {
            imageView.setImageResource(image);
            title.setText(heading);
            subtitle.setText(subheading);

        }
    }
}
