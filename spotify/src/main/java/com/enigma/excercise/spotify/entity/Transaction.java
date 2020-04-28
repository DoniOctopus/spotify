package com.enigma.excercise.spotify.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


@Entity
@Table(name = "mst_transaction")
public class Transaction {

    @Id
    @GeneratedValue(generator = "transaction_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "transaction_uuid", strategy = "uuid")
    private String id;
    private Timestamp trxDate;
    private Double amount;
    private Double albumDisc;

    @ManyToOne
    @JoinColumn(name = "song_id")
    @JsonIgnoreProperties("transactions")
    private Song item;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    @JsonIgnoreProperties("transactions")
    private Wallet wallet;


    public Transaction(Double amount) {
        this.amount = amount;
    }

    public Transaction() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Timestamp getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Timestamp trxDate) {
        this.trxDate = trxDate;
    }

    public Double getAlbumDisc() {
        return albumDisc;
    }

    public void setAlbumDisc(Double albumDisc) {
        this.albumDisc = albumDisc;
    }

    public Song getItem() {
        return item;
    }

    public void setItem(Song item) {
        this.item = item;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "TransactionRepository{" +
                "id='" + id + '\'' +
                ", trxDate=" + trxDate +
                ", albumDisc=" + albumDisc +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Transaction)) return false;
        Transaction that = (Transaction) o;
        return id.equals(that.id) &&
                trxDate.equals(that.trxDate) &&
                amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, trxDate, amount);
    }
}
