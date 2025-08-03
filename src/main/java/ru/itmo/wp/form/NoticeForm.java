package ru.itmo.wp.form;

import ru.itmo.wp.domain.Notice;

import javax.validation.constraints.*;

public class NoticeForm {
    @NotBlank
    @Size(min = Notice.MIN_CONTENT_SIZE, max = Notice.MAX_CONTENT_SIZE,
            message = "Length must be between " + Notice.MIN_CONTENT_SIZE + " and " + Notice.MAX_CONTENT_SIZE)
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
