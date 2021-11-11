package graphs;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/*
 * A class responsible for reading a graph from a given file
 * and representing it as an adjacency list
 */
public class GraphReader {

	/*
	 * A helper method which finds already existing nodes and creates a relationship
	 * between them
	 */
	private static void AddingNodes(List<Node> nodes, Node node1, Node node2) {
		int index = nodes.indexOf(node1);
		if (nodes.contains(node2)) {
			int index2 = nodes.indexOf(node2);
			node2 = nodes.get(index2);
		} else {
			nodes.add(node2);
		}
		nodes.get(index).getNeighbours().add(node2);
	}

	/*
	 * A method which reads a graph from a file and returns a list with all the
	 * nodes
	 */
	public static Node[] readGraph(Path path) throws IOException {
		List<String> lines = Files.readAllLines(path);

		// String array consisting of all the lines in the file
		String[] linesString = lines.toArray(new String[lines.size()]);

		// The number of nodes in the graph
		int numberOfNodes = Integer.parseInt(linesString[0]);
		// The number of edges in the graph
		int numberOfEdges = Integer.parseInt(linesString[1]);

		List<Node> nodes = new ArrayList<>();
		for (int i = 2; i < linesString.length; i++) {
			String[] line = linesString[i].split(" ");

			// Initialising two nodes with data from the file
			Node node = new Node(Integer.parseInt(line[0]));
			Node node2 = new Node(Integer.parseInt(line[1]));

			// Adding nodes to the list
			if (nodes.contains(node)) {
				AddingNodes(nodes, node, node2);
			} else {
				nodes.add(node);
				AddingNodes(nodes, node, node2);
			}
		}

		return nodes.toArray(new Node[nodes.size()]);
	}

}
