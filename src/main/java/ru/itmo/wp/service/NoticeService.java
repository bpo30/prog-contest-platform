package ru.itmo.wp.service;

import org.springframework.stereotype.Service;
import ru.itmo.wp.domain.Notice;

import ru.itmo.wp.form.NoticeForm;
import ru.itmo.wp.repository.NoticeRepository;

import java.util.List;

@Service
public class NoticeService {
    private final NoticeRepository noticeRepository;

    public NoticeService(NoticeRepository noticeRepository) {
        this.noticeRepository = noticeRepository;
    }

    public Notice findById(long id) {
        return noticeRepository.findById(id);
    }

    public List<Notice> findAll() {
        return noticeRepository.findAllByOrderByCreationTimeDesc();
    }

    public Notice add(NoticeForm NoticeForm) {
        Notice notice = new Notice();
        notice.setContent(NoticeForm.getContent());
        noticeRepository.save(notice);
        return notice;
    }
}
