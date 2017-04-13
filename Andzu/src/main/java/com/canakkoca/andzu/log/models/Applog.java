package com.canakkoca.andzu.log.models;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;

import java.io.Serializable;

/**
 * Created by can.akkoca on 4/13/2017.
 */

@Entity
public class Applog implements Serializable {

    private static final long serialVersionUID = 12341L;

    @Id
    private Long id;

}
