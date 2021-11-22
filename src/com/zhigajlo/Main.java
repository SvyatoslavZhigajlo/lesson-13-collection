package com.zhigajlo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Contact contact1 = new Contact("Юлия", "123456789",
                LocalDate.of(1988, 12, 6));
        Contact contact2 = new Contact("Святослав", "987654321",
                LocalDate.of(1988, 12, 25));
        Contact contact3 = new Contact("Антон", "987658321",
                LocalDate.of(1988, 11, 25));
        Contact contact4 = new Contact("Яна", "986354321",
                LocalDate.of(1988, 3, 2));
        Contact contact5 = new Contact("Яна", "986354321",
                LocalDate.of(1988, 3, 2));
        Contact contact6 = new Contact("Яна", "986354321",
                LocalDate.of(1988, 3, 2));

        Collection<Contact> contactList = new ArrayList<>();
        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        contactList.add(contact6);


        Collection<CallLog> callLogs = new ArrayList<>();
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123456789", TypeCall.ВХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 78, "987658321", TypeCall.ПРОПУЩЕННЫЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 120, "123456789", TypeCall.ИСХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 98, "987658321", TypeCall.ИСХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123456789", TypeCall.ВХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123476789", TypeCall.ВХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123475689", TypeCall.ВХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123456689", TypeCall.ВХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123457869", TypeCall.ВХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123445389", TypeCall.ВХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123456789", TypeCall.ВХОДЯЩИЙ));

        Collection<Message> messageCollection = new ArrayList<>();
        messageCollection.add(new Message("123456789", "Привет, я приехал"));
        messageCollection.add(new Message("123456789", "Привет, я приехал"));
        messageCollection.add(new Message("123456789", "Привет, я приехал"));
        messageCollection.add(new Message("123456789", "Привет, я приехал"));
        messageCollection.add(new Message("123456789", "Привет, я приехал"));
        messageCollection.add(new Message("987658321", "Привет, забери заказ"));
        messageCollection.add(new Message("123456789", "Привет, отправь посылку"));
        messageCollection.add(new Message("987658321", "Спам, спам"));
        messageCollection.add(new Message("984458321", "Спам, спам"));
        messageCollection.add(new Message("984358321", "Спам, спам"));

        Collection<Contact> resultSearchContact = searchContact(contactList, "123456789");
        System.out.println(("\nРезультат поиска контакта").toUpperCase());
        showInfoResultContact(resultSearchContact);

        Collection<CallLog> resultSearchCallLog = searchCallLog(callLogs, "987658321");
        showInfoResultCallLog(resultSearchCallLog);

        Collection<Message> resultSearchMessage = searchMessage(messageCollection, "987658321");
        showInfoResultMessage(resultSearchMessage);

        //Определить и вывести уникальные элементы в коллекциях контактов,
        // звонков и сообщений (List<Contact>, Set<Contact>)
        Collection<Contact> uniqueContactElements = new HashSet<>(contactList);
        Collection<CallLog> uniqueCallLogElements = new HashSet<>(callLogs);
        Collection<Message> uniqueMessageElements = new HashSet<>(messageCollection);
        System.out.println(("Результат ДЗ17. Задание 1. \n" +
                "Определить и вывести уникальные элементы в коллекциях контактов, звонков и сообщений").toUpperCase());
        showInfoResultContact(uniqueContactElements);
        showInfoResultCallLog(uniqueCallLogElements);
        showInfoResultMessage(uniqueMessageElements);

        //Запуск ДЗ17. Задание 2.
        GroupAllMessagesByContacts mapForContacts = new GroupAllMessagesByContacts();
        mapForContacts.mapForContacts(uniqueContactElements, messageCollection);


        //Запуск ДЗ17. Задание 3
        GroupAllCallsByContacts callsByContacts = new GroupAllCallsByContacts();
        callsByContacts.callsByContacts(uniqueContactElements, callLogs);

        //Запуск ДЗ18. Задание 1
        Top5ContactsWithMaxCallLog top5ContactsWithMaxCallLog = new Top5ContactsWithMaxCallLog();
        top5ContactsWithMaxCallLog.numberOfCalls(callLogs);

        Top5ContactsWithMaxMessage top5ContactsWithMaxMessage = new Top5ContactsWithMaxMessage();
        top5ContactsWithMaxMessage.numberOfMessage(messageCollection, contact1);


    }

    private Collection<Contact> searchContact(Collection<Contact> contactList, String search) {
        Collection<Contact> result = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.phoneNumber.contains(search)) {
                result.add(contact);
            }
        }
        return result;
    }

    private void showInfoResultContact(Collection<Contact> result) {
        for (Contact contact : result) {
            System.out.println("\tНомер телефона: " + contact.phoneNumber +
                    "\n\tИмя: " + contact.name +
                    "\n\tДень рождения: " + contact.birthday +
                    "\n\t---------------------");
        }
    }

    private Collection<CallLog> searchCallLog(Collection<CallLog> callLogsList, String search) {
        Collection<CallLog> result = new ArrayList<>();
        for (CallLog callLog : callLogsList) {
            if (callLog.numberTelephone.contains(search)) {
                result.add(callLog);
            }
        }
        return result;
    }

    private void showInfoResultCallLog(Collection<CallLog> callLogs) {
        System.out.println(("\nРезультат поиска звонка").toUpperCase());
        for (CallLog callLog : callLogs) {
            System.out.println("\t" + callLog.typeCall +
                    "\n\tНомер телефона: " + callLog.numberTelephone +
                    "\n\tПродолжительность разговора: " + callLog.callDuration + " сек" +
                    "\n\tДата звонка: " + callLog.dateTime +
                    "\n\t---------------------");
        }
    }

    private Collection<Message> searchMessage(Collection<Message> messageCollection, String search) {
        Collection<Message> result = new ArrayList<>();
        for (Message message : messageCollection) {
            if (message.phoneNumber.contains(search)) {
                result.add(message);
            }
        }
        return result;
    }

    private void showInfoResultMessage(Collection<Message> messageCollection) {
        System.out.println(("\nРезультат поиска сообщения").toUpperCase());
        for (Message message : messageCollection) {
            System.out.println("\tНомер телефона: " + message.phoneNumber +
                    "\n\tТекст сообщения: " + message.message +
                    "\n\t---------------------");

        }
    }


}
