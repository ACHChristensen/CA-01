
package entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;


@Entity
@NamedQuery(name = "GroupMember.deleteAllRows", query = "DELETE from GroupMember")
public class GroupMember implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private String studentID;
    private String favoriteShow;
    

    public Integer getId() {
        return id;
    }

    public GroupMember() {
    }

    public GroupMember(String name, String studentID, String favoriteShow) {
        this.name = name;
        this.studentID = studentID;
        this.favoriteShow = favoriteShow;
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

    
    
}
