package com.zhigajlo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Collection<Contact> contactList = new ArrayList<>();
        contactList.add(new Contact("Юлия", "123456789",
                LocalDate.of(1988, 12, 6)));
        contactList.add(new Contact("Святослав", "987654321",
                LocalDate.of(1988, 12, 25)));
        contactList.add(new Contact("Антон", "987658321",
                LocalDate.of(1988, 11, 25)));
        contactList.add(new Contact("Яна", "986354321",
                LocalDate.of(1988, 3, 2)));
        contactList.add(new Contact("Яна", "986354321",
                LocalDate.of(1988, 3, 2)));
        contactList.add(new Contact("Яна", "986354321",
                LocalDate.of(1988, 3, 2)));


        Collection<CallLog> callLogs = new ArrayList<>();
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123456789", TypeCall.ВХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 78, "987658321", TypeCall.ПРОПУЩЕННЫЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 120, "123456789", TypeCall.ИСХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 98, "987658321", TypeCall.ИСХОДЯЩИЙ));
        callLogs.add(new CallLog(LocalDateTime.now(), 68, "123456789", TypeCall.ВХОДЯЩИЙ));

        Collection<Message> messageCollection = new ArrayList<>();
        messageCollection.add(new Message("123456789", "Привет, я приехал"));
        messageCollection.add(new Message("987658321", "Привет, забери заказ"));
        messageCollection.add(new Message("123456789", "Привет, отправь посылку"));
        messageCollection.add(new Message("987658321", "Спам, спам"));

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

//        for (Contact contact : contactList) {
//            Collection<CallLog> calls = numberOfCalls(callLogs, contact);
//        }
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

    private Collection<CallLog> numberOfCalls(Collection<CallLog> callLogs, Contact contact) {
        List<CallLog> result = new ArrayList<>();
        for (CallLog callLog : callLogs) {
            if (callLog.numberTelephone.contains(contact.phoneNumber)) {
                result.add(callLog);
            }
        }
        return result;
    }


}
