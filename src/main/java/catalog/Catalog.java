package catalog;

import java.util.ArrayList;
import java.util.List;

public class Catalog {

    protected List<CatalogItem> catalogItems = new ArrayList<>();

    public void addItem(CatalogItem catalogItem) {
        catalogItems.add(catalogItem);
    }

    public double averagePageNumberOver(int overPageNumber) {
        if (overPageNumber < 1) {
            throw new IllegalArgumentException("Page number must be positive");
        }
        int sum = 0;
        int count = 0;
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.numberOfPagesAtOneItem() > overPageNumber) {
                sum += catalogItem.numberOfPagesAtOneItem();
                count++;
            }
        }
        if (count == 0) {
            throw new IllegalArgumentException("No page");
        }
        return sum / (double) count;
    }

    public void deleteItemByRegistrationNumber(String registrationNumber) {
        CatalogItem removedItem = null;
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.getRegistrationNumber().equals(registrationNumber)) {
                removedItem = catalogItem;
            }
        }
        if (removedItem == null) {
            throw new IllegalStateException("Invalid registration number");
        }
        catalogItems.remove(removedItem);
    }

    public List<CatalogItem> findByCriteria(SearchCriteria searchCriteria) {
        List<CatalogItem> searchedList = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (searchCriteria.hasContributor()) {
                if (catalogItem.getContributors().contains(searchCriteria.getContributor())) {
                    if (!searchedList.contains(catalogItem)) {
                        searchedList.add(catalogItem);
                    }
                }
            }
            if(searchCriteria.hasTitle()) {
                if(catalogItem.getTitles().contains(searchCriteria.getTitle())) {
                    if (!searchedList.contains(catalogItem)) {
                        searchedList.add(catalogItem);
                    }
                }
            }
        }
        return searchedList;
    }

    public int getFullLength() {
        int sumOfLength =0;
        for (CatalogItem catalogItem : catalogItems) {
            sumOfLength += catalogItem.fullLengthAtOneItem();
        }
        return sumOfLength;
    }

    public List<CatalogItem> getAudioLibraryItems() {
        List<CatalogItem> audioItems = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if(catalogItem.hasAudioFeature()) {
                audioItems.add(catalogItem);
                }
            }
        return audioItems;
    }

    public int getAllPageNumber() {
        int sumOfPages = 0;
        for (CatalogItem catalogItem : catalogItems) {
            sumOfPages += catalogItem.numberOfPagesAtOneItem();
        }
        return sumOfPages;
    }

    public List<CatalogItem> getPrintedLibraryItems() {
        List<CatalogItem> printedItems = new ArrayList<>();
        for (CatalogItem catalogItem : catalogItems) {
            if (catalogItem.hasPrintedFeature()) {
                    printedItems.add(catalogItem);
            }
        }
        return printedItems;
    }
}
