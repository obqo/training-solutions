/*
Különböző felhő tárhely szolgáltatókat szeretnénk összehasonlítani, ezért a CloudStorage osztályban eltároljuk a
különböző adataikat. A tárhely mérete GB-ban adott, az árak pedig mindenhol ugyanabban a pénznemben.
A PayPeriod enum a fizetési gyakoriság, ahol a length értéke a hossz hónapokban megadva (lifetime esetén 60 hónap).
Az ingyenes csomagok esetén a fizetési gyakortiság nincs megadva. A CloudStorage implementálja a Comparable interfészt,
a természetes rendezettségét az 1000 GB-ra eső éves díj nagysága adja.
A Clouds osztály metódusai a paraméterként kapott listából bizonyos szempont szerint a legjobba(ka)t adják vissza.
Amennyiben több ugyanolyan van, akkor közülük bármelyik visszaadható.
alphabeticallyFirst(): a szolgáltató neve alapján betűrendben a legelső CloudStorage. Kis-nagybetű nem számít.
bestPriceForShortestPeriod(): a legrövidebb időszakra vonatkozó legolcsóbb CloudStorage.
Ha van ingyenes, akkor azok közül bármelyik megadható.
worstOffers(): a természetes rendezettség szerinti 3 legrosszabb ajánlat.
 */
package lambdacomparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Clouds {

    public CloudStorage alphabeticallyFirst(List<CloudStorage> storages) {
        storages.sort(Comparator.comparing(CloudStorage::getProvider, String::compareToIgnoreCase));
        return storages.get(0);
    }

    public CloudStorage bestPriceForShortestPeriod(List<CloudStorage> storages) {
        return Collections.min(storages, Comparator.comparing(CloudStorage::getPeriod,
                Comparator.nullsFirst(Comparator.comparingInt(PayPeriod::getLength)))
                .thenComparingDouble(CloudStorage::getPrice));
    }

    public List<CloudStorage> worstOffers(List<CloudStorage> storages) {
        List<CloudStorage> copyStorages = new ArrayList<>(storages);
        copyStorages.sort(Comparator.reverseOrder());
        return copyStorages.subList(0, Math.min(3, copyStorages.size()));
    }
}
