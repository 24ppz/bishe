package com.zkk.service.student;

import com.zkk.pojo.Agree;
import com.zkk.pojo.Competition;
import com.zkk.pojo.LyTable;
import com.zkk.pojo.Student;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Service {
    public Student login(String id, String password, HttpSession session);

    public boolean AgreeExit(String uid, String cid) throws SQLException;

    public boolean liuyanE(String studentName, String title, String content) throws SQLException;

    public boolean changePwd(HttpSession session, String oldPassword, String newPassword);

    public ArrayList<Competition> selectCompetition();

    public String joinCompetition(String studentId, String competitionId) throws SQLException;

    public ArrayList<LyTable> liuyanLL();
    public boolean AgreeComadd(String uid,String cid) throws SQLException;
    public Agree findAgree(String uid) throws SQLException;
    public Competition findCompetition(String competitionId) throws  SQLException;
}
