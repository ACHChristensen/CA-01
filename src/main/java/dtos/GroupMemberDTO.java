/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.GroupMember;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tha
 */
public class GroupMemberDTO {

    private Integer id;
    private String name;
    private String studentID;
    private String favoriteShow;

    public GroupMemberDTO(String name, String studentID, String favoriteShow) {
        this.name = name;
        this.studentID = studentID;
        this.favoriteShow = favoriteShow;
    }

    public static List<GroupMemberDTO> getDtos(List<GroupMember> gms) {
        List<GroupMemberDTO> gmdtos = new ArrayList();
        gms.forEach(gm -> gmdtos.add(new GroupMemberDTO(gm)));
        return gmdtos;
    }

    public GroupMemberDTO(GroupMember gm) {
        this.id = gm.getId();
        this.name = gm.getName();
        this.studentID = gm.getStudentID();
        this.favoriteShow = gm.getFavoriteShow();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getFavoriteShow() {
        return favoriteShow;
    }

    public void setFavoriteShow(String favoriteShow) {
        this.favoriteShow = favoriteShow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupMemberDTO{id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", studentID=").append(studentID);
        sb.append(", favoriteShow=").append(favoriteShow);
        sb.append('}');
        return sb.toString();
    }
}
