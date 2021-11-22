package com.zhigajlo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
ДЗ 17. Задание 3.Используя отображения, сгруппируйте все звонки по контактам
(Map<String, Contact>, Map<String, List<CallLog>>)
 */
public class GroupAllCallsByContacts {

    Map<String, Contact> resultContacts = new HashMap<>();
    Map<String, Collection<CallLog>> resultCallLogs = new HashMap<>();

    public void callsByContacts(Collection<Contact> contacts, Collection<CallLog> callLogs) {

        //Используя отображения, сгруппируйте все звонки по контактам
        groupCallLogByContact(contacts, callLogs, resultContacts, resultCallLogs);
        System.out.println("Используя отображения, сгруппируйте все звонки по контактам");
        showInfoCallLogForContact(resultCallLogs);

        //Найдите все звонки для одного контакта из общей коллекции
        System.out.println("Найдите все звонки для одного контакта из общей коллекции");
        Map<String, Collection<CallLog>> resultSearchCallLogContact = new HashMap<>();
        resultSearchCallLogContact = searchCallLogForContact(resultCallLogs, "987658321");
        showInfoSearchCallLogForContact(resultSearchCallLogContact);

    }

    private void groupCallLogByContact(Collection<Contact> contacts,
                                       Collection<CallLog> callLogs,
                                       Map<String, Contact> resultContact,
                                       Map<String, Collection<CallLog>> resultCallLogs) {

        for (Contact contact : contacts) {
            Collection<CallLog> allCallLogs = findCallLogForContact(contact, callLogs);
            resultContact.put(contact.phoneNumber, contact);
            resultCallLogs.put(contact.phoneNumber, allCallLogs);
        }
    }

    private Collection<CallLog> findCallLogForContact(Contact contacts, Collection<CallLog> callLogs) {
        Collection<CallLog> result = new ArrayList<>();
        for (CallLog callLog : callLogs) {
            if (contacts.phoneNumber.equals(callLog.numberTelephone)) {
                result.add(callLog);
            }
        }
        return result;
    }

    private void showInfoCallLogForContact(Map<String, Collection<CallLog>> groupsCallLog) {
        for (Map.Entry<String, Collection<CallLog>> callLogForContact : groupsCallLog.entrySet()) {
            System.out.println(callLogForContact.getKey() + callLogForContact.getValue().size());
        }
    }

    private Map<String, Collection<CallLog>> searchCallLogForContact(Map<String, Collection<CallLog>> groupsCallLog,
                                                                     String idSearch) {
        Map<String, Collection<CallLog>> result = new HashMap<>();

        for (Map.Entry<String, Collection<CallLog>> mapCallLog : groupsCallLog.entrySet()) {
            if (mapCallLog.getKey().equals(idSearch)) {
                result.put(mapCallLog.getKey(), mapCallLog.getValue());
            }
        }
        return result;
    }

    private void showInfoSearchCallLogForContact(Map<String, Collection<CallLog>> mapInfoSearch) {
        for (Map.Entry<String, Collection<CallLog>> result : mapInfoSearch.entrySet()) {
            System.out.println(result);
        }
    }
}
