package com.canakkoca.andzu.log.util;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.support.annotation.NonNull;

import com.canakkoca.andzu.base.AndzuApp;
import com.drivemode.timberlorry.buffer.AbstractBufferResolver;
import com.drivemode.timberlorry.payload.Payload;
import com.drivemode.timberlorry.payload.Record;
import com.drivemode.timberlorry.payload.Serializer;

import java.util.List;

/**
 * Created by can.akkoca on 4/13/2017.
 */

public class DbBufferResolver extends AbstractBufferResolver {

    private final AndzuApp application;

    protected DbBufferResolver(AndzuApp application,@NonNull AccountManager accountManager
            , @NonNull ContentResolver resolver, Account account) {
        super(accountManager, resolver, account);
        this.application = application;
    }

    @Override
    public void save(Serializer serializer, Payload payload) {

        Record record = new Record(payload.getClass(),serializer.serialize(payload));

    }

    @Override
    public void save(Serializer serializer, Payload... payloads) {

    }

    @Override
    public List<Record> fetch() {
        return null;
    }

    @Override
    public void remove(Record record) {

    }

    @Override
    public void clear() {

    }
}
