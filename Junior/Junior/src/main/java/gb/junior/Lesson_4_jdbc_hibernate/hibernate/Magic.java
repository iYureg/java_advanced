package gb.junior.Lesson_4_jdbc_hibernate.hibernate;

import jakarta.persistence.*;
import lombok.Setter;

@Entity
@Table(name = "magic")
public class Magic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "название")
    private String name;
    @Column(name = "повреждение")
    private int damage;
    @Column(name = "атака")
    private int attack;
    @Column(name = "броня")
    private int defence;

    @Override
    public String toString() {
        return "Magic{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", damage=" + damage +
                ", attack=" + attack +
                ", defence=" + defence +
                '}';
    }

    public Magic() {
    }

    public Magic(String name, int damage, int attack, int defence) {
        this.name = name;
        this.damage = damage;
        this.attack = attack;
        this.defence = defence;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
}
