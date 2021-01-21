/*
A Client osztály reprezentál egy ügyfelet name és regNumber attribútummal (String). Az második a regisztrációs száma, mely egyedileg
azonosít egy ügyfelet.  Írj egy Clients osztályt, mely az ügyfeleket tartja nyilván.
 Regisztrációs szám alapján le kell tudni kérdezni egy ügyfelet a findByRegNumber(String) metódussal. Dobjon IllegalArgumentException-t,
 ha nincs. Fontos, hogy nagyon gyors legyen a lekérdezés a regisztrációs szám alapján!
 Ezen kívül legyen benne egy List<Client> findByName(String) metódus is, ami pedig névtöredék alapján keres! Ez lehet lassabb.
 */
package week12.week12d04;

import java.util.*;

public class Clients {

    private Map<String, Client> clientMap = new HashMap<>();

    public void addClient(String name, String regNumber) {
        clientMap.put(regNumber, new Client(name, regNumber));
    }

    public Client findByRegNumber(String regNumber) {
        if (!clientMap.containsKey(regNumber)) {
            throw new IllegalArgumentException("Can not find client" + regNumber);
        }
        return clientMap.get(regNumber);
    }

    public List<Client> findByName(String name) {
        List<Client> clientList = new ArrayList<>();
        Collection<Client> clientCollection = clientMap.values();
        for (Client client : clientCollection) {
            if (client.getName().contains(name)) {
                clientList.add(client);
            }
        }
        return clientList;
    }



}