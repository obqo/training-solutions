/*
Készítsd el a Site (telek) nevű osztályt. Egy telek jellemzői, páros vagy páratlan oldalon található, (0 = páros oldal 1 = páratlan oldal),
a telek hossza méterben. Illetve egy Fence enum, ami a kerítés állapotát írja le. A kerités állapota lehet, PERFECT, NEED_UPGRADE, NO_FENCE.
(konstruktor, getterek)

Készítsd el a Street nevű osztályt, melyben eladott telkek listája található. Kezdetben ez egy üres lista.
Készíts egy sellSite(Site site) metódust, ami egy telek eladását reprezentálja, vagyis hozzádunk egy telket a listához.

Határozd meg az utoljára eladott telek (lista utolsó eleme) házszámát, ha tudjuk, hogy a telkeket a két oldalon egymás után adták el!
(páros oldalon kettőtől, páratlan oldalon 1-től indul a számozás)
pl:
0 10 PERFECT
0 7 NEED_UPGRADE
1 12 NEED_UPGRADE
0 9 PERFECT
0 11 NO_FENCE
1 13 PERFECT
A példában a házszámok rendre: 2,4,1,6,8,3

Készíts statisztikát, ami a kerítés állapota alapján visszaadja, hogy mennyi telket adtak el kerítésfajtánként! (Egy metódus legyen,
a visszatérési értéket ti döntitek el, de abból legyen egyértelmű, hogy melyikből mennyit adtak el.)
 */
package week12.week12d02;

import java.util.ArrayList;
import java.util.List;

public class Street {

    private int odd = -1;//parlan
    private int even = 0;

    private List<Site> sites = new ArrayList<>();

    public void sellSite(Site site) {
        if (site.getSide() == Side.EVEN_SIDE) {
            even += 2;
            site.setHouseNumber(even);
        } else {
            odd += 2;
            site.setHouseNumber(odd);
        }
        sites.add(site);
    }

    public List<Site> getSites() {
        return new ArrayList<>(sites);
    }

    public int lastSiteHouseNumber() {
        int last = sites.size() - 1;
        return sites.get(last).getHouseNumber();
    }

    public List<ReportFence> report() {
        List<ReportFence> result = new ArrayList<>();
        int[] counter = new int[Fence.values().length];
        for (Site item : sites) {
            counter[item.getFence().getValue()]++;
        }
        for (Fence item : Fence.values()) {
            result.add(new ReportFence(item, counter[item.getValue()]));
        }

        return result;
    }
}