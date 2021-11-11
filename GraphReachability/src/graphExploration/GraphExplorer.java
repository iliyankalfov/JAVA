package graphExploration;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import graphs.Node;

/*
 * Creating a file with the reachability tree of the first node
 */
public class GraphExplorer {

	public static void writeTree(Node[] nodes, Path path) throws IOException {
		// The first node
		Node reachabilityNode = nodes[0];

		Files.createFile(path);
		PrintWriter pw = new PrintWriter(Files.newBufferedWriter(path));

		// Algorithm for creating a reachability tree
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(reachabilityNode);

		Set<Node> nodeSet = new HashSet<Node>();
		nodeSet.add(reachabilityNode);

		List<String> edges = new ArrayList<>();

		while (!(queue.isEmpty())) {
			Node firstNode = queue.remove();

			for (Node n : firstNode.getNeighbours()) {
				if (!(nodeSet.contains(n))) {
					edges.add(firstNode + " " + n);
					nodeSet.add(n);
					queue.add(n);
				}
			}
		}

		// Writing the required text onto the file
		pw.println("Reachability Tree from Node " + reachabilityNode.getId() + ":");
		for (String s : edges) {
			pw.println(s);
		}
		pw.close();
	}

}
