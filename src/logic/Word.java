package logic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "words")
public class Word {

    private Integer id;
    private String eng;

    public Word() {
        super();
    }

    public Word(String eng) {
        super();
        this.eng = eng;
    }

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "eng")
    public String getEng() {
        return eng;
    }

    public void setEng(String eng) {
        this.eng = eng;
    }

}
