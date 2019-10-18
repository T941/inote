package cms.model;


import javax.persistence.*;

@Entity
@Table(name="Note")
public class Note {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;
    private String title;
    private String content;
    @ManyToOne
    @JoinColumn(name = "noteType_id")
    private NoteType noteType;
    public Note() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Note(long id, String title, String content,NoteType noteType) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.noteType=noteType;
    }

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
