package com.sss.robixm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.sss.robixm.adapter.ParentAdapter;
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

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<RecyclerViewItem> itemList;
    private ParentAdapter parentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        initData();
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        parentAdapter = new ParentAdapter(itemList, this);
        recyclerView.setAdapter(parentAdapter);
    }

    private void initData() {
        List<VideoItem> videoItems1 = new ArrayList<>();
        videoItems1.add(new VideoItem(VIDEO, "android tutorial.mp4"));

        List<VideoItem> videoItems2 = new ArrayList<>();
        videoItems2.add(new VideoItem(VIDEO, "java tutorial.mp4"));
        videoItems2.add(new VideoItem(VIDEO, "python tutorial.mp4"));

        List<VideoItem> videoItems3 = new ArrayList<>();
        videoItems3.add(new VideoItem(VIDEO, "kotlin tutorial.mp4"));
        videoItems3.add(new VideoItem(VIDEO, "swift tutorial.mp4"));
        videoItems3.add(new VideoItem(VIDEO, "dart tutorial.mp4"));

        List<AudioItem> audioItems1 = new ArrayList<>();
        audioItems1.add(new AudioItem(AUDIO, "ruby tutorial.mp3"));

        List<AudioItem> audioItems2 = new ArrayList<>();
        audioItems2.add(new AudioItem(AUDIO, "android tutorial.mp3"));
        audioItems2.add(new AudioItem(AUDIO, "flutter tutorial.mp3"));

        List<AudioItem> audioItems3 = new ArrayList<>();
        audioItems3.add(new AudioItem(AUDIO, "ios tutorial.mp3"));
        audioItems3.add(new AudioItem(AUDIO, "dot net tutorial.mp3"));
        audioItems3.add(new AudioItem(AUDIO, "php tutorial.mp3"));

        List<DocItem> docItems1 = new ArrayList<>();
        docItems1.add(new DocItem(DOC, "ch-1", "xyz"));

        List<DocItem> docItems2 = new ArrayList<>();
        docItems2.add(new DocItem(DOC, "ch-3-a", "efghij"));
        docItems2.add(new DocItem(DOC, "ch-3-b", "iklmno"));
        docItems2.add(new DocItem(DOC, "ch-3-c", "mnopqr"));


        List<DocItem> docItems3 = new ArrayList<>();
        docItems3.add(new DocItem(DOC, "ch-2.1", "abcd"));
        docItems3.add(new DocItem(DOC, "ch-2.2", "wxyz"));


        itemList = new ArrayList<>();
        itemList.add(new Chapter(CHAPTER, "chapter_1", docItems1, videoItems1, audioItems1));
        itemList.add(new VideoItem(VIDEO, "java-8 tutorial.mp4"));
        itemList.add(new DocItem(DOC, "ch-2", "xyzz"));
        itemList.add(new AudioItem(AUDIO, "megento tutorial.mp3"));

        itemList.add(new Chapter(CHAPTER, "chapter_2", docItems3, videoItems2, audioItems3));
        itemList.add(new VideoItem(VIDEO, "nodeJs tutorial.mp4"));
        itemList.add(new VideoItem(VIDEO, "angular tutorial.mp4"));
        itemList.add(new DocItem(DOC, "ch-4", "abcxyzz"));
        itemList.add(new AudioItem(AUDIO, "react native tutorial.mp3"));
        itemList.add(new AudioItem(AUDIO, "ionic tutorial.mp3"));
        itemList.add(new AudioItem(AUDIO, "xamarin native tutorial.mp3"));

        itemList.add(new Chapter(CHAPTER, "chapter_3", docItems2, videoItems2, audioItems2));
        itemList.add(new VideoItem(VIDEO, "html tutorial.mp4"));
        itemList.add(new VideoItem(VIDEO, "css tutorial.mp4"));
        itemList.add(new VideoItem(VIDEO, "c# tutorial.mp4"));
        itemList.add(new DocItem(DOC, "ch-3", "abcxyzz"));
        itemList.add(new AudioItem(AUDIO, "django tutorial.mp3"));
        itemList.add(new AudioItem(AUDIO, "laravel tutorial.mp3"));

    }
}