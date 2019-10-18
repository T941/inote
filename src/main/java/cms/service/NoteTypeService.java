package cms.service;

import cms.model.NoteType;

public interface NoteTypeService {
    Iterable<NoteType> findAll();

    NoteType findById(Long id);

    void save(NoteType noteType);

    void delete(Long id);
}
