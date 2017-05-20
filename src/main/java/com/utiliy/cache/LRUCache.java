package com.utiliy.cache;

import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;


public class LRUCache {
	private static final int SIZE = 3;
	private Map<Integer, Student> map = new TreeMap<Integer, Student>();
	MarksComparator marksComparator = new MarksComparator();
	DateComparator dateComparator = new DateComparator();
	
	private PriorityQueue<Student> pqMarks = new PriorityQueue<Student>(SIZE, marksComparator);
	private PriorityQueue<Student> pqDate = new PriorityQueue<Student>(SIZE, dateComparator);
	
	private void insert(Student std) {
		pqDate.offer(std);
		pqMarks.offer(std);
	}

	private int remove() {
		Student leastUsed = pqDate.poll();
		if (leastUsed != null) {
			pqMarks.remove(leastUsed);
			return leastUsed.getId();
		}
		
		return -1;
	}

	private void update(int key,int marks,String subjectEnrolled) {


		for(Student std:pqDate){
			if (std.getId()==key) {
				pqDate.remove(std);
				pqMarks.remove(std);
				break;
			}
		}
		Student mostRecent = new Student(key,marks,subjectEnrolled,new Date());
		insert(mostRecent);
	}

	public Student get(int key) {
		Student std = map.get(key);
		if (std!=null) {
			update(key,std.getMarks(),std.getSubjectEnrolled());
		}
		return std;
	}

	public void put(int key, int marks,String subjectEnrolled) {
		if (map.containsKey(key)) {
			update(key,marks,subjectEnrolled);
		} else {
			if (map.size() >= SIZE) {
				int leastUsedKey = remove();
				map.remove(leastUsedKey);
			}
			Student std = new Student(key,marks,subjectEnrolled,new Date());
			insert(std);
			map.put(key,std);
		}
		
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache();
		cache.put(1, 23, "Maths");
		cache.put(2,25,"Science");
		cache.put(3,21,"Science");
		cache.put(4,27,"Hindi");
		System.out.println("Value is" +cache.get(1));
		
		
		
		
		
	}
}

//To Maintain the LRU Cache order based on Timestamp
class DateComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if (!(o1 instanceof Student) || !(o2 instanceof Student))
			return 0;
		Student std1 = (Student) o1;
		Student std2 = (Student) o2;
		
		return std1.getTimeStamp().compareTo(std2.getTimeStamp());
	}
	
	
}
//To Maintain the Caching strategy based on Sorted Order Of Marks
class MarksComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		if (!(o1 instanceof Student) || !(o2 instanceof Student))
			return 0;
		Student std1 = (Student) o1;
		Student std2 = (Student) o2;
		if (std1.marks > std2.marks) {
			return 1;
		} else if (std1.marks < std2.marks) {
			return -1;
		}
		return 0;
	}

}