package co.edu.unbosque.miprimerspring.dto;

import java.util.ArrayList;

public class MultipleJokeDTO {

	private int amount;
	private ArrayList<JokeDTO> jokes = new ArrayList<>();
//	private String category;
//	private String type;
//	private String setup;
//	private String delivery;
//	private String joke;
	
	public MultipleJokeDTO() {
		// TODO Auto-generated constructor stub
	}

	public MultipleJokeDTO(int amount, ArrayList<String> jokes, String category, String type, String setup,
			String delivery, String joke) {
		super();
		this.amount = amount;
//		this.jokes = jokes;
//		this.category = category;
//		this.type = type;
//		this.setup = setup;
//		this.delivery = delivery;
//		this.joke = joke;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "MultipleJokeDTO [amount=" + amount + ", jokes=" + jokes + "]";
	}

//	public ArrayList<String> getJokes() {
//		return jokes;
//	}
//
//	public void setJokes(ArrayList<String> jokes) {
//		this.jokes = jokes;
//	}
//
//	public String getCategory() {
//		return category;
//	}
//
//	public void setCategory(String category) {
//		this.category = category;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	public String getSetup() {
//		return setup;
//	}
//
//	public void setSetup(String setup) {
//		this.setup = setup;
//	}
//
//	public String getDelivery() {
//		return delivery;
//	}
//
//	public void setDelivery(String delivery) {
//		this.delivery = delivery;
//	}
//
//	public String getJoke() {
//		return joke;
//	}
//
//	public void setJoke(String joke) {
//		this.joke = joke;
//	}


	
	
	
	
}
