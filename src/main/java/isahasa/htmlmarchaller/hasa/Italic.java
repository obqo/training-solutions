package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Italic extends TestDecorator{

    public Italic(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<i>" + getTextSource().getPlainText() + "</i>";
    }
}
