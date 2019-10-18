package cms.service;

import cms.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    void save(Note note);

    void delete(Long noteId);
    Note findById(long id);
    Page<Note> findAll(Pageable pageable);
    Page<Note> findAllByTitleContaining(String title, Pageable pageable);

}
