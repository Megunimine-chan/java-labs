package task5.task3;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

class DecodedWriter extends FilterWriter {

    private final char keyChar;

    protected DecodedWriter(Writer out, char keyChar) {
        super(out);
        this.keyChar = keyChar;
    }

    @Override
    public void write(int c) throws IOException {
        super.write(decodeChar((char) c));
    }

    @Override
    public void write(String str) throws IOException {
        super.write(str.chars().map(ch -> decodeChar((char) ch)).toString());
    }

    @Override
    public void write(char[] cbuf) throws IOException {
        super.write(new String(cbuf));
    }

    @Override
    public void write(String str, int off, int len) throws IOException {
        super.write(str.chars().map(ch -> decodeChar((char) ch)).toString(), off, len);
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        super.write(new String(cbuf).chars().map(ch -> decodeChar((char) ch)).toString(), off, len);
    }

    private int decodeChar(char ch) {
        return ch - keyChar < 0 ? Character.MAX_VALUE + ch - keyChar : ch - keyChar;
    }
}
