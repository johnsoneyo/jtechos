/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johnson3yo
 */
@Entity
@Table(name = "job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "Job.findByJobId", query = "SELECT j FROM Job j WHERE j.jobId = :jobId"),
    @NamedQuery(name = "Job.findByJobTitle", query = "SELECT j FROM Job j WHERE j.jobTitle = :jobTitle"),
    @NamedQuery(name = "Job.findByJobDesc", query = "SELECT j FROM Job j WHERE j.jobDesc = :jobDesc"),
    @NamedQuery(name = "Job.findByTimeCreated", query = "SELECT j FROM Job j WHERE j.timeCreated = :timeCreated"),
    @NamedQuery(name = "Job.findByApplyBefore", query = "SELECT j FROM Job j WHERE j.applyBefore = :applyBefore")})
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "job_id")
    private String jobId;
    @Size(max = 64)
    @Column(name = "job_title")
    private String jobTitle;
    @Size(max = 512)
    @Column(name = "job_desc")
    private String jobDesc;
    @Basic(optional = false)
    @NotNull
    @Column(name = "time_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date timeCreated;
    @Basic(optional = false)
    @NotNull
    @Column(name = "apply_before")
    @Temporal(TemporalType.TIMESTAMP)
    private Date applyBefore;
    @JoinColumn(name = "skill_set_id", referencedColumnName = "skill_set_id")
    @ManyToOne
    private SkillSet skillSetId;

    public Job() {
    }

    public Job(String jobId) {
        this.jobId = jobId;
    }

    public Job(String jobId, Date timeCreated, Date applyBefore) {
        this.jobId = jobId;
        this.timeCreated = timeCreated;
        this.applyBefore = applyBefore;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public Date getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(Date timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Date getApplyBefore() {
        return applyBefore;
    }

    public void setApplyBefore(Date applyBefore) {
        this.applyBefore = applyBefore;
    }

    public SkillSet getSkillSetId() {
        return skillSetId;
    }

    public void setSkillSetId(SkillSet skillSetId) {
        this.skillSetId = skillSetId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jobId != null ? jobId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.jobId == null && other.jobId != null) || (this.jobId != null && !this.jobId.equals(other.jobId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Job[ jobId=" + jobId + " ]";
    }
    
}
