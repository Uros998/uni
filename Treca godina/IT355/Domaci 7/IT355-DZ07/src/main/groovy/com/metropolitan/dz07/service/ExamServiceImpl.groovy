package com.metropolitan.dz07.service

import com.metropolitan.dz07.model.Exam
import com.metropolitan.dz07.service.impl.ExamService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

import javax.swing.tree.RowMapper

@Repository
class ExamServiceImpl implements ExamService {
    @Autowired
    JdbcTemplate jdbc

    @Override
    List<Exam> findAll() {
        jdbc.query("select * from exams", {
            rs, row ->
                new Exam(id:  rs.getLong(1),
                        name: rs.getString(2),
                        picked: rs.getString(3))
        } as RowMapper)
    }

    @Override
    void update(Exam exam) {
            jdbc.update("update exams " +
                    "set picked = ? where id = ?",
            book.picked,
            book.id)
    }
}
