package com.metropolitan.dz07.service.impl

import com.metropolitan.dz07.model.Exam

interface ExamService {
    List<Exam> findAll()
    void update(Exam exam)
}
