
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // User input
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text for Huffman Tree:");
        String text = scanner.nextLine();

        // Frequency map
        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : text.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        // Build Huffman Tree
        PriorityQueue<HuffmanTree> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            queue.add(new HuffmanTree(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            HuffmanTree left = queue.poll();
            HuffmanTree right = queue.poll();
            HuffmanTree node = new HuffmanTree(left, right);
            queue.add(node);
        }

        System.out.println("Huffman Tree built successfully!");
    }
}
