package com.sss.robixm.dataModel;

public class DocItem extends RecyclerViewItem {

    private String docName;
    private String docAuthor;

    public DocItem(int viewType, String docName, String docAuthor) {
        super(viewType);
        this.docName = docName;
        this.docAuthor = docAuthor;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public String getDocAuthor() {
        return docAuthor;
    }

    public void setDocAuthor(String docAuthor) {
        this.docAuthor = docAuthor;
    }

}
