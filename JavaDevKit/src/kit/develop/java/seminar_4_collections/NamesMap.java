package kit.develop.java.seminar_4_collections;

import java.util.HashMap;
import java.util.Map;

//1. Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
//2. Найдите человека с самым маленьким номером телефона
//3. Найдите номер телефона человека чье имя самое большое в алфавитном порядке

public class NamesMap {

    public static void main(String[] args) {
        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("123", "Иван");
        phoneBook.put("123123", "Сергей");
        phoneBook.put("12311", "Александр");
        phoneBook.put("12", "Карина");
        phoneBook.put("911", "Елена");


        for (Map.Entry<String, String> entry: phoneBook.entrySet()){
            String key = entry.getKey();
            String val = entry.getValue();
        }

        System.out.println(phoneBook.entrySet()
                .stream().min((e1, e2) -> e1.getKey().compareTo(e2.getKey())).get().getValue());

        System.out.println(phoneBook.entrySet()
                .stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue())).get().getKey());
    }
}