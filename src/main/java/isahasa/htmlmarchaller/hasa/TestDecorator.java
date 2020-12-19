package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public abstract class TestDecorator implements TextSource {

    private TextSource textSource;

    public TestDecorator(TextSource textSource) {
        this.textSource = textSource;
    }

    public TextSource getTextSource() { //protected
        return textSource;
    }
}
