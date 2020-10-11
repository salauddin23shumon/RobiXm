package com.sss.robixm.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.sss.robixm.R;
import com.sss.robixm.adapter.viewHolder.AudioViewHolder;
import com.sss.robixm.adapter.viewHolder.DocViewHolder;
import com.sss.robixm.adapter.viewHolder.VideoViewHolder;
import com.sss.robixm.dataModel.AudioItem;
import com.sss.robixm.dataModel.Chapter;
import com.sss.robixm.dataModel.DocItem;
import com.sss.robixm.dataModel.RecyclerViewItem;
import com.sss.robixm.dataModel.VideoItem;

import java.util.ArrayList;
import java.util.List;

import static com.sss.robixm.Constants.AUDIO;
import static com.sss.robixm.Constants.CHAPTER;
import static com.sss.robixm.Constants.DOC;
import static com.sss.robixm.Constants.VIDEO;


public class ParentAdapter extends RecyclerView.Adapter {

    private List<RecyclerViewItem> parentList;
    private Context context;
    public static final String TAG = "ParentAdapter ";

    public ParentAdapter(List<RecyclerViewItem> parentList, Context context) {
        this.parentList = parentList;
        this.context = context;
    }

    @Override
    public int getItemViewType(int position) {
        switch (parentList.get(position).getViewType()) {
            case 0:
                return CHAPTER;
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
            case 0:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.chapter_layout, parent, false);
                return new ChapterViewHolder(view);
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
        RecyclerViewItem item = parentList.get(position);

        if (holder instanceof ChapterViewHolder) {
            Chapter chapter = (Chapter) item;
            ((ChapterViewHolder) holder).chapterTV.setText(chapter.getChapterName());
            List<RecyclerViewItem> childList = new ArrayList<>();

            if (chapter.getVideoItems() != null)
                childList.addAll(chapter.getVideoItems());

            if (chapter.getDocItemList() != null)
                childList.addAll(chapter.getDocItemList());

            if (chapter.getAudioItems() != null)
                childList.addAll(chapter.getAudioItems());

            ChildAdapter adapter = new ChildAdapter(childList, context);
            ((ChapterViewHolder) holder).recyclerView.setAdapter(adapter);

            boolean isExpanded = chapter.isExpanded();
            if (isExpanded) {
                ((ChapterViewHolder) holder).expandableLayout.setVisibility(View.VISIBLE);
                ((ChapterViewHolder) holder).indicator.setImageResource(R.drawable.ic_remove_24);
            } else {
                ((ChapterViewHolder) holder).expandableLayout.setVisibility(View.GONE);
                ((ChapterViewHolder) holder).indicator.setImageResource(R.drawable.ic_add_24);
            }

        } else if (holder instanceof VideoViewHolder) {
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
        Log.d(TAG, "getItemCount: " + parentList.size());
        return parentList.size();
    }


    public class ChapterViewHolder extends RecyclerView.ViewHolder {

        private TextView chapterTV;
        private ImageView indicator;
        private ConstraintLayout expandableLayout;
        private RecyclerView recyclerView;

        public ChapterViewHolder(@NonNull View itemView) {
            super(itemView);
            chapterTV = itemView.findViewById(R.id.chapter_nameTV);
            indicator = itemView.findViewById(R.id.indicatorIV);
            expandableLayout = itemView.findViewById(R.id.expandableLayout);
            recyclerView = itemView.findViewById(R.id.childRV);
            recyclerView.setHasFixedSize(true);
            recyclerView.setLayoutManager(new LinearLayoutManager(context));


            indicator.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    Chapter chapter = (Chapter) parentList.get(getAdapterPosition());
                    chapter.setExpanded(!chapter.isExpanded());
                    notifyItemChanged(getAdapterPosition());

                }
            });
        }
    }

}
