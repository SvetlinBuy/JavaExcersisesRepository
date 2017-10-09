import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SimpleTextEditor {

    public static Deque<Character> text = new ArrayDeque<>();
    public static Deque<Character> deleted = new ArrayDeque<>();
    public static Deque<String[]> undoCommands = new ArrayDeque<>();

    public static void main(String[] args)throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            String[] commandLine = br.readLine().split("\\s+");
            String command = commandLine[0];

            if (command.equals("1") || command.equals("2"))
                undoCommands.addFirst(commandLine);

            switch (command) {
                case "1":
                    String string = commandLine[1];
                    addText(string);
                    break;
                case "2":
                    int eraseCount = Integer.parseInt(commandLine[1]);
                    eraseElements(eraseCount);
                    break;
                case "3":
                    int pos = Integer.parseInt(commandLine[1]);
                    showElement(pos);
                    break;
                case "4":
                    undo();
                    break;
            }
        }

        System.out.println();

    }

    private static void addText(String string) {
        for (int i = 0; i < string.length(); i++) {
            text.addLast(string.charAt(i));
        }
    }

    private static void eraseElements(int eraseCount) {

        for (int i = 0; i < eraseCount; i++) {
            deleted.addFirst(text.pollLast());
        }
    }

    private static void showElement(int pos) {
        int counter = 1;

        for (Character element : text) {
            if (pos == counter) {
                System.out.println(element);
                break;
            }
            counter++;
        }
    }

    private static void undo() {

        String undoCommand = undoCommands.peekFirst()[0];

        switch (undoCommand) {
            case "1":
                int elementsToErase = undoCommands.removeFirst()[1].length();
                for (int j = 0; j < elementsToErase; j++) {
                    text.pollLast();
                }
                break;
            case "2":
                int elementsToRestore = Integer.parseInt(undoCommands.removeFirst()[1]);
                for (int j = 0; j < elementsToRestore; j++) {
                    text.addLast(deleted.removeFirst());
                }
                break;
        }
    }
}
