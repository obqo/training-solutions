package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> members = new ArrayList<>();

    public void addMember(String name) {
        Member member = new Member(name);
        members.add(member);
    }

    public void connect(String name, String otherName) {
        Member member = findByName(name);
        member.connectMember(findByName(otherName));
    }

    private Member findByName(String name) {
        for (Member member : members) {
            if (member.getName().equals(name)) {
                return member;
            }
        }
        return null;
    }

    public List<String> bidirectionalConnections() {
        List<String> connections = new ArrayList<>();
        for (Member member :  members) {
            for (Member connect : member.getConnections()) {
                if(connect.getConnections().contains(member)) {
                    connections.add(member.getName() + " - " + connect.getName());
                }
            }
        }
        return connections;
    }

    @Override
    public String toString() {
        return members.toString();
    }
}
