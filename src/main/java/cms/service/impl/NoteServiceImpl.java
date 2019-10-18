package cms.service.impl;

import cms.model.Note;
import cms.repository.NoteRepository;
import cms.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;
    @Override
    public void save(Note note) {
noteRepository.save(note);
    }

    @Override
    public void delete(Long noteId) {
noteRepository.delete(noteId);
    }

    @Override
    public Note findById(long id) {
        return noteRepository.findOne(id);
    }

    @Override
    public Page<Note> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Page<Note> findAllByTitleContaining(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title, pageable);
    }


}
