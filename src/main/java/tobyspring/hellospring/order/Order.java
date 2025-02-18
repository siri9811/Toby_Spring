package tobyspring.hellospring.order;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String no;

    public Order() {
    }

    public Order(String no, BigDecimal total) {
        this.no = no;
        this.total = total;
    }

    private BigDecimal total;

    public Long getId() {
        return id;
    }

    public String getNo() {
        return no;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", no='" + no + '\'' +
                ", total=" + total +
                '}';
    }

    public BigDecimal getTotal() {
        return total;
    }
}
