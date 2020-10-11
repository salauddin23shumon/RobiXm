package com.sss.robixm.adapter.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sss.robixm.R;

public class VideoViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTV;
    public ConstraintLayout videoCL;

    public VideoViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTV = itemView.findViewById(R.id.titleTV);
        videoCL = itemView.findViewById(R.id.videoCL);
    }
}