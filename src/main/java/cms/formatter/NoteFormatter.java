package cms.formatter;

import cms.model.NoteType;
import cms.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class NoteFormatter implements Formatter<NoteType> {

private NoteTypeService noteTypeService;

@Autowired
public NoteFormatter(NoteTypeService noteTypeService) {
        this.noteTypeService = noteTypeService;
        }

@Override
public NoteType parse(String text, Locale locale) throws ParseException {
        return noteTypeService.findById(Long.parseLong(text));
        }

@Override
public String print(NoteType object, Locale locale) {
        return "[" + object.getId() + ", " +object.getName() + "]";
        }
        }
