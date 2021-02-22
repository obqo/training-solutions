/*
Egy levelet egy Mail osztály tárol, a következő attribútumokkal: feladó, címzettek, tárgy és szöveg.
A feladót és a címzetteket egy Contract tárol, melynek két attribútuma van: viselt név és e-mail cím.
A MailBox tárolja a leveleket egy Mail listában. Ennek legyen egy findByCriteria() metódusa,
mely paraméterként egy keresési feltételt vár, és leveleket ad vissza.
A keresési feltételek lehetnek:
from:John Doe vagy from:johndoe@example.com - from: előtaggal visszaadja az összes olyan levelet,
ahol a feladó neve vagy e-mail címe pontosan a from: után szereplő szöveg
to:John Doe vagy to:johndoe@example.com - to: előtaggal visszaadja az összes olyan levelet,
ahol a címzettek között szerepel olyan, akinek a neve vagy e-mail címe pontosan a to: után szereplő szöveg
egyéb esetben visszaadja az összes olyan levelet, amiben szerepel a tárgyban vagy üzenetben a megadott szó
 */
package exam03retake01;

import java.util.ArrayList;
import java.util.List;

public class MailBox {

    private final List<Mail> mails = new ArrayList<>();

    public void addMail(Mail mail) {
        mails.add(mail);
    }

    public List<Mail> getMails() {
        return mails;
    }

    public List<Mail> findByCriteria(String str) {
        List<Mail> result = new ArrayList<>();
        if (str.contains(":")) {
            String[] splitStr = str.split(":");
            if (splitStr[0].equals("from")) {
                result.addAll(searchByFrom(splitStr[1]));
            } else if (splitStr[0].equals("to")) {
                result.addAll(searchByTo(splitStr[1]));
            } else {
                result.addAll(searchByMessageOrSubject(str));
            }
        } else {
            result.addAll(searchByMessageOrSubject(str));
        }
        return result;
    }

    private List<Mail> searchByFrom(String str) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getFrom().getName().equals(str) || mail.getFrom().getEmail().equals(str)) {
                result.add(mail);
            }
        }
        return result;
    }

    private List<Mail> searchByTo(String str) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            for (Contact contact : mail.getTo()) {
                if (contact.getName().equals(str) || contact.getEmail().equals(str)) {
                    result.add(mail);
                }
            }
        }
        return result;
    }

    private List<Mail> searchByMessageOrSubject(String str) {
        List<Mail> result = new ArrayList<>();
        for (Mail mail : mails) {
            if (mail.getSubject().contains(str) || mail.getMessage().contains(str)) {
                result.add(mail);
            }
        }
        return result;
    }
}
