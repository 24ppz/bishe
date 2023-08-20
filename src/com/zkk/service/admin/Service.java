package com.zkk.service.admin;

import com.zkk.pojo.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Service {
    public Admin login(String id, String password);

    public boolean addNotice(String filename, String url) throws SQLException;

    public StringBuffer selectStudent(String competitionName) throws SQLException;
    public ArrayList<Student> allStudent() throws SQLException;

    public boolean addStudent(String id, String department, int grade, String className, String studentName) throws SQLException;
    public StringBuffer findStudent(String id) throws SQLException;
    public boolean updateStudent(String id, String department, int grade, String className, String studentName) throws SQLException;

    public boolean addLiuyanDao(String reply, String id) throws SQLException;

    public boolean deleteStudent(String id) throws SQLException;

    public ArrayList<Teacher> selectTeacher() throws SQLException;
    public boolean addTeacher(String id, String department, String teacherName, String competitionName) throws SQLException;
    public StringBuffer findTeacher(String id) throws SQLException;
    public boolean updateTeacher(String id, String department, String teacherName, String competitionName) throws SQLException;
    public boolean deleteTeacher(String id) throws SQLException;

    public ArrayList<Competition> selectCompetition() throws SQLException;
    public boolean addCompetition(String id, String competitionName, Date date, String describe, String teacherId, String teacherName) throws SQLException;
    public ArrayList<Competition> findCompetition(String id) throws SQLException;
    public boolean updateCompetition(String id, String competitionName, Date date, String describe, String teacherId, String teacherName) throws SQLException;
    public boolean deleteCompetition(String id) throws SQLException;
    public ArrayList<Agree> selectBaoming() throws SQLException;

    public ArrayList<Student> select(String id) throws SQLException;

    public Agree findAgree(String uid) throws SQLException;
    public boolean agreeCom(String uid,String cid) throws SQLException;
    public boolean agreeExit(String uid, String cid) throws  SQLException;

}
