package Graph.DominoWords;

import java.util.*;
import java.util.stream.Collectors;

public class EulerPath {
    private List<Node> nodeList;
    private EulerType type;

    public EulerPath(String[] sequence) {
        nodeList = getNodesFromSequence(sequence);
        this.type = getEulerType();
    }

    private List<Node> getNodesFromSequence(String[] sequence) {
        List<Node> list = new ArrayList<>();
        for (String word : sequence) {
            char first = getFirstLetter(word);
            char last = getLastLetter(word);

            List<String> outputs = Arrays.stream(sequence) // find all OUTGOING edges
                    .filter(s -> getFirstLetter(s) == first)
                    .toList();
            int outputCount = outputs.size(); // output edges count
            List<String> inputs = Arrays.stream(sequence) // find all INGOING edges
                    .filter(s -> getLastLetter(s) == first)
                    .toList();
            int inputCount = inputs.size(); // input edges count
            int grade = outputCount + inputCount; // grade count
            Node node = new Node( // create a node and add it to the list if it is not already there.
                    first,
                    outputs,
                    inputCount,
                    outputCount,
                    grade);
            list.remove(node);
            list.add(node);
            if (listContainWordsOnLetter(last)) {
                continue;
            }
            node = new Node(last);
            node.setEdges(new ArrayList<>());
            if (!list.contains(node)) {
                list.add(node);
            }
        }
        return list;
    }

    private boolean listContainWordsOnLetter(char letter) {
        if (nodeList == null) {
            return false;
        }
        Optional<Node> optional = nodeList.stream().filter(node -> node.getData() == letter).findAny();
        return optional.isPresent();
    }

    private char getFirstLetter(String word) {
        return word.toUpperCase().charAt(0);
    }

    private char getLastLetter(String word) {
        return word.toUpperCase().charAt(word.length() - 1);
    }

    public String[] getEulerPath() {
        List<String> result = new ArrayList<>();
        List<Node> path = new ArrayList<>();

        Stack<Node> nodeStack = new Stack<>();
        Stack<String> edgeStack = new Stack<>();
        Node startNode = nodeList.stream()
                .filter(node -> node.getOutputNodes() > node.getInputNodes())
                .findAny().orElse(nodeList.getFirst());
        nodeStack.push(startNode);
        while (!nodeStack.empty()) {
            List<String> currentEdges = new ArrayList<>(startNode.getEdges());
            if (!currentEdges.isEmpty()) {
                String currentString = currentEdges.removeFirst();
                edgeStack.push(currentString);
                startNode.setEdges(currentEdges);
                char currentNode = getLastLetter(currentString);
                startNode = nodeList.stream()
                        .filter(node -> node.getData() == currentNode)
                        .findFirst()
                        .get();
                nodeStack.push(startNode);
            }
            path.add(nodeStack.pop());
            if (!edgeStack.empty()) result.add(edgeStack.pop());
        }
        return result.toArray(String[]::new);
    }


    private EulerType getEulerType() {
        EulerType type = null;
        int nodeCount = nodeList.size();
        int symmetricalNodes = (int) nodeList.stream()
                .filter(node -> node.getInputNodes() == node.getOutputNodes()).count();
        if (nodeCount == symmetricalNodes) {
            type = EulerType.CYCLE;
        }

        int odds = 0;
        int evens = 0;
        for (Node node : nodeList) {
            if (node.getGrade() % 2 == 0) {
                evens++;
            } else {
                int difference = node.getOutputNodes() - node.getInputNodes();
                if (Math.abs(difference) == 1) {
                    odds++;
                }
            }
        }
        if (odds + evens == nodeCount && odds == 2) {
            type = EulerType.PATH;
        }
        return type;
    }

    public String getNodes() {
        StringBuilder builder = new StringBuilder();
        nodeList.forEach(builder::append);
        return builder.toString();
    }

    public EulerType getType() {
        return type;
    }
}
