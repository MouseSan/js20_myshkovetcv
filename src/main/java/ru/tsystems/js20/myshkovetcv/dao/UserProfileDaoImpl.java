package ru.tsystems.js20.myshkovetcv.dao;

import org.springframework.stereotype.Repository;
import ru.tsystems.js20.myshkovetcv.model.UserProfile;

import javax.persistence.NoResultException;
import java.util.List;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Long, UserProfile> implements UserProfileDao {

    @Override
    public List<UserProfile> findAll() {
        List<UserProfile> userProfileList = getEntityManager()
                .createQuery("SELECT u FROM UserProfile u ORDER BY u.type ASC")
                .getResultList();
        return userProfileList;
    }

    @Override
    public UserProfile findByType(String type) {
        try {
            UserProfile userProfile = (UserProfile) getEntityManager()
                    .createQuery("SELECT u FROM UserProfile u WHERE u.type LIKE :typeName")
                    .setParameter("typeName", type)
                    .getSingleResult();

            return userProfile;
        } catch (NoResultException ex) {
            return null;
        }
    }

    @Override
    public UserProfile findById(Long id) {
        return getByKey(id);
    }
}
