package com.sss.robixm.adapter.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sss.robixm.R;

public class AudioViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTV;
    public ConstraintLayout audioCL;

    public AudioViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTV = itemView.findViewById(R.id.titleTV);
        audioCL = itemView.findViewById(R.id.audioCL);
    }
}