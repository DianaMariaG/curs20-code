package ro.fasttrackit.curs20.homework.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

import static ro.fasttrackit.curs20.homework.StringUtils.ensureNotEmpty;
import static ro.fasttrackit.curs20.homework.StringUtils.ensureNotNegative;

@Entity
public class Transaction {
    @Id
    @GeneratedValue
    private int id;
    private String product;
    private Type type;
    private Double amount;

    public Transaction(){
    }

    public Transaction(String product, Type type, Double amount) {
        this.product = ensureNotEmpty(product);
        this.type = type;
        this.amount = ensureNotNegative(amount);
    }

    public String getProduct() {
        return product;
    }

    public Type getType() {
        return type;
    }

    public Double getAmount() {
        return amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Double.compare(that.amount, amount) == 0 && Objects.equals(product, that.product) && type == that.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, type, amount);
    }
}