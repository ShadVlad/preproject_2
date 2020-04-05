package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;
//   public void setSessionFactory(SessionFactory sessionFactory) {
//      this.sessionFactory = sessionFactory;
//   }

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("FROM user ");
      return query.getResultList();
      //return null;
   }
   @Override
   public User getUserForCar(String name, String series) {
      User user;

      user = (User) sessionFactory.getCurrentSession().createQuery("FROM user WHERE car.name=:nameParam AND car.series=:seriesParam")
      .setParameter("nameParam", name)
      .setParameter("seriesParam", series).uniqueResult();      //Integer.valueOf(series))
      return user;
   }
}
