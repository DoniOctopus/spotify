package com.enigma.excercise.spotify.entity;


import com.enigma.excercise.spotify.enums.HistoryTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "mst_walletHistory")
public class WalletHistory {


    @Id
    @GeneratedValue(generator = "walletHistory_uuid",strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "walletHistory_uuid", strategy = "uuid")
    private String id;
    private Double amount;
    private Timestamp trxDate;

    @Enumerated(EnumType.STRING)
    private HistoryTypeEnum type;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    @JsonIgnoreProperties("walletHistory")
    private Wallet wallet;


    public WalletHistory(Double amount) {
        this.amount = amount;
    }

    public WalletHistory() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Timestamp getTrxDate() {
        return trxDate;
    }

    public void setTrxDate(Timestamp trxDate) {
        this.trxDate = trxDate;
    }

    public HistoryTypeEnum getType() {
        return type;
    }

    public void setType(HistoryTypeEnum type) {
        this.type = type;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "WalletHistoryService{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", trxDate=" + trxDate +
                '}';
    }
}
