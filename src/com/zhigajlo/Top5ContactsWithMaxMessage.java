package com.zhigajlo;

import java.util.*;

public class Top5ContactsWithMaxMessage {

    public void numberOfMessage(Collection<Message> messageList, Contact contact1) {
        //ДЗ18. Задание 2.а - Найдите все сообщения для одного контакта из общей коллекции
        Map<String, Integer> resultMessageWithContact1;
        resultMessageWithContact1 = searchMessagesWithContact(messageList, contact1);
        System.out.println("\nДЗ 18. Задание 2.а - Найдите все сообщения для одного контакта из общей коллекции" +
                " - Номер телефона 123456789");
        showInfoResultSearchMessagesWithContacts(resultMessageWithContact1);

        //ДЗ18. Задание 2.b - Сохраните связь-пару контакта и количество звонков его
        Pair<String, Integer> pairContactNumbMessage;
        pairContactNumbMessage = pairContactNumbMessage(resultMessageWithContact1);
        System.out.println("\nДЗ18. Задание 2.б - Сохраните связь-пару контакта и количество звонков его\n" +
                pairContactNumbMessage);

        //ДЗ18. Задание 2.c- Поиск сообщений для каждого контакта из коллекции
        Map<String, Integer> resultMessageWithAllContacts;
        resultMessageWithAllContacts = searchMessagesWithAllContacts(messageList);
        System.out.println("\nДЗ18. Задание 2.c- Поиск сообщений для каждого контакта из коллекции");
        showInfoResultSearchMessagesWithContacts(resultMessageWithAllContacts);

        //ДЗ18. Задание 2.d - Сохраните найденные пары в линейную коллекцию
        Collection <Pair <String, Integer>> listPairContactQuantityMessages;
        listPairContactQuantityMessages = listPairContactQuantityMessages(resultMessageWithAllContacts);
        System.out.println("\nДЗ18. Задание 2.d - Сохраните найденные пары в линейную коллекцию\n" +
                listPairContactQuantityMessages);
    }

    private Map<String, Integer> searchMessagesWithContact(Collection<Message> messageList, Contact contact) {
        Map<String, Integer> messageWithContact = new HashMap<>();
        int i = 0;
        for (Message searchMessages : messageList) {
            if (searchMessages.phoneNumber.equals(contact.phoneNumber)) {
                messageWithContact.put(searchMessages.phoneNumber, i++);
            }
        }
        return messageWithContact;
    }

    private void showInfoResultSearchMessagesWithContacts(Map<String, Integer> mapMessages) {
        for (Map.Entry<String, Integer> showInfo : mapMessages.entrySet()) {
            System.out.println("Номер телефона: " + showInfo.getKey() +
                    "\nКоличество сообщений: " + showInfo.getValue());
        }
    }

    private Pair<String, Integer> pairContactNumbMessage(Map<String, Integer> resultMessageWithContact1) {
        Pair<String, Integer> result = null;
        for (Map.Entry<String, Integer> mapForResultMessagesWithContact : resultMessageWithContact1.entrySet())
            result = new Pair<>(mapForResultMessagesWithContact.getKey(), mapForResultMessagesWithContact.getValue());
        return result;
    }

    private Map<String, Integer> searchMessagesWithAllContacts(Collection<Message> messageList) {
        Map<String, Integer> result = new HashMap<>();
        for (Message message : messageList) {
            if (result.containsKey(message.phoneNumber)) {
                result.put(message.phoneNumber, result.get(message.phoneNumber) + 1);
            } else {
                result.put(message.phoneNumber, 1);
            }
        }
        return result;
    }

    private Collection<Pair<String, Integer>> listPairContactQuantityMessages (
            Map<String, Integer> resultMessageWithAllContacts){
        Collection <Pair<String, Integer>> result = new ArrayList<>();
        for(Map.Entry<String, Integer> resultCollectionPair: resultMessageWithAllContacts.entrySet()){
            result.add(new Pair<>(resultCollectionPair.getKey(),resultCollectionPair.getValue()));
        }
        return result;
    }


}

