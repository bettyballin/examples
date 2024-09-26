import java.io.IOException;

public class Temp234 {
    public static void main(String[] args) {
        try {
            StringBuilder out = new StringBuilder();
            escapeJsString("Example string with special characters: \" ' \\ /", true, true, out);
            System.out.println(out.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Given a plain text string writes an unquoted javascript string literal.
     *
     * @param s the plain text string to escape.
     * @param asciiOnly Makes sure that only ASCII characters are written to out.
     *     This is a good idea if you don't have control over the charset that
     *     the javascript will be served with.
     * @param embeddable True to make sure that nothing is written to out that
     *     could interfere with embedding inside a script tag or CDATA section, or
     *     other tag that typically contains markup.
     *     This does not make it safe to embed in an HTML attribute without
     *     further escaping.
     * @param out written to.
     */
    public static void escapeJsString(
        CharSequence s, boolean asciiOnly, boolean embeddable, Appendable out)
        throws IOException {
        final int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            switch (c) {
                case '\b':
                    out.append("\\b");
                    break;
                case '\t':
                    out.append("\\t");
                    break;
                case '\n':
                    out.append("\\n");
                    break;
                case '\f':
                    out.append("\\f");
                    break;
                case '\r':
                    out.append("\\r");
                    break;
                case '\"':
                    out.append("\\\"");
                    break;
                case '\'':
                    out.append("\\'");
                    break;
                case '\\':
                    out.append("\\\\");
                    break;
                case '/':
                    if (embeddable) {
                        out.append("\\/");
                    } else {
                        out.append(c);
                    }
                    break;
                default:
                    if (asciiOnly && (c < 0x20 || c > 0x7e)) {
                        out.append(String.format("\\u%04x", (int) c));
                    } else {
                        out.append(c);
                    }
                    break;
            }
        }
    }
}