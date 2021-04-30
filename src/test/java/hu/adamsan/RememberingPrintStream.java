package hu.adamsan;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class RememberingPrintStream extends PrintStream {
    private List<String> content = new ArrayList<>();

    public RememberingPrintStream(OutputStream out) {
        super(out);
    }

    @Override
    public void println(String str) {
        content.add(str);
        super.println(str);
    }

    public String getContent() {
        return content.stream().collect(Collectors.joining("\n"));
    }

}
