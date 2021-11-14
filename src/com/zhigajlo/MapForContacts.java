package com.zhigajlo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapForContacts {

    public void mapForContacts(Collection<Contact> contacts, Collection<Message> messageCollection) {
        Map<String, Contact> contactMap = new HashMap<>();
        Map<String, Collection<Message>> groups = new HashMap<>();

        groupMessagesByContact(contacts, messageCollection, contactMap, groups);
    }

    private void groupMessagesByContact(Collection<Contact> contacts,
                                        Collection<Message> messageCollection,
                                        Map<String, Contact> contactMap,
                                        Map<String, Collection<Message>> groups) {

        Map<String, Contact> stringContactMap = new HashMap<>();
        Map<String, Collection<Message>> stringCollectionMap = new HashMap<>();

        for (Contact contact : contacts) {
        }
    }
}

