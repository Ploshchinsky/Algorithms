package Graph.DominoWords;

import java.util.List;
import java.util.Objects;

public class Node {
    private Character data;
    private List<String> edges;
    private int inputNodes, outputNodes, grade;

    public Node(Character data) {
        this.data = data;
    }

    public Node(Character data, List<String> edges) {
        this.data = data;
        this.edges = edges;
    }

    public Node(Character data, List<String> edges, int inputNodes, int outputNodes, int grade) {
        this.data = data;
        this.edges = edges;
        this.inputNodes = inputNodes;
        this.outputNodes = outputNodes;
        this.grade = grade;
    }

    public Character getData() {
        return data;
    }

    public void setData(Character data) {
        this.data = data;
    }

    public List<String> getEdges() {
        return edges;
    }

    public void setEdges(List<String> edges) {
        this.edges = edges;
    }

    public int getInputNodes() {
        return inputNodes;
    }

    public void setInputNodes(int inputNodes) {
        this.inputNodes = inputNodes;
    }

    public int getOutputNodes() {
        return outputNodes;
    }

    public void setOutputNodes(int outputNodes) {
        this.outputNodes = outputNodes;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return Objects.equals(data, node.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, edges, inputNodes, outputNodes, grade);
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", edges=" + edges +
                ", inputNodes=" + inputNodes +
                ", outputNodes=" + outputNodes +
                ", grade=" + grade +
                '}';
    }
}
