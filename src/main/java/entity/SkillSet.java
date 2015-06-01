/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author johnson3yo
 */
@Entity
@Table(name = "skill_set")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SkillSet.findAll", query = "SELECT s FROM SkillSet s"),
    @NamedQuery(name = "SkillSet.findBySkillSetId", query = "SELECT s FROM SkillSet s WHERE s.skillSetId = :skillSetId"),
    @NamedQuery(name = "SkillSet.findBySkillName", query = "SELECT s FROM SkillSet s WHERE s.skillName = :skillName"),
    @NamedQuery(name = "SkillSet.findBySkillDesc", query = "SELECT s FROM SkillSet s WHERE s.skillDesc = :skillDesc")})
public class SkillSet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "skill_set_id")
    private Integer skillSetId;
    @Size(max = 32)
    @Column(name = "skill_name")
    private String skillName;
    @Size(max = 192)
    @Column(name = "skill_desc")
    private String skillDesc;
    @OneToMany(mappedBy = "skillSetId")
    private List<Job> jobList;

    public SkillSet() {
    }

    public SkillSet(Integer skillSetId) {
        this.skillSetId = skillSetId;
    }

    public Integer getSkillSetId() {
        return skillSetId;
    }

    public void setSkillSetId(Integer skillSetId) {
        this.skillSetId = skillSetId;
    }

    public String getSkillName() {
        return skillName;
    }

    public void setSkillName(String skillName) {
        this.skillName = skillName;
    }

    public String getSkillDesc() {
        return skillDesc;
    }

    public void setSkillDesc(String skillDesc) {
        this.skillDesc = skillDesc;
    }

    @XmlTransient
    public List<Job> getJobList() {
        return jobList;
    }

    public void setJobList(List<Job> jobList) {
        this.jobList = jobList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (skillSetId != null ? skillSetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillSet)) {
            return false;
        }
        SkillSet other = (SkillSet) object;
        if ((this.skillSetId == null && other.skillSetId != null) || (this.skillSetId != null && !this.skillSetId.equals(other.skillSetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return skillSetId.toString();
    }
    
}
