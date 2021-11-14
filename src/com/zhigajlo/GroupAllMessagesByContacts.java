package com.zhigajlo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
/*
ДЗ 17. Задание 2.
Используя отображения, сгруппируйте все сообщения по контактам (Map<String, Contact>, Map<String, List<Message>>).
Найдите все сообщения для одного контакта из общей коллекции
Повторите поиск для каждого контакта из коллекции
Сохраните результаты поисков в Map<>, где ключом выступает либо номер телефона, либо
сам Contact (при условии реализации equals/hashCode)
 */

public class GroupAllMessagesByContacts {

    public void mapForContacts(Collection<Contact> contacts, Collection<Message> messageCollection) {
        Map<String, Contact> resultContacts = new HashMap<>();
        Map<String, Collection<Message>> resultGroups = new HashMap<>();

        //Используя отображения, сгруппируйте все сообщения по контактам
        groupMessagesByContact(contacts, messageCollection, resultContacts, resultGroups);
        System.out.println("Используя отображения, сгруппируйте все сообщения по контактам");
        showInfoAllMessagesForContact(resultGroups);

        //Найдите все сообщения для одного контакта из общей коллекции
        System.out.println("Найдите все сообщения для одного контакта из общей коллекции");
        Map<String, Collection<Message>> resultSearchMessageContact = new HashMap<>();
        resultSearchMessageContact = searchMessagesForContact(resultGroups, "987658321");
        showInfoSearchMessagesForContact(resultSearchMessageContact);

    }

    private void groupMessagesByContact(Collection<Contact> contacts,
                                        Collection<Message> messageCollection,
                                        Map<String, Contact> resultContacts,
                                        Map<String, Collection<Message>> resultGroups) {

        for (Contact contact : contacts) {
            Collection<Message> group = findMessageForContact(contact, messageCollection);
            resultContacts.put(contact.phoneNumber, contact);
            resultGroups.put(contact.phoneNumber, group);
        }
    }

    private Collection<Message> findMessageForContact(Contact contact, Collection<Message> messageCollection) {
        Collection<Message> result = new ArrayList<>();
        for (Message message : messageCollection) {
            if (contact.phoneNumber.equals(message.phoneNumber)) {
                result.add(message);
            }
        }
        return result;
    }

    private void showInfoAllMessagesForContact(Map<String, Collection<Message>> groupsMessage) {
        for (Map.Entry<String, Collection<Message>> messagesForContact : groupsMessage.entrySet()) {
            System.out.println(messagesForContact.getKey() + messagesForContact.getValue());
        }
    }

    private Map<String, Collection<Message>> searchMessagesForContact(Map<String, Collection<Message>> groupsMessage,
                                                                      String idSearch) {
        Map<String, Collection<Message>> result = new HashMap<>();

        for (Map.Entry<String, Collection<Message>> map : groupsMessage.entrySet()) {
            if (map.getKey().equals(idSearch)) {
                result.put(map.getKey(), map.getValue());
            }
        }
        return result;
    }

    private void showInfoSearchMessagesForContact(Map<String, Collection<Message>> mapInfoSearch) {
        for (Map.Entry<String, Collection<Message>> result : mapInfoSearch.entrySet()) {
            System.out.println(result);
        }
    }
}

