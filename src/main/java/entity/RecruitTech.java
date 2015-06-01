/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author johnson3yo
 */
@Entity
@Table(name = "recruit_tech")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecruitTech.findAll", query = "SELECT r FROM RecruitTech r"),
    @NamedQuery(name = "RecruitTech.findByRecruitId", query = "SELECT r FROM RecruitTech r WHERE r.recruitId = :recruitId"),
    @NamedQuery(name = "RecruitTech.findByYearsOfExperience", query = "SELECT r FROM RecruitTech r WHERE r.yearsOfExperience = :yearsOfExperience"),
    @NamedQuery(name = "RecruitTech.findByRelationalDatabase", query = "SELECT r FROM RecruitTech r WHERE r.relationalDatabase = :relationalDatabase"),
    @NamedQuery(name = "RecruitTech.findBySubversioning", query = "SELECT r FROM RecruitTech r WHERE r.subversioning = :subversioning"),
    @NamedQuery(name = "RecruitTech.findByFrontEndTech", query = "SELECT r FROM RecruitTech r WHERE r.frontEndTech = :frontEndTech"),
    @NamedQuery(name = "RecruitTech.findByFrameWorks", query = "SELECT r FROM RecruitTech r WHERE r.frameWorks = :frameWorks"),
    @NamedQuery(name = "RecruitTech.findByIssueTracking", query = "SELECT r FROM RecruitTech r WHERE r.issueTracking = :issueTracking"),
    @NamedQuery(name = "RecruitTech.findByProficiencyLevel", query = "SELECT r FROM RecruitTech r WHERE r.proficiencyLevel = :proficiencyLevel"),
    @NamedQuery(name = "RecruitTech.findByIsMobiledev", query = "SELECT r FROM RecruitTech r WHERE r.isMobiledev = :isMobiledev"),
    @NamedQuery(name = "RecruitTech.findByBriefSummaryOnPastProj", query = "SELECT r FROM RecruitTech r WHERE r.briefSummaryOnPastProj = :briefSummaryOnPastProj")})
public class RecruitTech implements Serializable {
    @Size(max = 32)
    @Column(name = "years_of_experience")
    private String yearsOfExperience;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    @Column(name = "recruit_id")
    private Integer recruitId;
    @Size(max = 64)
    @Column(name = "relational_database")
    private String relationalDatabase;
    @Size(max = 64)
    @Column(name = "subversioning")
    private String subversioning;
    @Size(max = 64)
    @Column(name = "front_end_tech")
    private String frontEndTech;
    @Size(max = 128)
    @Column(name = "frame_works")
    private String frameWorks;
    @Size(max = 128)
    @Column(name = "issue_tracking")
    private String issueTracking;
    @Size(max = 32)
    @Column(name = "proficiency_level")
    private String proficiencyLevel;
    @Column(name = "isMobile_dev")
    private Boolean isMobiledev;
    @Size(max = 256)
    @Column(name = "brief_summary_on_past_proj")
    private String briefSummaryOnPastProj;
    @JoinColumn(name = "recruit_id", referencedColumnName = "recruit_id", insertable = false, updatable = false)
    @OneToOne(optional = false,cascade=CascadeType.PERSIST)
    private Recruit recruit;

    public RecruitTech() {
    }

    public RecruitTech(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
    }

   

    public String getRelationalDatabase() {
        return relationalDatabase;
    }

    public void setRelationalDatabase(String relationalDatabase) {
        this.relationalDatabase = relationalDatabase;
    }

    public String getSubversioning() {
        return subversioning;
    }

    public void setSubversioning(String subversioning) {
        this.subversioning = subversioning;
    }

    public String getFrontEndTech() {
        return frontEndTech;
    }

    public void setFrontEndTech(String frontEndTech) {
        this.frontEndTech = frontEndTech;
    }

    public String getFrameWorks() {
        return frameWorks;
    }

    public void setFrameWorks(String frameWorks) {
        this.frameWorks = frameWorks;
    }

    public String getIssueTracking() {
        return issueTracking;
    }

    public void setIssueTracking(String issueTracking) {
        this.issueTracking = issueTracking;
    }

    public String getProficiencyLevel() {
        return proficiencyLevel;
    }

    public void setProficiencyLevel(String proficiencyLevel) {
        this.proficiencyLevel = proficiencyLevel;
    }

    public Boolean getIsMobiledev() {
        return isMobiledev;
    }

    public void setIsMobiledev(Boolean isMobiledev) {
        this.isMobiledev = isMobiledev;
    }

    public String getBriefSummaryOnPastProj() {
        return briefSummaryOnPastProj;
    }

    public void setBriefSummaryOnPastProj(String briefSummaryOnPastProj) {
        this.briefSummaryOnPastProj = briefSummaryOnPastProj;
    }

    public Recruit getRecruit() {
        return recruit;
    }

    public void setRecruit(Recruit recruit) {
        this.recruit = recruit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recruitId != null ? recruitId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecruitTech)) {
            return false;
        }
        RecruitTech other = (RecruitTech) object;
        if ((this.recruitId == null && other.recruitId != null) || (this.recruitId != null && !this.recruitId.equals(other.recruitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.RecruitTech[ recruitId=" + recruitId + " ]";
    }

    public String getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(String yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
    
}

