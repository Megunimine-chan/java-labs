package task5.task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

class EncodedReader extends FilterReader {

    private final char keyChar;

    protected EncodedReader(Reader in, char keyChar) {
        super(in);
        this.keyChar = keyChar;
    }

    @Override
    public int read() throws IOException {
        int ch = super.read();
        return ch == -1 ? ch : encodeChar((char) ch);
    }

    private int encodeChar(char ch) {
        return ch + keyChar > Character.MAX_VALUE ? ch + keyChar % Character.MAX_VALUE : ch + keyChar;
    }
}
