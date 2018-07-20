package io.pheonixlabs;

import io.pheonixlabs.config.HibernateUtil;
import io.pheonixlabs.entity.Employee;
import org.hibernate.Session;

import java.util.Date;

public class HibernateMain {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Pankaj");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());

        //Get Session
        Session session = HibernateUtil.getSessionJavaConfigFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID=" + emp.getId());

        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionJavaConfigFactory().close();
    }

}
