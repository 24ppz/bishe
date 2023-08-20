package com.zkk.service.teacher;

import com.zkk.pojo.Competition;
import com.zkk.pojo.Teacher;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public interface Service {
    public Teacher login(String id, String password, HttpSession session);

    public boolean changePassword(HttpSession session, String oldPassword, String newPassword);

    public Competition selectCompetition(String teacherId) throws SQLException;

    public boolean teachCompetition(String teacherId, String competitionId, String competitionName, String date, String describe) throws SQLException;
}
