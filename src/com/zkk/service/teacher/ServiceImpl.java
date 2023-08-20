package com.zkk.service.teacher;

import com.zkk.dao.BaseDao;
import com.zkk.dao.teacher.*;
import com.zkk.pojo.Competition;
import com.zkk.pojo.Teacher;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;

public class ServiceImpl implements Service {
    private LoginDao loginDao;
    private ChangePwdDao changePasswordDao;
    private SelectCompetitionDao selectCompetitionDao;
    private TeachCompetitionDao teachCompetitionDao;

    public ServiceImpl() {
        loginDao = new LoginDaoImpl();
        changePasswordDao = new ChangePwdDaoImpl();
        selectCompetitionDao = new SelectCompetitionDaoImpl();
        teachCompetitionDao = new TeachCompetitionDaoImpl();
    }

    @Override
    public Teacher login(String id, String password, HttpSession session) {
        Connection connection = null;
        Teacher teacher = null;

        connection = BaseDao.getConnection();
        try {
            teacher = loginDao.getLoginTeacher(connection, id, password, session);
            if (teacher != null) {
                session.setAttribute("id", teacher.getId());
                session.setAttribute("password", teacher.getPassword());
                session.setAttribute("department", teacher.getDepartment());
                session.setAttribute("teacherName", teacher.getTeacherName());
                session.setAttribute("competitionName", teacher.getCompetitionName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return teacher;
    }

    @Override
    public boolean changePassword(HttpSession session, String oldPassword, String newPassword) {
        Connection connection = null;

        String id = (String) session.getAttribute("id");

        connection = BaseDao.getConnection();
        boolean flag = false;
        try {
            flag = changePasswordDao.changePassword(connection, id, newPassword, oldPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }

    @Override
    public Competition selectCompetition(String teacherId) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        Competition competition = selectCompetitionDao.select(connection, teacherId);
        BaseDao.closeResource(connection, null, null);
        return competition;
    }

    @Override
    public boolean teachCompetition(String teacherId, String competitionId, String competitionName, String date, String describe) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        boolean flag = teachCompetitionDao.teachCompetition(connection, teacherId, competitionId, competitionName, date, describe);
        BaseDao.closeResource(connection, null, null);
        return flag;
    }
}
