/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bl;

import entity.ContactUs;
import entity.Job;
import entity.Recruit;
import entity.RecruitTech;
import entity.SkillSet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.component.UIComponent;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import qa.Question;

/**
 *
 * @author johnson3yo
 */
@Stateless
public class GeneralEJB {

    @PersistenceContext
    EntityManager em;
    private UIComponent component;
    private String email;
    
    private Map<String,SkillSet>skillSet;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String check() {
        System.out.println("email is " + email);
        return "";
    }

    public void registerRecruit(Recruit rc, RecruitTech rct, Part file) throws JTechosException, IOException, FileNotFoundException {

        InputStream is = file.getInputStream();
        String name = file.getSubmittedFileName();


        if (!name.endsWith(".docx")) {

            throw new JTechosException("Please upload a Docx format");
        }
        if (file.getSize() > Long.parseLong("200295")) {
            throw new JTechosException("File shouldnt be above 100kb ");
        } else {

            byte[] value = IOUtils.toByteArray(is);

            rc.setRecruitTech(rct);
            rc.setResume(value);

            em.persist(rc);

            rct.setRecruitId(rc.getRecruitId());
            em.merge(rct);

         //  sendEmail(rc.getEmail());

        }

    }

    public void sendMessage(ContactUs cu) {

        em.persist(cu);

    }

    public List getJobList() {
        return em.createNativeQuery("select * from job j where j.apply_before > CURDATE()", Job.class).getResultList();

    }

    public void createRecruit(Recruit recruit) {

        em.persist(recruit);
    }

    public void verifyAnswer(Question question, String answer) throws JTechosException {
        if (!question.getAnswer().equalsIgnoreCase(answer)) {
            throw new JTechosException("Wrong answer...");
        }

    }

    private void sendEmail(String email) throws FileNotFoundException, IOException {


        final Properties props = new Properties();
        InputStream is = getClass().getResourceAsStream("/email_config.properties");
        props.load(is);



        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                return new javax.mail.PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
            }
        });

        try {

            Message message = new MimeMessage(session);
            message.setSentDate(new java.util.Date());

            message.setFrom(new InternetAddress("johnsoneyo@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(email));
            message.setSubject("JTechOS :Your application was received  ");

            message.setText("Your application was received");

            Transport.send(message);

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public byte[] viewResume(int parseInt) {
        Recruit find = em.find(Recruit.class, parseInt);
        return find.getResume();
    }

    public List getTechList() {
        
    return em.createQuery("select s from SkillSet s",SkillSet.class).getResultList();
    }
    
    @PostConstruct
    public void initializeData(){
        skillSet = new HashMap<String,SkillSet>();
        List<SkillSet> techList = this.getTechList();
        
         for (SkillSet et : techList) {
            skillSet.put(et.getSkillSetId().toString(), et);
        }
    }

    public SkillSet getSkillSet(String value) {
       return skillSet.get(value);
    }
    
}
