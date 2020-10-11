package com.sss.robixm.adapter.viewHolder;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.sss.robixm.R;

public class DocViewHolder extends RecyclerView.ViewHolder {

    public TextView titleTV, authorTV;
    public ConstraintLayout docCL;

    public DocViewHolder(@NonNull View itemView) {
        super(itemView);
        titleTV = itemView.findViewById(R.id.titleTV);
        authorTV = itemView.findViewById(R.id.authorTV);
        docCL = itemView.findViewById(R.id.docCL);
    }
}
