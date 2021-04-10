package com.epam.rd.java.basic.practice4;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part4 implements Iterable<String> {
    private String[] sentences = new String[0];
    private String text;

    public Part4() {
        text = Part2.readData(Demo.DIRECTORY + "part4.txt");
        Matcher matcher = Pattern.compile(Demo.LINE_SEP).matcher(text);
        text = matcher.replaceAll(" ");
    }

    public static void main(String[] args) {
        Part4 p4 = new Part4();
        Iterator<String> iterator = p4.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new IteratorImpl();
    }

    private class IteratorImpl implements Iterator<String> {
        private int index = 0;
        private Matcher matcher = Pattern.compile("\\b(\\p{InCyrillic}|[A-Z]).+?\\.").matcher(text);

        public IteratorImpl() {
            StringBuilder container = new StringBuilder();
            while(matcher.find()) {
                String sentence = text.substring(matcher.start(), matcher.end());
                container.append(sentence);
                container.append("#");
            }
            sentences = container.toString().split("#");
        }

        @Override
        public boolean hasNext() {
            return index < sentences.length;
        }

        @Override
        public String next() {
            if (index >= sentences.length) { throw new NoSuchElementException(); }
            String s = sentences[index++];
            if (s == null) return "null";
            return s;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
