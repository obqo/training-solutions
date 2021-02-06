/*
Hozz létre egy közösségi hálózatot, melyen kereséseket lehet végezni.
Hozz létre egy Member osztályt, name, skills (mely egy List<String>), gender attribútumokkal.
Hozz létre egy SocialNetwork osztályt, mely Member objektumokat képes tárolni.
A findFirst metódusa paraméterként egy keresési feltételt kap. Visszatérési típusa Optional.
Ha talál a keresési feltételnek megfelelő tagot, akkor az elsőt adja vissza, ha nem talál, üres értékkel tér vissza.
A averageNumberOfSkills üres értékkel tér vissza, ha a közösségi háló nem tartalmaz tagot.
Ellenkező esetben átlagolja a tagok szakértelmének számát, és azzal tér vissza.
 */
package lambdaoptional;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class SocialNetwork {

    private final List<Member> members;

    public SocialNetwork(List<Member> members) {
        this.members = members;
    }

    public Optional<Member> findFirst(Predicate<Member> condition) {
        for (Member member : members) {
            if (condition.test(member)) {
                return Optional.of(member);
            }
        }
        return Optional.empty();
    }

    public Optional<Double> averageNumberOfSkills() {
        if (members.size() == 0) {
            return Optional.empty();
        }
        int sum = 0;
        for (Member member : members) {
            sum += member.getSkills().size();
        }
        return Optional.of((double) sum / members.size());
    }
}
