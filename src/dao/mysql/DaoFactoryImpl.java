package dao.mysql;

import dao.DaoFactory;
import dao.WordDao;

public class DaoFactoryImpl implements DaoFactory{
    
    private static DaoFactoryImpl factory;
    private static WordDaoImpl word;
    
    public static synchronized DaoFactoryImpl getInstance(){
        if(factory == null){
            factory = new DaoFactoryImpl();
        }
        return factory;
    }

    @Override
    public WordDao getWordDao() {        
        if(word == null){
            word = new WordDaoImpl();
        }
        return word;
    }

}
