package hello.bean.mode;
// Generated Oct 22, 2017 4:41:35 PM by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import static javax.persistence.GenerationType.AUTO;
import static javax.persistence.GenerationType.IDENTITY;

/**
 * OntoVersion generated by hbm2java
 */
@Entity
@Table(name="onto_version"
    ,catalog="ontologyeditor"
)
public class OntoVersion  implements java.io.Serializable {

    @Id @GeneratedValue(strategy= GenerationType.AUTO)
     private Integer id;
     private Date timestamp;
     private int mainVersion;
     private int subVersion;
     private int changeVersion;
     private String name;
     private Boolean current;
     private String location;
     private int prior;
     @OneToMany(fetch=FetchType.LAZY, mappedBy="ontoVersion")
     private Set<OntoChange> ontoChanges = new HashSet(0);
     @ManyToMany(fetch=FetchType.LAZY)
     private Set<User> users = new HashSet(0);

    public OntoVersion() {
    }

	
    public OntoVersion(int mainVersion, int subVersion, int changeVersion) {
        this.mainVersion = mainVersion;
        this.subVersion = subVersion;
        this.changeVersion = changeVersion;
    }
    public OntoVersion(int mainVersion, int subVersion, int changeVersion, String name, Boolean current, Set ontoChanges, Set users) {
       this.mainVersion = mainVersion;
       this.subVersion = subVersion;
       this.changeVersion = changeVersion;
       this.name = name;
       this.current = current;
       this.ontoChanges = ontoChanges;
       this.users = users;
    }
   


    
    @Column(name="id", unique=true, nullable=false)
    public Integer getId() {
        return this.id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }

    @Version@Temporal(TemporalType.TIMESTAMP)
    @Column(name="timestamp", length=19)
    public Date getTimestamp() {
        return this.timestamp;
    }
    
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    
    @Column(name="main_version", nullable=false)
    public int getMainVersion() {
        return this.mainVersion;
    }
    
    public void setMainVersion(int mainVersion) {
        this.mainVersion = mainVersion;
    }

    
    @Column(name="sub_version", nullable=false)
    public int getSubVersion() {
        return this.subVersion;
    }
    
    public void setSubVersion(int subVersion) {
        this.subVersion = subVersion;
    }

    
    @Column(name="change_version", nullable=false)
    public int getChangeVersion() {
        return this.changeVersion;
    }
    
    public void setChangeVersion(int changeVersion) {
        this.changeVersion = changeVersion;
    }

    
    @Column(name="name", length=45)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="current")
    public Boolean getCurrent() {
        return this.current;
    }
    
    public void setCurrent(Boolean current) {
        this.current = current;
    }


    @Column(name="location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Set<OntoChange> getOntoChanges() {
        return this.ontoChanges;
    }
    
    public void setOntoChanges(Set<OntoChange> ontoChanges) {
        this.ontoChanges = ontoChanges;
    }


    @JoinTable(name="version_user_assignment", catalog="ontologyeditor", joinColumns = { 
        @JoinColumn(name="onto_version_id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="user_id", nullable=false, updatable=false) })
    public Set<User> getUsers() {
        return this.users;
    }


    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Column(name="prior")
    public int getPrior() {
        return prior;
    }

    public void setPrior(int prior) {
        this.prior = prior;
    }
}


