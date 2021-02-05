/*
Hozz létre egy közösségi hálózatot, melyben a fejvadászok mindenféle műveletet tudnak végezni a tagokkal.
Hozz létre egy Member osztályt, name, skills (mely egy List<String>), gender és messages (List<String>) attribútumokkal.
Hozz létre benne egy sendMessage(String) metódust, mely a paraméterként kapott üzenetet beteszi a messages listába.
Hozz létre egy SocialNetwork osztályt, mely Member objektumokat képes tárolni. A findMembersBy() metódusa a paraméterként
átadott feltétel alapján kigyűjti a tagokat. A applyToSelectedMembers() a paraméterként átadott feltételnek megfelelő tagokon
végez valamilyen műveletet (2. paraméterként átadva). A transformMembers() metódus minden tagon valamilyen transzformációt végez.
Implementációs javaslat
Egy feltétel átadásához használj Predicate interfészt. Egy művelet átadásához használj Consumer interfészt.
Konvertáláshoz használj Function interfészt.
A transformMembers() metódus elég erősen használ generikust, nézd meg, hogy kell a metódusban definiálni,
és használni is generikust.
 */
package lambdaintro;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SocialNetwork {

    private final List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public List<Member> findMembersBy(Predicate<Member> predicate) {
        List<Member> found = new ArrayList<>();
        for (Member member: members) {
            if (predicate.test(member)) {
                found.add(member);
            }
        }
        return found;
    }

    public void applyToSelectedMembers(Predicate<Member> predicate, Consumer<Member> consumer) {
        for (Member member: members) {
            if (predicate.test(member)) {
                consumer.accept(member);
            }
        }
    }

    public <T> List<T> transformMembers(Function<Member, T> function) {
        List<T> transformed = new ArrayList<>();
        for (Member member: members) {
            transformed.add(function.apply(member));
        }
        return transformed;
    }
}
