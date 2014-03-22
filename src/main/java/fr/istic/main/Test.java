package fr.istic.main;

import java.net.UnknownHostException;

import com.google.code.morphia.Datastore;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

import fr.istic.model.Address;
import fr.istic.model.Article;
import fr.istic.model.Person;

public class Test {

	public static void main(String[] args) throws UnknownHostException {

		Morphia morphia = new Morphia();
		Mongo mongo = new Mongo();
		morphia.map(Article.class).map(Person.class).map(Address.class);
		Datastore ds = morphia.createDatastore(mongo, "my_database");

		Person p = new Person();
		p.setName("Tintin");

		Address address = new Address();
		address.setStreet("123 Some street");
		address.setCity("Some city");
		address.setPostCode("123 456");
		address.setCountry("Some country");
		// set address
		p.setAddress(address);
		// Save the POJO
		ds.save(p);

		// L'article
		Article article = new Article();
		article.setName("Le comte de Monte Cristo");
		article.setStars(2);

		for (Person e : ds.find(Person.class)) {
			System.out.println("Person " + e);
			article.setBuyers(e);
		}

		ds.save(article);

		// Affichage des articles contenus dans la Base.
		for (Article a : ds.find(Article.class)) {
			System.out.println("Article NAME : " + a.getName()
					+ " Persons number : " + a.getBuyers().size());
		}

	}

}
