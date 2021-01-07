package exam02.cv;

//import a.C;

import java.util.ArrayList;
import java.util.List;

public class Cv {

    private String name;
    private List<Skill> skills = new ArrayList();

    public Cv(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void addSkills(String ... strings) {
        for (String string : strings) {
            String skillName = string.substring(0, string.indexOf(" ("));
            String skillLevel = string.substring(string.indexOf(" (") + 2, string.indexOf(" (") + 3);
            this.skills.add(new Skill(skillName, Integer.parseInt(skillLevel)));
        }
    }

    public int findSkillLevelByName(String skillName) {
        int result = 0;
        for (Skill skill : skills) {
            if (skill.getName().equals(skillName)) {
                result = skill.getLevel();
            }
        }
        if (result ==0) {
            throw new SkillNotFoundException();
        }
        return result;
    }


}