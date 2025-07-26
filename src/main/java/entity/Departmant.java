package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Departmant {

    @Id
    private Long id;
    private String name;

    @OneToMany(mappedBy = "department")
    private List<Seller> sellers;

    public Departmant() {
    }

    public Departmant(String name, Long id) {
        this.name = name;
        this.id = id;
    }

    public List<Seller> getSellers() {
        return sellers;
    }

    public void setSellers(List<Seller> sellers) {
        this.sellers = sellers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Departmant{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
