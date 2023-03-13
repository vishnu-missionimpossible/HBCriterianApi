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

public class TestApp {

	public static void main(String[] args) {
		Session session = null;
		
		session = HibernateUtil.getSession();
		
			try {
				
				Criteria criteria = session.createCriteria(Project.class);
				
				PropertyProjection p1 = Projections.property("teamSize");
				PropertyProjection p2 = Projections.property("location");
				PropertyProjection p3 = Projections.property("company");
				
				ProjectionList plist = Projections.projectionList();
				plist.add(p1);
				plist.add(p2);
				plist.add(p3);
				
				criteria.setProjection(plist);
				
				Criterion cond1=Restrictions.ge("teamSize", 10);
				Criterion cond2=Restrictions.le("teamSize", 20);
				
				criteria.add(cond1);
				criteria.add(cond2);
				
				Order order1=Order.desc("location");
				Order order2=Order.asc("projName");
				
				criteria.addOrder(order1);
				criteria.addOrder(order2);
				
				
				List<Object[]> list =criteria.list();
				System.out.println("teamsize\tloaction\tcompany");
				list.forEach(row->{
					for(Object obj:row)
						System.out.print(obj+"\t\t");
					System.out.println();
				});
				
			}catch (Exception e) {
				// TODO: handle exception
			}finally {
				
				HibernateUtil.closeSession(session);
			}

	}

}
