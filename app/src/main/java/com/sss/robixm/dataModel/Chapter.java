package com.sss.robixm.dataModel;

import java.util.List;

public class Chapter extends RecyclerViewItem {

    private String chapterName;
    private List<DocItem> docItemList;
    private List<VideoItem>videoItems;
    private List<AudioItem>audioItems;
    private boolean expanded;

    public Chapter(int viewType, String chapterName, List<DocItem> docItemList, List<VideoItem> videoItems, List<AudioItem> audioItems) {
        super(viewType);
        this.chapterName = chapterName;
        this.docItemList = docItemList;
        this.videoItems = videoItems;
        this.audioItems = audioItems;
        this.expanded=false;
    }

    public Chapter(int viewType) {
        super(viewType);
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public List<DocItem> getDocItemList() {
        return docItemList;
    }

    public void setDocItemList(List<DocItem> docItemList) {
        this.docItemList = docItemList;
    }

    public List<VideoItem> getVideoItems() {
        return videoItems;
    }

    public void setVideoItems(List<VideoItem> videoItems) {
        this.videoItems = videoItems;
    }

    public List<AudioItem> getAudioItems() {
        return audioItems;
    }

    public void setAudioItems(List<AudioItem> audioItems) {
        this.audioItems = audioItems;
    }

    public boolean isExpanded() {
        return expanded;
    }

    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
    }
}
