package ru.itmo.wp.form.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.itmo.wp.domain.Notice;
import ru.itmo.wp.form.NoticeForm;

@Component
public class NoticeCreationValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return NoticeForm.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        NoticeForm form = (NoticeForm) target;

        String content = form.getContent();

        if (content == null || content.trim().isEmpty()) {
            errors.rejectValue("content", "content.empty", "Notice cannot be empty.");
            return;
        }

        int length = content.length();
        if (length < Notice.MIN_CONTENT_SIZE || length > Notice.MAX_CONTENT_SIZE) {
            errors.rejectValue("content", "content.invalid-length", "Length should be "
                    + Notice.MIN_CONTENT_SIZE + " - " + Notice.MAX_CONTENT_SIZE + " symbols");
        }
    }
}
