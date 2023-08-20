package com.zkk.service.admin;

import com.zkk.dao.BaseDao;
import com.zkk.dao.admin.*;
import com.zkk.pojo.*;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class ServiceImpl implements Service {
    private AllStudentDao studentDao;
    private AllTeacherDao teacherDao;
    private AllCompetitionDao competitionDao;
    private AddStudentDao addStudentDao;
    private AddTeacherDao addTeacherDao;
    private AddCompetitionDao addCompetitionDao;
    private FindStudentDao findStudentDao;
    private FindTeacherDao findTeacherDao;
    private FindCompetitionDao findCompetitionDao;
    private UpdateStudentDao updateStudentDao;
    private UpdateTeacherDao updateTeacherDao;
    private UpdateCompetitionDao updateCompetitionDao;
    private DeleteStudentDao deleteStudentDao;
    private DeleteTeacherDao deleteTeacherDao;
    private DeleteCompetitionDao deleteCompetitionDao;
    private AddLiuyanDao addLiuyanDao;
    private AddNoticeDao addNoticeDao;
    private  SelectBaomingDao selectBaomingDao;
    private FindAgreeDao findAgreeDao;
    private AgreeComDao agreeComDao;
    private AgreeExitDao agreeExitDao;
    private SelectDao selectDao;
    private AllStuDao allStuDao;

    public ServiceImpl() {
        allStuDao = new AllStuDaoImpl();
        selectDao = new SelectDaoImpl();
        studentDao = new AllStudentDaoImpl();
        teacherDao = new AllTeacherDaoImpl();
        competitionDao = new AllCompetitionDaoImpl();
        addStudentDao = new AddStudentDaoImpl();
        addTeacherDao = new AddTeacherDaoImpl();
        addCompetitionDao = new AddCompetitionDaoImpl();
        findStudentDao = new FindStudentDaoImpl();
        findTeacherDao = new FindTeacherDaoImpl();
        findCompetitionDao = new FindCompetitionDaoImpl();
        updateStudentDao = new UpdateStudentDaoImpl();
        updateTeacherDao = new UpdateTeacherDaoImpl();
        updateCompetitionDao = new UpdateCompetitionDaoImpl();
        deleteStudentDao = new DeleteStudentDaoImpl();
        deleteTeacherDao = new DeleteTeacherDaoImpl();
        deleteCompetitionDao = new DeleteCompetitionDaoImpl();
        addLiuyanDao = new AddLiuyanDaoImpl();
        addNoticeDao = new AddNoticeDaoImpl();
        selectBaomingDao = new SelectBaomingDaoImpl();
        findAgreeDao = new FindAgreeDaoImpl();
        agreeComDao = new AgreeComDaoImpl();
        agreeExitDao = new AgreeExitDaoImpl();
    }

    @Override
    public Admin login(String id, String password) {
        Admin admin = null;

        if ("zkk".equals(id) && "password".equals(password)) {
            admin = new Admin("zkk", "password");
        }

        return admin;
    }

    @Override
    public ArrayList<Student> allStudent() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        ArrayList<Student> student = allStuDao.allStu(connection);

        BaseDao.closeResource(connection, null, null);

        return student;
    }

    @Override
    public ArrayList<Student> select(String id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        ArrayList<Student> student = selectDao.select(connection,id);

        BaseDao.closeResource(connection, null, null);

        return student;
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
    public ArrayList<Agree> selectBaoming() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        ArrayList<Agree> baoming = null;

        baoming = selectBaomingDao.selectBaoll(connection);

        BaseDao.closeResource(connection, null, null);

        return baoming;
    }


    @Override
    public boolean agreeCom(String uid, String cid) throws SQLException{
        Connection connection = null;

        connection = BaseDao.getConnection();

        boolean flag = false;

        flag = agreeComDao.agreeComp(connection, uid,cid);

        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public boolean agreeExit(String uid, String cid) throws SQLException{
        Connection connection = null;

        connection = BaseDao.getConnection();

        boolean flag = false;

        flag = agreeExitDao.agreeExit(connection, uid,cid);

        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public boolean addNotice(String filename, String url) throws SQLException{
        Connection connection = null;

        connection = BaseDao.getConnection();

        boolean flag = false;

        flag = addNoticeDao.addNotice(connection, filename,url);

        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public StringBuffer selectStudent(String competitionName) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        StringBuffer student = null;

        student = studentDao.selectStudent(connection,competitionName);

        BaseDao.closeResource(connection, null, null);

        return student;
    }

    @Override
    public boolean addStudent(String id, String department, int grade, String className, String studentName) throws SQLException {
        Connection connection = null;

        connection = BaseDao.getConnection();

        boolean flag = false;


        flag = addStudentDao.addStudent(connection, id, department, grade, className, studentName);


        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public StringBuffer findStudent(String id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        StringBuffer student = null;

        student = findStudentDao.findStudent(connection, id);

        BaseDao.closeResource(connection, null, null);

        return student;
    }

    @Override
    public boolean updateStudent(String id, String department, int grade, String className, String studentName) throws SQLException {
        Connection connection = null;

        boolean flag = false;

        connection = BaseDao.getConnection();

        flag = updateStudentDao.updateStudentDao(connection, id, department, grade, className, studentName);

        BaseDao.closeResource(connection, null, null);

        return flag;
    }
    @Override
    public boolean addLiuyanDao(String reply,String id) throws SQLException {
        Connection connection = null;

        boolean flag = false;

        connection = BaseDao.getConnection();

        flag = addLiuyanDao.addLiuyanDao(connection, reply,id);

        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public boolean deleteStudent(String id) throws SQLException {
        Connection connection = null;

        connection = BaseDao.getConnection();

        if (deleteStudentDao.deleteStudent(connection, id)) {
            BaseDao.closeResource(connection, null, null);
            return true;
        } else {
            BaseDao.closeResource(connection, null, null);
            return false;
        }
    }

    @Override
    public ArrayList<Teacher> selectTeacher() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        ArrayList<Teacher> teacher = null;

        teacher = teacherDao.selectTeacher(connection);

        BaseDao.closeResource(connection, null, null);

        return teacher;
    }

    @Override
    public boolean addTeacher(String id, String department, String teacherName, String competitionName) throws SQLException {
        Connection connection = null;

        connection = BaseDao.getConnection();

        boolean flag = false;

        flag = addTeacherDao.addTeacher(connection, id, department, teacherName, competitionName);

        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public StringBuffer findTeacher(String id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        StringBuffer teacher = null;

        teacher = findTeacherDao.findTeacher(connection, id);

        BaseDao.closeResource(connection, null, null);

        return teacher;
    }

    @Override
    public boolean updateTeacher(String id, String department, String teacherName, String competitionName) throws SQLException {
        Connection connection = null;

        boolean flag = false;

        connection = BaseDao.getConnection();

        flag = updateTeacherDao.updateTeacher(connection, id, department, teacherName, competitionName);


        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public boolean deleteTeacher(String id) throws SQLException {
        Connection connection = null;

        connection = BaseDao.getConnection();

        if (deleteTeacherDao.deleteTeacher(connection, id)) {
            BaseDao.closeResource(connection, null, null);
            return true;
        } else {
            BaseDao.closeResource(connection, null, null);
            return false;
        }
    }

    @Override
    public ArrayList<Competition> selectCompetition() throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        ArrayList<Competition> competition = null;

        competition = competitionDao.selectCompetition(connection);

        BaseDao.closeResource(connection, null, null);

        return competition;
    }

    @Override
    public boolean addCompetition(String id, String competitionName, Date date, String describe, String teacherId, String teacherName) throws SQLException {
        Connection connection = null;

        boolean flag = false;

        connection = BaseDao.getConnection();


        flag = addCompetitionDao.addCompetition(connection, id, competitionName, date, describe, teacherId, teacherName);


        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public ArrayList<Competition> findCompetition(String id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();

        ArrayList<Competition> competition = null;

        competition = findCompetitionDao.findCompetition(connection, id);

        BaseDao.closeResource(connection, null, null);

        return competition;
    }

    @Override
    public boolean updateCompetition(String id, String competitionName, Date date, String describe, String teacherId, String teacherName) throws SQLException {
        Connection connection = null;

        boolean flag = false;

        connection = BaseDao.getConnection();

        flag = updateCompetitionDao.updateCompetition(connection, id, competitionName, date, describe, teacherId, teacherName);

        BaseDao.closeResource(connection, null, null);

        return flag;
    }

    @Override
    public boolean deleteCompetition(String id) throws SQLException {
        Connection connection = null;
        connection = BaseDao.getConnection();
        boolean flag = false;

        flag = deleteCompetitionDao.deleteCompetition(connection, id);

        BaseDao.closeResource(connection, null, null);

        return flag;
        }
    }

