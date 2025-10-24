import java.io.*;
import java.util.*;

public class MakefileParser {
    private Map<String, List<String>> deps = new HashMap<>();
    private Map<String, String> commands = new HashMap<>();

    public void parse(String filename) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filename));
        String line;
        String currentTarget = null;

        while((line = br.readLine()) != null) {
            line = line.trim();
            if(line.isEmpty()) continue;

            if(line.contains(":")) {
                String[] parts = line.split(":");
                currentTarget = parts[0].trim();
                deps.put(currentTarget, new ArrayList<>());
                if(parts.length > 1) {
                    String[] d = parts[1].trim().split("\\s+");
                    deps.get(currentTarget).addAll(Arrays.asList(d));
                }
            } else if(line.startsWith("\t") && currentTarget != null) {
                commands.put(currentTarget, line.trim());
            }
        }

        br.close();
    }

    public Map<String, List<String>> getDeps() {
        return deps;
    }

    public Map<String, String> getCommands() {
        return commands;
    }
}
