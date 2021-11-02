package ru.mail.polis.homework.collections.structure;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Задание оценивается в 2 балла.
 * Одна из самых популярных задач.
 * Наша структура хранит обрывки слов. Надо реализовать метод positionPartString
 * который вернет: позиции где находятся подстроки, из которых можно составить
 * переданное слово. Так же известно что слова, которые писались в структуру, изначально
 * делились пополам для записи в нее.
 * Отрабатывать метод должен за О(n).
 */
public class SearchInTheShredderList {
    private List<String> partStrings = new ArrayList<>();

    public SearchInTheShredderList() {
    }

    public SearchInTheShredderList(List<String> partStrings) {
        this.partStrings = partStrings;
    }

    public void add(String value) {
        partStrings.add(value);
    }

    public String get(int index) {
        return partStrings.get(index);
    }

    /**
     * Ищем позиции подстрок из которых можно составить передаваемое слово
     *
     * @param value - передаваемоей слово
     * @return - либо массив с реальными позициями подстрок если нашли, либо - null
     */
    public int[] positionPartString(String value) {
        if (value == null || value.isEmpty()) {
            return null;
        }
        Map<String, Integer> additions = new HashMap<>();

        int index = 0;
        for (String string : partStrings) {
            if (additions.containsKey(string)) {
                if (value.startsWith(string)) {
                    return new int[]{index, additions.get(string)};
                }
                return new int[]{additions.get(string), index};
            } else if (value.endsWith(string) || value.startsWith(string)) {
                additions.put(value.replaceFirst(string, ""), index);
            }
            index++;
        }
        return null;
    }
}
