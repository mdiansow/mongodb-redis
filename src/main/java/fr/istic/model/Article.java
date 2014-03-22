/**
 * 
 */
package fr.istic.model;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.google.code.morphia.annotations.Entity;
import com.google.code.morphia.annotations.Id;

/**
 * @author MDian
 * 
 */
@Entity
public class Article {

	@Id
	private ObjectId id;

	private String name;

	private int stars;

	List<Person> buyers = new ArrayList<Person>();

	/**
	 * @return the id
	 */
	public ObjectId getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(ObjectId id) {
		this.id = id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * @param stars
	 *            the stars to set
	 */
	public void setStars(int stars) {
		this.stars = stars;
	}

	/**
	 * @return the buyers
	 */
	public List<Person> getBuyers() {
		return new ArrayList<Person>(this.buyers);
	}

	/**
	 * @param buyers
	 *            the buyers to set
	 */
	public void setBuyers(Person buyers) {
		this.buyers.add(buyers);
	}
}
