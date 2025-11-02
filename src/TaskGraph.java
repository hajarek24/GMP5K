import java.io.*;
import java.util.*;

public class TaskGraph {
    private Map<String, List<String>> deps;
    private Map<String, String> commands;
    private Set<String> executed = new HashSet<>();

    public TaskGraph(Map<String, List<String>> deps, Map<String, String> commands) {
        this.deps = deps;
        this.commands = commands;
    }

    public void execute(String target) throws Exception {
        if(executed.contains(target)) return;

        // exécuter les dépendances d'abord
        List<String> depList = deps.getOrDefault(target, new ArrayList<>());
        for(String dep : depList) {
            execute(dep);
        }

        // exécuter la commande
        String cmd = commands.get(target);
        if(cmd != null) {
            System.out.println("Executing: " + cmd);
            ProcessBuilder pb = new ProcessBuilder("bash", "-c", cmd);
            pb.directory(new File(System.getProperty("user.dir"))); // GMP5K
            pb.inheritIO();
            Process p = pb.start();
            p.waitFor();
        }


        executed.add(target);
    }
}

