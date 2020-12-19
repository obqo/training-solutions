package isahasa.htmlmarchaller.hasa;

import isahasa.htmlmarchaller.TextSource;

public class Underlined extends TestDecorator{

    public Underlined(TextSource textSource) {
        super(textSource);
    }

    @Override
    public String getPlainText() {
        return "<u>" + getTextSource().getPlainText() + "</u>";
    }
}
