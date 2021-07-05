package br.ufrn.client;

import br.ufrn.interfaces.DBInterface;

import java.util.ArrayList;
import java.util.List;

public class Database implements DBInterface {
    List<String> words;
    
    Database() {
        words = new ArrayList<>();
    }
    
    /**
     * Add word to in memory repository and returns its id
     *
     * @param word word to be added
     *
     * @return word id
     */
    @Override
    public int addWord(String word) {
        words.add(word);
        return words.size() - 1;
    }
    
    /**
     * Get word in memory repository
     *
     * @param word word to be recovered
     *
     * @return true if it is contained inside this repository or false otherwise
     */
    @Override
    public boolean containsWord(String word) {
        return words.contains(word);
    }
}