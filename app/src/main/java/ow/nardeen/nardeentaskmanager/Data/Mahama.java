package ow.nardeen.nardeentaskmanager.Data;

public class Mahama
{
    private String key;
    private String title;
    private String subject;
    private int importance;
    private String owner;

    public Mahama()
    {

    }

    public String getKey()
    {
        return this.key;
    }
    public void setKey()
    {
        this.key=key;
    }

    public String getTitle()
    {
        return this.title;
    }
    public void setTitle()
    {
        this.title=title;
    }

    public String getSubject()
    {
        return this.subject;
    }
    public void setSubject()
    {
        this.subject=subject;
    }

    public int getImportance()
    {
        return this.importance;
    }
    public void setImportance()
    {
        this.importance=importance;
    }

    public String getOwner()
    {
        return this.owner;
    }
    public void setOwner()
    {
        this.owner=owner;
    }

    @Override
    public String toString() {
        return "Mahama{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", importance=" + importance +
                ", owner='" + owner + '\'' +
                '}';
    }
}
