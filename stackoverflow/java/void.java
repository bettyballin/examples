public static void escapeJsString(CharSequence s, boolean asciiOnly, boolean embeddable, Appendable out) throws IOException {
    for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c > 0x7f && asciiOnly) {
            out.append(String.format("\\u%04x", (int) c));
        } else {
            switch (c) {
                case '\b': out.append("\\b"); break;
                case '\f': out.append("\\f"); break;
                case '
': out.append("\
"); break;
                case '\r': out.append("\\r"); break;
                case '\t': out.append("\\t"); break;
                case '\\': out.append("\\\\"); break;
                case '/': if (embeddable) out.append("\\/"); else out.append("/"); break;
                case '"': out.append("\\\""); break;
                case '>': if (embeddable) out.append("\\x3e"); else out.append(">"); break;
                case '<': if (embeddable) out.append("\\x3c"); else out.append("<"); break;
                case '&': if (embeddable) out.append("\\x26"); else out.append("&"); break;
                default: out.append(c);
            }
        }
    }
}