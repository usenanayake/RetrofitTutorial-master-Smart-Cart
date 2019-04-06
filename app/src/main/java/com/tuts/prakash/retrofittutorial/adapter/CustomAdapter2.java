package com.tuts.prakash.retrofittutorial.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.tuts.prakash.retrofittutorial.R;
import com.tuts.prakash.retrofittutorial.model.RetroPhoto;

import java.util.List;

public class CustomAdapter2 extends RecyclerView.Adapter<CustomAdapter2.CustomViewHolder> {

    private List<RetroPhoto> dataList;
    private Context context;

    public CustomAdapter2(Context context,List<RetroPhoto> dataList){
        this.context = context;
        this.dataList = dataList;
    }

    class CustomViewHolder extends RecyclerView.ViewHolder {

        public final View mView;
        private Button mRemoveButton;

        TextView txtTitle;
        TextView txtTitle2;
        private ImageView coverImage;

        CustomViewHolder(View itemView) {
            super(itemView);
            mView = itemView;

            txtTitle = mView.findViewById(R.id.title);
            txtTitle2 = mView.findViewById(R.id.title2);
            coverImage = mView.findViewById(R.id.coverImage);
            mRemoveButton = mView.findViewById(R.id.delete);
        }
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.custom_row2, parent, false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomViewHolder holder, final int position) {
        if(dataList.get(position).getname().equals("0158CD")){
            //holder.txtTitle.setText(dataList.get(position).getname());
            //holder.txtTitle2.setText(dataList.get(position).getprice());
//            holder.txtTitle.setText("denim");
//            holder.txtTitle2.setText("1000");

            holder.txtTitle.setText("T shirt");
            holder.txtTitle2.setText(dataList.get(position).getprice());


//        Picasso.Builder builder = new Picasso.Builder(context);
//        builder.downloader(new OkHttp3Downloader(context));
//        builder.build().load(dataList.get(position).getThumbnailUrl())
//                .placeholder((R.drawable.ic_launcher_background))
//                .error(R.drawable.ic_launcher_background)
//                .into(holder.coverImage);
        }
        else {
//            holder.txtTitle.setText("skirt");
//            holder.txtTitle2.setText("690");

            holder.txtTitle.setText("Skirt");
            holder.txtTitle2.setText(dataList.get(position).getprice());

        }

        holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              dataList.remove(position);
              notifyItemRemoved(position);

                notifyItemRangeChanged(position,dataList.size());

                // Show the removed item label
                Toast.makeText(context,"Removed ",Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }
}