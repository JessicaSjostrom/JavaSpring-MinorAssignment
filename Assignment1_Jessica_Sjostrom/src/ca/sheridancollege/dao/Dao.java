package ca.sheridancollege.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import ca.sheridancollege.bean.Vote;
import ca.sheridancollege.bean.Voter;

public class Dao {

	SessionFactory sessionFactory = new Configuration()
			.configure("ca/sheridancollege/config/hibernate.cfg.xml")
			.buildSessionFactory();
	
	public void addDummyRecords() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		// Registered but not yet voted
		for (int i=0; i<200; i++) {
			Random r = new Random();
			int low = 18;
			int high = 75;
			int age = r.nextInt(high-low) + low;
			int age2 = 1925 + age;
			String age3 = Integer.toString(age2) + 0615;
			int age4 = Integer.parseInt(age3);
		Voter v = new Voter(100000000+i, "First"+i, "Last"+i, age4, "" + i + " Trafalgar Rd", "NO");
		session.save(v);
		}
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void addDummyVotes() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		List<String> partyList = new ArrayList<String>();
		partyList.add("L");
		partyList.add("C");
		partyList.add("N");
		partyList.add("G");
		partyList.add("B");
		
		for (int i = 0; i < 150; i++) {
			Random random = new Random();
			int index = random.nextInt(partyList.size());
			String s = partyList.get(index);
			
			Vote v = new Vote(s);
			addVote(100000000+i, s);
			getVoteList().add(v);			
		}
		
		session.getTransaction().commit();
		session.close();
	}	
	
	public void addVoterObject(Voter v) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(v);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void addVote(int vsin, String voteChoice) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Voter where sin=:voterSin");
		query.setParameter("voterSin", vsin);
		
		Voter v = (Voter)query.getSingleResult();
		
		Vote vote = new Vote(voteChoice);
		
		v.setVote(vote);
		v.setSin(vsin);
		v.setVoted("YES");	

		session.save(v);	
		session.getTransaction().commit();
		session.close();
	}
	
	public List<Voter> getVoterList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Voter");
		List<Voter> voterList = (List<Voter>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return voterList;
	}
	
	public List<Vote> getVoteList() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from Vote");
		List<Vote> voteList = (List<Vote>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return voteList;
	}

	public boolean validateAge(String bday) {
		String s1 = bday.substring(0,4);
		String s2 = bday.substring(4,6);
		String s3 = bday.substring(6);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		
		int i = 2019 - Integer.parseInt(s1) ;
		int i2 = 3 - Integer.parseInt(s2);
		int i3 = 11 - Integer.parseInt(s3);
		
		System.out.println(i);
		System.out.println(i2);
		System.out.println(i3);
		if (i < 18) {
			return false;
		} else if (i == 18 && i2 < 0){
			return false;
		} else if (i == 18 && i2 <= 0 && i3 < 0) {
			return false;
		} else {
			return true;
		}
	}
	
	public boolean uniqueSIN(int vsin) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Voter where sin=:voterSin");
		query.setParameter("voterSin", vsin);
		List<Voter> voterList = (List<Voter>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();	
		
		if (voterList.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean hasVoted(int vsin) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Voter where sin=:voterSin");
		query.setParameter("voterSin", vsin);
		
		Voter v = (Voter)query.getSingleResult();
		
		session.getTransaction().commit();
		session.close();	
		
		if (v.getVoted().equals("YES")) {
			return true;
		} else {
			return false;
		}

	}

	public int countL() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Vote where voteChoice=:choice");
		query.setParameter("choice", "L");
		List<Vote> voteList = (List<Vote>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();	
		
		return voteList.size();
	}
	
	public int countC() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Vote where voteChoice=:choice");
		query.setParameter("choice", "C");
		List<Vote> voteList = (List<Vote>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();	
		
		return voteList.size();
	}

	public int countN() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Vote where voteChoice=:choice");
		query.setParameter("choice", "N");
		List<Vote> voteList = (List<Vote>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();	
		
		return voteList.size();
	}
	
	public int countG() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Vote where voteChoice=:choice");
		query.setParameter("choice", "G");
		List<Vote> voteList = (List<Vote>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();	
		
		return voteList.size();
	}

	public int countB() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Vote where voteChoice=:choice");
		query.setParameter("choice", "B");
		List<Vote> voteList = (List<Vote>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();	
		
		return voteList.size();
	}
	
	public double percentVoted() {
		double a = getVoteList().size();
		double b = getVoterList().size();
		double d = a/b*100;
		return d;
	}
	
	public int getAge18() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Voter where birthday>=19850310 and birthday<=20010310 and voted=:vote");
		query.setParameter("vote", "YES");
		List<Voter> voterList = (List<Voter>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return voterList.size();
	} 
	
	public int getAge30() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Voter where birthday>=19740310 and birthday<=19850311 and voted=:vote");
		query.setParameter("vote", "YES");
		List<Voter> voterList = (List<Voter>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return voterList.size();
	} 
	
	public int getAge45() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Voter where birthday>=19590310 and birthday <=19740311 and voted=:vote");
		query.setParameter("vote", "YES");
		List<Voter> voterList = (List<Voter>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return voterList.size();
	} 
	
	public int getAge60() {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("from Voter where birthday<=19590310  and voted=:vote");
		query.setParameter("vote", "YES");
		List<Voter> voterList = (List<Voter>)query.getResultList();
		
		session.getTransaction().commit();
		session.close();
		
		return voterList.size();
	} 
}
