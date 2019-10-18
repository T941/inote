package cms.service.impl;

import cms.model.NoteType;
import cms.repository.NoteTypeRepository;
import cms.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteTypeServiceImpl implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;

    @Override
    public Iterable<NoteType> findAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public NoteType findById(Long id) {
        return noteTypeRepository.findOne(id);
    }

    @Override
    public void save(NoteType noteType) {
noteTypeRepository.save(noteType);
    }

    @Override
    public void delete(Long id) {
noteTypeRepository.delete(id);
    }
}
