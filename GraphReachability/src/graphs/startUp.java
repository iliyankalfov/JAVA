package graphs;

import java.nio.file.Path;
import java.nio.file.Paths;

import graphExploration.GraphExplorer;

public class startUp {
	public static void main(String[] args) {

		Path readingPath = Paths.get("C:\\Users\\kalfo\\Downloads\\Lab 6 files-20211102\\IO_Files_Lab06\\graph1.txt");
		Path writingPath = Paths.get("C:\\Users\\kalfo\\Downloads\\Lab 6 files-20211102\\result1.txt");

		try {
			Node[] nodes = GraphReader.readGraph(readingPath);
			GraphExplorer.writeTree(nodes, writingPath);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
