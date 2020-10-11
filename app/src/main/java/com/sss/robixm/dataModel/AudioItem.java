package com.sss.robixm.dataModel;

public class AudioItem extends RecyclerViewItem {
    private String fileName;

    public AudioItem(int viewType, String fileName) {
        super(viewType);
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
