package com.zkk.service.student;

import com.zkk.dao.BaseDao;
import com.zkk.dao.student.FindCompetitionDaoImpl;
import com.zkk.dao.student.*;
import com.zkk.pojo.Agree;
import com.zkk.pojo.Competition;
import com.zkk.pojo.LyTable;
import com.zkk.pojo.Student;

import javax.servlet.http.HttpSession;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceImpl implements Service {
    private LoginDao loginDao;
    private ChangePwdDao changePwdDao;
    private SelectCompetitionDao competitionDao;
    private JoinCompetitionDao joinCompetitionDao;
    private ExitCompetitionDao exitCompetitionDao;
    private LiuYaneDao liuYaneDao;
    private LiuYanllDao liuYanllDao;
    private AgreeComaddDao agreeComaddDao;
    private AgreeExitDao agreeExitDao;
    private FindAgreeDao findAgreeDao;
    private FindCompetitionDao findCompetitionDao;


    public ServiceImpl() {
        loginDao = new LoginDaoImpl();
        changePwdDao = new ChangePwdDaoImpl();
        competitionDao = new SelectCompetitionDaoImpl();
        joinCompetitionDao = new JoinCompetitionDaoImpl();
        exitCompetitionDao = new ExitCompetitionDaoImpl();
        liuYaneDao = new LiuYaneDaoImpl();
        liuYanllDao = new LiuYanllDaoImpl();
        agreeComaddDao = new AgreeComDaoImpl();
        findAgreeDao = new FindAgreeDaoImpl();
        agreeExitDao = new AgreeExitDaoImpl();
        findCompetitionDao = new FindCompetitionDaoImpl();
    }

    @Override
    public Student login(String id, String password, HttpSession session) {
        Connection connection = null;
        Student student = null;

        connection = BaseDao.getConnection();
        try {
            student = loginDao.getLoginStudent(connection, id, password, session);
            if (student != null) {
                session.setAttribute("id", student.getId());
                session.setAttribute("password", student.getPassword());
                session.setAttribute("department", student.getDepartment());
                session.setAttribute("grade", student.getGrade());
                session.setAttribute("className", student.getClassName());
                session.setAttribute("studentName", student.getStudentName());
                session.setAttribute("competitionName", student.getCompetitionName());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return student;
    }

    @Override
    public Competition findCompetition(String id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        Competition agr = findCompetitionDao.findCompetition(connection,id);

        BaseDao.closeResource(connection, null, null);

        return agr;
    }

    @Override
    public Agree findAgree(String uid) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        Agree agr = findAgreeDao.findAgree(connection,uid);

        BaseDao.closeResource(connection, null, null);

        return agr;
    }

    @Override
    public boolean AgreeComadd(String uid, String cid) throws SQLException {
        Connection connection = null;

        connection = BaseDao.getConnection();

        boolean AgreeCom = false;

        AgreeCom = agreeComaddDao.agreeadd(connection, uid, cid);

        BaseDao.closeResource(connection, null, null);

        return AgreeCom;
    }

    @Override
    public boolean AgreeExit(String uid, String cid) throws SQLException {
        Connection connection = null;

        connection = BaseDao.getConnection();

        boolean agreeExit = false;

        agreeExit = agreeExitDao.agreeExit(connection, uid, cid);

        BaseDao.closeResource(connection, null, null);

        return agreeExit;
    }

    @Override
    public boolean liuyanE(String studentName, String title, String content) throws SQLException {
        Connection connection = null;

        connection = BaseDao.getConnection();

        boolean flag = false;

        flag = liuYaneDao.liuyanDao(connection, studentName, title, content);

        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    ;

    @Override
    public ArrayList<LyTable> liuyanLL() {
        Connection connection = null;

        connection = BaseDao.getConnection();

        ArrayList<LyTable> lytable = null;

        try {
            lytable = liuYanllDao.liuYanll(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        BaseDao.closeResource(connection, null, null);

        return lytable;
    }

    @Override
    public boolean changePwd(HttpSession session, String oldPassword, String newPassword) {
        Connection connection = null;

        String id = (String) session.getAttribute("id");

        connection = BaseDao.getConnection();

        boolean flag = false;
        try {
            flag = changePwdDao.changePassword(connection, id, newPassword, oldPassword);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            BaseDao.closeResource(connection, null, null);
        }

        return flag;
    }

    @Override
    public ArrayList<Competition> selectCompetition() {
        Connection connection = null;

        connection = BaseDao.getConnection();

        ArrayList<Competition> competition=null;
        try {
            competition = competitionDao.selectCompetition(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        BaseDao.closeResource(connection, null, null);

        return competition;
    }

    @Override
    public String joinCompetition(String studentId, String competitionId) throws SQLException {
        Connection connection = null;

        connection = BaseDao.getConnection();

        String competitionName = null;

        if (joinCompetitionDao.hasCompetition(connection, competitionId) && !joinCompetitionDao.isJoin(connection, studentId)) {
            competitionName = joinCompetitionDao.joinCompetition(connection, studentId, competitionId);
        }

        BaseDao.closeResource(connection, null, null);
        return competitionName;
    }

//    @Override
//    public boolean exitCompetition(String uid, String cid) throws SQLException {
//        Connection connection = null;
//
//        connection = BaseDao.getConnection();
//
//        boolean exi = false;
//
//        exi = exitCompetitionDao.exit(connection, uid, cid);
//
//        BaseDao.closeResource(connection, null, null);
//
//        return exi;
//    }

}
