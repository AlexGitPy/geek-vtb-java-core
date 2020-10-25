package ru.geekbrains.lesson5.homework;

public class Dictionary {

    private final Pair[] pairs;

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary(3);
        dictionary.put("1", "2");
        dictionary.put("3", "4");
        dictionary.put("5", "6");
        System.out.println(dictionary.get("1"));
        System.out.println(dictionary.get("3"));
        System.out.println(dictionary.get("5"));
        dictionary.delete("5");
        System.out.println(dictionary.get("5"));
    }

    public Dictionary(int size) {
        this.pairs = new Pair[size];
    }

    public String get(String key) {
        for (Pair pair : pairs) {
            if (pair != null) {
                if (pair.getKey().equals(key)) {
                    return pair.getValue();
                }

            } else {
                System.out.println("Key not found");
            }
        }
        return "";
    }

    public void put(String key, String value) {
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i] == null) {
                pairs[i] = new Pair(key, value);
                break;
            }
        }
    }

    public void delete(String key) {
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i].getKey().equals(key)) {
                pairs[i] = null;
                break;
            }
        }
    }

    private static class Pair {
        private final String key;

        private final String value;

        public Pair(String key, String value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

        public String getValue() {
            return value;
        }
    }

}
