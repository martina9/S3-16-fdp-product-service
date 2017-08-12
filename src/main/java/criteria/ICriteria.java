package criteria;

/**
 * Created by Martina on 11/08/2017.
 */
import org.hibernate.Criteria;

/**
 * Hibernate <tt>Criteria</tt>
 *
 * <pre>
 *
 * UserIdSpecification spec = new UserIdSpecification(1);
 *
 * Criteria criteria = session.createCriteria("user");
 * criteria = spec.toCriteria(criteria);
 *
 * List<User> lista = criteria.list();
 * </pre>
 *
 * @see org.hibernate.Criteria
 */
public interface ICriteria {

    /**
     *
     * @return Criteria
     */
    Criteria toCriteria(Criteria criteria);

}