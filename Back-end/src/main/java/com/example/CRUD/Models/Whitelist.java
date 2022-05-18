package com.example.CRUD.Models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("whitelist")
public class Whitelist
{
    public String _id;
    public String ip;

    public Whitelist() {
    }

    public Whitelist(String _id, String ip) {
        this._id = _id;
        this.ip = ip;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
