package in.ineuron.main;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.PropertyProjection;
import org.hibernate.criterion.Restrictions;

import in.ineuron.model.Project;
import in.ineuron.util.HibernateUtil;

public class Pagination {

	public static void main(String[] args) {
		Session session = null;
		
		session = HibernateUtil.getSession();
		
			try {
				
				Criteria criteria = session.createCriteria(Project.class);
				criteria.setMaxResults(3);
				criteria.setFirstResult(1);
				
				List<Project> list = criteria.list();
				list.forEach(System.out::println);
				
				
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				
				HibernateUtil.closeSession(session);
			}

	}

}
