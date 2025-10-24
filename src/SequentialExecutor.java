public class SequentialExecutor {
    public static void main(String[] args) throws Exception {
        if(args.length != 1) {
            System.out.println("Usage: java SequentialExecutor <Makefile>");
            return;
        }

        MakefileParser parser = new MakefileParser();
        parser.parse(args[0]);

        TaskGraph graph = new TaskGraph(parser.getDeps(), parser.getCommands());
        graph.execute("all");
    }
}
