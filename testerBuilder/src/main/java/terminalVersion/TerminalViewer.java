package terminalVersion;


import java.io.*;
import java.util.Scanner;

public class TerminalViewer {

    private BufferedInputStream terminalReader;
    private BufferedOutputStream terminalWriter;
    private BufferedReader read = new BufferedReader(new InputStreamReader(new BufferedInputStream(System.in)));
    private BufferedWriter write = new BufferedWriter(new OutputStreamWriter(new BufferedOutputStream(System.out)));

    String msg;

    //private Scanner terminalInput = new Scanner(System.in);

    public String getTerminalInput() throws IOException {
        msg = read.readLine();
        return msg;
    }

    public void setTerminalWriter(String msg) throws IOException {
        write.write(msg);
    }

}
