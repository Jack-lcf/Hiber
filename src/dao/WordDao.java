package dao;

import java.util.List;

import logic.Word;

public interface WordDao {

    public void create(Word word) throws DaoException;

    public Word getById(Integer id) throws DaoException;

    public List<Word> getAll() throws DaoException;

    public void update(Word object) throws DaoException;

    public void delete(Word word) throws DaoException;
    
    public Word getByEng(String eng) throws DaoException;

}
