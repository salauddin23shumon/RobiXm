package com.sss.robixm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sss.robixm.R;
import com.sss.robixm.adapter.viewHolder.AudioViewHolder;
import com.sss.robixm.adapter.viewHolder.DocViewHolder;
import com.sss.robixm.adapter.viewHolder.VideoViewHolder;
import com.sss.robixm.dataModel.AudioItem;
import com.sss.robixm.dataModel.DocItem;
import com.sss.robixm.dataModel.RecyclerViewItem;
import com.sss.robixm.dataModel.VideoItem;

import java.util.List;

import static com.sss.robixm.Constants.AUDIO;
import static com.sss.robixm.Constants.DOC;
import static com.sss.robixm.Constants.VIDEO;

public class ChildAdapter extends RecyclerView.Adapter {

    private List<RecyclerViewItem> childList;
    private Context context;
    public static final String TAG = "ParentAdapter ";

    public ChildAdapter(List<RecyclerViewItem> childList, Context context) {
        this.childList = childList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (childList.get(position).getViewType()) {
            case 1:
                return VIDEO;
            case 2:
                return DOC;
            case 3:
                return AUDIO;
            default:
                return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        switch (viewType) {
            case 1:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_layout, parent, false);
                return new VideoViewHolder(view);
            case 2:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.doc_layout, parent, false);
                return new DocViewHolder(view);
            case 3:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_layout, parent, false);
                return new AudioViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecyclerViewItem item = childList.get(position);

        if (holder instanceof VideoViewHolder) {
            VideoItem video = (VideoItem) item;
            ((VideoViewHolder) holder).titleTV.setText(video.getVideoFileName());
            ((VideoViewHolder) holder).videoCL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "video clicked", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof DocViewHolder) {
            DocItem doc = (DocItem) item;
            ((DocViewHolder) holder).authorTV.setText(doc.getDocAuthor());
            ((DocViewHolder) holder).titleTV.setText(doc.getDocName());
            ((DocViewHolder) holder).docCL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "doc clicked", Toast.LENGTH_SHORT).show();
                }
            });
        } else if (holder instanceof AudioViewHolder) {
            AudioItem audioItem = (AudioItem) item;
            ((AudioViewHolder) holder).titleTV.setText(audioItem.getFileName());
            ((AudioViewHolder) holder).audioCL.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(context, "audio clicked", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: " + childList.size());
        return childList.size();
    }
}
