package com.bequite.rathind.datingapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder>{

    public static  final String  KEY_NAME = "name";
    public static  final String  KEY_IMAGE= "image";
    public static  final String  KEY_URl= "url";


    private List<UserDetails> userDetails;
    private Context context;

    public CardViewAdapter(List<UserDetails> userDetails, Context context){
        this.userDetails = userDetails;
        this.context = context;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view =inflater.inflate(R.layout.cardview,parent,false);
        return new CardViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        UserDetails userDetail = userDetails.get(position);
        holder.user.setText(userDetail.getUsername());
        holder.cityName.setText(userDetail.getCityname());
        Picasso.with(context)
                .load(userDetail.getAvatar())
                .into(holder.avatar);

    }

    @Override
    public int getItemCount() {
        return userDetails.size();
    }


//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.cardview,parent, false);
//        return new ViewHolder(v);
//    }
//
//
//
//    @Override
//    public void onBindViewHolder( ViewHolder holder, int position) {
//        final UserDetails userDetail = userDetails.get(position);
//        holder.user.setText(userDetail.getUsername());
//        Picasso.with(context)
//                .load(userDetail.getAvatar())
//                .into(holder.avatar);
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return userDetails.size();
//    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
//        define the view object
        public TextView user;
        public TextView cityName;
        public ImageView avatar;
        public LinearLayout linearLayout;

        public CardViewHolder(View itemView) {
            super(itemView);
//            initialize the view object
            user = (TextView) itemView.findViewById(R.id.name);
            avatar=(ImageView) itemView.findViewById(R.id.img);
            cityName=(TextView) itemView.findViewById(R.id.txtview3);
            linearLayout =(LinearLayout) itemView.findViewById(R.id.linerLayout);

        }
    }
}
