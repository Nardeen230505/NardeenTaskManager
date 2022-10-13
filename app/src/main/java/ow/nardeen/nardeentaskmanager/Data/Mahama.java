package ow.nardeen.nardeentaskmanager.Data;
// فئة تصف مهمة بادارة المهمات
public class Mahama
{
    private String key; // رقم مُميِّز للمهمة يتم اتاجه من قِبل الخادم - firebase
    private String title;
    private String subject;
    private int important;
    private String owner; // رقم مُميِّز للمستعمل

    public Mahama()
    {

    }

    public String getKey()
    {
        return this.key;
    }
    public void setKey(String key)
    {
        this.key=key;
    }

    public String getTitle()
    {
        return this.title;
    }
    public void setTitle(String title)
    {
        this.title=title;
    }

    public String getSubject()
    {
        return this.subject;
    }
    public void setSubject(String subject)
    {
        this.subject=subject;
    }

    public int getImportance(int sbImportant)
    {
        return this.important;
    }
    public void setImportance(int important)
    {
        this.important=important;
    }

    public String getOwner()
    {
        return this.owner;
    }
    public void setOwner(String owner)
    {
        this.owner=owner;
    }

    @Override
    public String toString() {
        return "Mahama{" +
                "key='" + key + '\'' +
                ", title='" + title + '\'' +
                ", subject='" + subject + '\'' +
                ", importance=" + important +
                ", owner='" + owner + '\'' +
                '}';
    }
}
