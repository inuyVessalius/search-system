package br.ufrn.interfaces;


public interface DBInterface {
    int addWord(String word);
    
    boolean containsWord(String word);
}