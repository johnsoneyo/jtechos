/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
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
@Table(name = "recruit")
@XmlRootElement

public class Recruit implements Serializable {
    @Lob
    @Column(name = "resume")
    private byte[] resume;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 64)
    @Column(name = "email")
    private String email;
    private static final long serialVersionUID = 1L;
    @Id 
    @GeneratedValue(strategy=GenerationType.AUTO)
    @NotNull
    @Column(name = "recruit_id")
    private Integer recruitId;
    @Size(max = 32)
    @Column(name = "first_name")
    private String firstName;
    @Size(max = 32)
    @Column(name = "last_name")
    private String lastName;
    @Size(max = 8)
    @Column(name = "initials")
    private String initials;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 16)
    @Column(name = "phone")
    private String phone;
    @Size(max = 256)
    @Column(name = "address1")
    private String address1;
    @Size(max = 256)
    @Column(name = "address2")
    private String address2;
    @Size(max = 32)
    @Column(name = "nationality")
    private String nationality;
    @Size(max = 32)
    @Column(name = "state_of_residence")
    private String stateOfResidence;
    @Size(max = 16)
    @Column(name = "marital_status")
    private String maritalStatus;
    @Size(max = 256)
    @Column(name = "goals")
    private String goals;
    @Size(max = 256)
    @Column(name = "weaknesses")
    private String weaknesses;
    @Size(max = 256)
    @Column(name = "what_enhances_your_productivity")
    private String whatEnhancesYourProductivity;
    @Size(max = 256)
    @Column(name = "why_you_left_your_last_job")
    private String whyYouLeftYourLastJob;
    @Size(max = 256)
    @Column(name = "why_should_we_hire_you")
    private String whyShouldWeHireYou;
    @Size(max = 64)
    @Column(name = "how_much_compensation_you_desire")
    private String howMuchCompensationYouDesire;
    @Size(max = 128)
    @Column(name = "what_do_you_know_about_us")
    private String whatDoYouKnowAboutUs;
    @Size(max = 128)
    @Column(name = "languages")
    private String languages;
    @Size(max = 32)
    @Column(name = "employment_mode")
    private String employmentMode;
    @Column(name = "canTravel")
    private Boolean canTravel;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateCreated;
    @Column(name = "dob")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "recruit")
    private RecruitTech recruitTech;

    public Recruit() {
    }

    public Recruit(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public Recruit(Integer recruitId, Date dateCreated) {
        this.recruitId = recruitId;
        this.dateCreated = dateCreated;
    }

    public Integer getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(Integer recruitId) {
        this.recruitId = recruitId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getInitials() {
        return initials;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getStateOfResidence() {
        return stateOfResidence;
    }

    public void setStateOfResidence(String stateOfResidence) {
        this.stateOfResidence = stateOfResidence;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public String getWeaknesses() {
        return weaknesses;
    }

    public void setWeaknesses(String weaknesses) {
        this.weaknesses = weaknesses;
    }

    public String getWhatEnhancesYourProductivity() {
        return whatEnhancesYourProductivity;
    }

    public void setWhatEnhancesYourProductivity(String whatEnhancesYourProductivity) {
        this.whatEnhancesYourProductivity = whatEnhancesYourProductivity;
    }

    public String getWhyYouLeftYourLastJob() {
        return whyYouLeftYourLastJob;
    }

    public void setWhyYouLeftYourLastJob(String whyYouLeftYourLastJob) {
        this.whyYouLeftYourLastJob = whyYouLeftYourLastJob;
    }

    public String getWhyShouldWeHireYou() {
        return whyShouldWeHireYou;
    }

    public void setWhyShouldWeHireYou(String whyShouldWeHireYou) {
        this.whyShouldWeHireYou = whyShouldWeHireYou;
    }

    public String getHowMuchCompensationYouDesire() {
        return howMuchCompensationYouDesire;
    }

    public void setHowMuchCompensationYouDesire(String howMuchCompensationYouDesire) {
        this.howMuchCompensationYouDesire = howMuchCompensationYouDesire;
    }

    public String getWhatDoYouKnowAboutUs() {
        return whatDoYouKnowAboutUs;
    }

    public void setWhatDoYouKnowAboutUs(String whatDoYouKnowAboutUs) {
        this.whatDoYouKnowAboutUs = whatDoYouKnowAboutUs;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getEmploymentMode() {
        return employmentMode;
    }

    public void setEmploymentMode(String employmentMode) {
        this.employmentMode = employmentMode;
    }

    public Boolean getCanTravel() {
        return canTravel;
    }

    public void setCanTravel(Boolean canTravel) {
        this.canTravel = canTravel;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public RecruitTech getRecruitTech() {
        return recruitTech;
    }

    public void setRecruitTech(RecruitTech recruitTech) {
        this.recruitTech = recruitTech;
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
        if (!(object instanceof Recruit)) {
            return false;
        }
        Recruit other = (Recruit) object;
        if ((this.recruitId == null && other.recruitId != null) || (this.recruitId != null && !this.recruitId.equals(other.recruitId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Recruit[ recruitId=" + recruitId + " ]";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getResume() {
        return resume;
    }

    public void setResume(byte[] resume) {
        this.resume = resume;
    }
    
}
