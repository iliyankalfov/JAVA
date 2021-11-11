package graphs;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*
 * A class representing a sing node and its neighbours
 */
public class Node {

	// ID of the node
	private int ID;

	// A list of its neighbours
	private List<Node> neighbours;

	/*
	 * Initialising a node with a given ID
	 */
	public Node(int id) {
		this.ID = id;
		this.neighbours = new ArrayList<>();
	}

	/*
	 * Adding neighbours to the list
	 */
	public void addNeighbour(Node node) {
		this.neighbours.add(node);
	}

	/*
	 * Getting the neighbours of the node
	 */
	public List<Node> getNeighbours() {
		return this.neighbours;
	}

	/*
	 * Getting the ID of the node
	 */
	public int getId() {
		return this.ID;
	}

	/*
	 * A string representation of the node
	 */
	public String toString() {
		return String.valueOf(this.ID);
	}

	/*
	 * Overriding equals() to compare two nodes according to their ID
	 */
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof Node) {
			Node n = (Node) obj;
			return Objects.equals(n.ID, this.ID);
		}
		return false;
	}

	/*
	 * Overriding hashCode() because equals() has been overridden
	 */
	public int hashCode() {
		return Objects.hash(ID);
	}

}
