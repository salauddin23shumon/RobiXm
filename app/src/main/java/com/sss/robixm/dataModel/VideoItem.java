package com.sss.robixm.dataModel;

public class VideoItem extends RecyclerViewItem {

    private String videoFileName;

    public VideoItem(int viewType, String videoFileName) {
        super(viewType);
        this.videoFileName = videoFileName;
    }

    public String getVideoFileName() {
        return videoFileName;
    }

    public void setVideoFileName(String videoFileName) {
        this.videoFileName = videoFileName;
    }
}
