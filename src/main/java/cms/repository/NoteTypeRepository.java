package cms.repository;

import cms.model.NoteType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteTypeRepository extends PagingAndSortingRepository<NoteType,Long> {
}
