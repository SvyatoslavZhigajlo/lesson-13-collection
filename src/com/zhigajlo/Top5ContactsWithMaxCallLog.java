package com.zhigajlo;


import java.util.*;

public class Top5ContactsWithMaxCallLog {

    public void numberOfCalls(Collection<CallLog> callLogs) {
//        ДЗ 18.Задание 1.c - поиск для каждого контакта из коллекции
        Map<String, Integer> numberOfCalls = new HashMap<>();
        numberOfCalls = numberOfCall(callLogs);
        System.out.println("ДЗ 18.Задание 1.c - поиск для каждого контакта из коллекции");
        showInfoMapNumberOfCalls(numberOfCalls);
//        ДЗ 18.Задание 1.d - Сохраните найденные пары в линейную коллекцию
        List<Pair<String, Integer>> pairList = new ArrayList<>();
        pairList = setPairWithCalls(numberOfCalls);
        System.out.println("ДЗ 18.Задание 1.d - Сохраните найденные пары в линейную коллекцию");
        showInfoPairList(pairList);
//        ДЗ 18.Задание 1.е - Отсортируйте коллекцию по убыванию количества звонков
        System.out.println("ДЗ 18.Задание 1.е - Отсортируйте коллекцию по убыванию количества звонков");
        sortList(pairList);


    }

    private Map<String, Integer> numberOfCall(Collection<CallLog> callLogs) {
        Map<String, Integer> result = new HashMap<>();
        for (CallLog callLog : callLogs) {
            if (result.containsKey(callLog.numberTelephone)) {
                result.put(callLog.numberTelephone, result.get(callLog.numberTelephone) + 1);
            } else {
                result.put(callLog.numberTelephone, 1);
            }
        }
        return result;
    }

    private List<Pair<String, Integer>> setPairWithCalls(Map<String, Integer> numberOfCalls) {
        List<Pair<String, Integer>> result = new ArrayList<>();
        for (Map.Entry<String, Integer> mapWithPair : numberOfCalls.entrySet()) {
            result.add(new Pair(mapWithPair.getKey(), mapWithPair.getValue()));
        }
        return result;
    }

    private void showInfoPairList(List<Pair<String, Integer>> pairList){

        for (Pair showInfoPairList: pairList){
//            Pair <String, Integer> showInfoPair = new Pair<>();
            System.out.println(showInfoPairList.toString());
        }
    }

    private void showInfoMapNumberOfCalls(Map<String, Integer> numberOfCalls ){
        for (Map.Entry<String,Integer> showInfoMap:
             numberOfCalls.entrySet()) {
            System.out.println("Номер телефона: " + showInfoMap.getKey() +
                                "Количество звонков: " + showInfoMap.getValue());
        }
    }

        private void sortList (List < Pair < String, Integer >> pairList){

    }
}
